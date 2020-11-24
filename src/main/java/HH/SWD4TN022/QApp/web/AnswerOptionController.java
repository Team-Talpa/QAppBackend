package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import HH.SWD4TN022.QApp.domain.AnswerOptionRepository;

@CrossOrigin
@Controller
public class AnswerOptionController {
	
	@Autowired
	private AnswerOptionRepository answerOptionRepository;
	
	
	//pitää pystyä hakemaan kaikki vastausvaihtoehdot GET answeroptions
	
	//pitää pystyä hakemaan yksittäinen vastausvaihtoehto GET answeroptions/id
	
	//pitää pystyä lisäämään vastausvaihtoehto kysymykselle POST addansweroption
	

}
