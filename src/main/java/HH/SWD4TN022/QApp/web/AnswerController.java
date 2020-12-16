package HH.SWD4TN022.QApp.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerRepository;
import HH.SWD4TN022.QApp.domain.AnswerStatistics;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;
import net.minidev.json.JSONObject;

@CrossOrigin
@Controller
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	//saves an answer to a question (endpoint has the questionId)
	@PostMapping("/answers/{id}")
	public @ResponseBody Answer saveAnswerRest(@PathVariable("id") Long questionId, @RequestBody Answer answer) { //RequestBody gets data from JSON to server, ResponseBody sends JSON to browser
		Question question = questionRepository.findById(questionId).get();
		answer.setQuestion(question);
		return answerRepository.save(answer);
	}
	
	
	//endpoint does not have questionId-parameter, instead server receives it from JSON, example JSON:{"answerBody":"The Mouse", "question": {"questionId":2} }
	//this style enables receiving a list of answers
	@PostMapping("/saveanswer")
	public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
		return answerRepository.save(answer);
	}
	
    
   // RESTful service to get AnswerStatistics
    @GetMapping(value="/answerstatistics/{id}")
    public @ResponseBody List<AnswerStatistics> getAnswerStatisticsRest(@PathVariable("id") Long questionId) {
    	
    	List<Answer> answers = new ArrayList<Answer>();
    	for (Answer answer : answerRepository.findAll()) {
    		if(answer.getQuestion().getQuestionId() == questionId) {
    			answers.add(answer);
    		}
    	}
    	List<String> answerBodys = new ArrayList<String>();
    	for(Answer answer : answers) {
    		answerBodys.add(answer.getAnswerBody());
    	}
    	Set<String> set = new HashSet<>(answerBodys);

    	List<String> protot = new ArrayList<String>();
    	protot.addAll(set);
    	System.out.println(protot);
    	
    	List<AnswerStatistics> stats = new ArrayList<AnswerStatistics>();
    	AnswerStatistics newStat = new AnswerStatistics();
    	
    	for(String proto : protot) {
    		long count = 0;
    		for(Answer answer : answers) {
    			
    			if(proto == answer.getAnswerBody()) {
    				count++;
    				newStat = new AnswerStatistics(answer.getAnswerBody(), count);
    				boolean found = false;
    				
    				for(AnswerStatistics stat : stats) {
    					if(stat.getAnswerOptionBody() == newStat.getAnswerOptionBody()) {
    						
    						found = true;
        					stat.setCount(stat.getCount() + 1);
    					}
    				}
    				
    				if(!found) {
    					stats.add(new AnswerStatistics(answer.getAnswerBody(), count));
    				}
    			}
    		}
    	}
        return stats;
    }

    
  
    // Answer Statistics for selected question with id
  	@RequestMapping(value="/statistics/{id}")
    public String getAnswerStatistics(@PathVariable("id") Long questionId, Model model){
    	
    	model.addAttribute("questionId", questionId);
    	
    	Question question = questionRepository.findById(questionId).get();
    	Long surveyId = question.getSurvey().getSurveyId();
    	Survey survey = surveyRepository.findById(surveyId).get();
    	model.addAttribute("survey", survey);
    	
    	return "statistics"; 
    }
	
}
