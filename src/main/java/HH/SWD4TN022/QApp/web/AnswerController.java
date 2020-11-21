package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerRepository;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;

@CrossOrigin
@Controller
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
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
	
}
