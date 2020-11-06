package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	/* TODO: does not work, template does not exist
	@RequestMapping("/questions")
	public String questions(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "questions";
	}
	*/
	
	//TODO: addquestion.html-template does not exist
	@RequestMapping(value = "/addquestion")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}
	
	//TODO
	//editQuestion() --> editquestion.html 
	//saveQuestion()
	//deleteQuestion(), essential crud-function, needed for sprint 1?
	
}


