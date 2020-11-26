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
	
	
	//method to add answerOption to a question
	@RequestMapping(value = "/addansweroption")
	public String addAnswerOption(Model model) {
		model.addAttribute("answerOption", new AnswerOption());
		return "addansweroption";
	}
	
	//method to save answerOption, returns to addquestion-template
	@RequestMapping(value = "/saveansweroption", method = RequestMethod.POST)
	public String saveAnswerOption(AnswerOption answerOption) {
		answerOptionRepository.save(answerOption);
		return "redirect:questionlist";
	}
	

}
