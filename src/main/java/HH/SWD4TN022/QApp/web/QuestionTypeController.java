package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import HH.SWD4TN022.QApp.domain.QuestionTypeRepository;

@CrossOrigin
@Controller
public class QuestionTypeController {

	@Autowired
	private QuestionTypeRepository questionTypeRepository;
	
	
	//pitää pystyä hakemaan kaikki kysymysvaihtoehdot GET questiontypes
	
	//pitää pystyä hakemaan yhden kysymysvaihtoehdon GET questiontypes/id
	
}
