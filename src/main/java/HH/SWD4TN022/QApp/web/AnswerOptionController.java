package HH.SWD4TN022.QApp.web;

import java.util.List;
import java.util.Optional;

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

import HH.SWD4TN022.QApp.domain.AnswerOption;
import HH.SWD4TN022.QApp.domain.AnswerOptionRepository;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@CrossOrigin
@Controller
public class AnswerOptionController {
	
	@Autowired
	private AnswerOptionRepository answerOptionRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	//why do we have this?
	//method retrieves list of all answeroptions
	@GetMapping("/answeroptions")
	public @ResponseBody List<AnswerOption> answerOptionListRest() {
		return (List<AnswerOption>) answerOptionRepository.findAll();
	}	
	//method retrieves single answeroption with answeroptionId
	@RequestMapping(value="/answeroptions/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<AnswerOption> findAnswerOptionRest(@PathVariable("id") Long answerOptionId) {	
    	return answerOptionRepository.findById(answerOptionId);
    }
	
	
	//method to add answerOption to a question
	@RequestMapping(value = "/addansweroption")
	public String addAnswerOption(Model model) {
		model.addAttribute("answerOption", new AnswerOption());
		return "addansweroption";
	}
	
	//method to add answerOption to a question with question id
	@RequestMapping(value = "/addansweroption/{id}")
	public String addAnswerOption(@PathVariable("id") Long questionId, Model model) {
			
			Question question = questionRepository.findById(questionId).get();
			AnswerOption answeroption = new AnswerOption();
			answeroption.setQuestion(question);
			
			model.addAttribute("question", question);
			model.addAttribute("answerOption", answeroption);
			model.addAttribute("answerOptions", question.getAnswerOptions());
			return "addansweroption";
	}

	//method to save answerOption, returns to questionlist/surveyId-template
	@RequestMapping(value = "/saveansweroption", method = RequestMethod.POST)
	public String saveAnswerOption(AnswerOption answerOption) {
		
		
		answerOptionRepository.save(answerOption);
			
		return "redirect:questionlist/" + answerOption.getQuestion().getSurvey().getSurveyId();
	}

		
	//edit an existing answer option
	@RequestMapping(value="/editansweroption/{id}")
	public String editAnsweroption(@PathVariable("id") Long answeroptionId, Model model) {
		AnswerOption answerOption = answerOptionRepository.findById(answeroptionId).get();
		Question question = questionRepository.findById(answerOption.getQuestion().getQuestionId()).get();
		model.addAttribute("question", question);
		model.addAttribute("answerOption", answerOption);
		model.addAttribute("answerOptions", question.getAnswerOptions());
		Survey survey = surveyRepository.findById(question.getSurvey().getSurveyId()).get();
		model.addAttribute("survey", survey);
		return "editansweroption";
	}
		
	//delete an existing answer option
	@RequestMapping(value="/deleteansweroption/{id}", method = RequestMethod.GET)
	public String deleteAnsweroption(@PathVariable("id") Long answeroptionId) {
		
		AnswerOption answeroption = answerOptionRepository.findById(answeroptionId).get();
		Long surveyId = answeroption.getQuestion().getSurvey().getSurveyId();
		answerOptionRepository.deleteById(answeroptionId);
		
		return "redirect:../questionlist/" + surveyId;
	}
		

	

}
