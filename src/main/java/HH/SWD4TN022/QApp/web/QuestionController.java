package HH.SWD4TN022.QApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import HH.SWD4TN022.QApp.domain.Question;

@Controller
public class QuestionController {

	@RequestMapping("/questions")
	public String questions(Model model) {
		
		//model.addAttribute("questions", questions);
		
		return "questions";
	}
	
	@RequestMapping(value = "/addquestion")
	public String addquestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}
	

	
}


