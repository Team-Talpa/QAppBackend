package HH.SWD4TN022.QApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.QuestionTypeRepository;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@CrossOrigin
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private QuestionTypeRepository questiontypeRepository;
	
	
	@RequestMapping("/questionlist/{id}")
	public String questions(@PathVariable("id") Long surveyId, Model model) {
		Survey survey = surveyRepository.findById(surveyId).get();
		model.addAttribute("questions", survey.getQuestions());
		model.addAttribute("survey", survey);
		return "questionlist";
	}

	
	//add question without survey id
	@RequestMapping(value = "/addquestion")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}
	
	//adds a new question
	@RequestMapping(value = "/addquestion/{id}")
	public String addQuestionTo(@PathVariable("id") Long surveyId, Model model) {

		Question question = new Question();
		
		Survey survey = surveyRepository.findById(surveyId).get();
		question.setSurvey(survey);
		model.addAttribute("question", question);
		
		List<QuestionType> types = (List<QuestionType>) questiontypeRepository.findAll();
		
		model.addAttribute("questiontypes", types);
		
		System.out.print(questiontypeRepository.findAll());
		return "addquestion";
	}
	
	@RequestMapping(value = "/savequestion", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		questionRepository.save(question);
		return "redirect:surveylist";
	}
	
	
	//TODO
	//editQuestion() --> editquestion.html 
	//saveQuestion()
	//deleteQuestion(), essential crud-function, needed for sprint 1?
	
}


