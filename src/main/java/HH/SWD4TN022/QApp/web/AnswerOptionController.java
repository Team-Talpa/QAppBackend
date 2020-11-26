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

import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerOption;
import HH.SWD4TN022.QApp.domain.AnswerOptionRepository;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.Survey;

@CrossOrigin
@Controller
public class AnswerOptionController {
	
	@Autowired
	private AnswerOptionRepository answerOptionRepository;
	
	@Autowired
	private QuestionRepository questionRepository; 
	//pitää pystyä hakemaan kaikki vastausvaihtoehdot GET answeroptions
	@GetMapping("/answeroptions")
	public @ResponseBody List<AnswerOption> answerOptionListRest() {
		return (List<AnswerOption>) answerOptionRepository.findAll();
	}	
	//pitää pystyä hakemaan yksittäinen vastausvaihtoehto GET answeroptions/id
	@RequestMapping(value="/answeroptions/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<AnswerOption> findAnswerOptionRest(@PathVariable("id") Long answerOptionId) {	
    	return answerOptionRepository.findById(answerOptionId);
    }
	
	//add question ->
	//choose questiontype
	//->if questiontype = radiobutton
	//add answeroption (questionId)
	
	//pitää pystyä lisäämään vastausvaihtoehto kysymykselle POST addansweroption
	/*@PostMapping("/answers/{id}")
	public @ResponseBody Answer saveAnswerRest(@PathVariable("id") Long questionId, @RequestBody Answer answer) { //RequestBody gets data from JSON to server, ResponseBody sends JSON to browser
		Question question = questionRepository.findById(questionId).get();
		answer.setQuestion(question);
		return answerRepository.save(answer);
	}*/
	

}
