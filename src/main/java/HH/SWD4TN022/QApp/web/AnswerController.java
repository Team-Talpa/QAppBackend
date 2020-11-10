package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import HH.SWD4TN022.QApp.domain.AnswerRepository;
import HH.SWD4TN022.QApp.domain.QuestionRepository;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	//TODO
	@GetMapping("/addanswer")
	public String addAnswer(Model model) {
		return "";
	}
	
	//TODO
	@PostMapping("/saveanswer")
	public String saveAnswer() {
		return "";
	}
	
}
