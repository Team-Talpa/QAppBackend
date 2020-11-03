package HH.SWD4TN022.QApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import HH.SWD4TN022.QApp.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyrepository;
	
	@GetMapping({"/", "/surveylist"})
	public String surveyList(Model model) {
		model.addAttribute("surveys", surveyrepository.findAll());
		return "surveylist";
	}
	
	
}
