package HH.SWD4TN022.QApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.QuestionTypeRepository;

@CrossOrigin
@Controller
public class QuestionTypeController {

	@Autowired
	private QuestionTypeRepository questionTypeRepository;

	// Endpoint provides a list of questiontypes to addquestion-template
	@GetMapping("/questiontypelist")
	public String questionTypeList(Model model) {
		model.addAttribute("questionTypes", questionTypeRepository.findAll());
		return "addquestion";
	}

	// Endpoint retrieves a list of all questiontypes with REST
	@GetMapping("/questiontypes")
	public @ResponseBody List<QuestionType> questionTypeListRest() {
		return (List<QuestionType>) questionTypeRepository.findAll();
	}
	
	//Endpoint retrieves a single questiontype with the specified id with REST
	@GetMapping("/questiontypes/{id}")
	public @ResponseBody Optional<QuestionType> findQuestionTypeRest(@PathVariable("id") Long questionTypeId) {
		return questionTypeRepository.findById(questionTypeId);
	}
	
	
	
}
