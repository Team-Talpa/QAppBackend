package HH.SWD4TN022.QApp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;  

	@RequestMapping(value="/survey/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("id") Long surveyId) {	
    	return surveyRepository.findById(surveyId);
    }  
	
	@GetMapping({"/", "/surveylist"})
	public String listSurveys(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "surveylist";
	}
	
	@GetMapping({"/resthomepage"})
	public String showRestHomepage(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "resthomepage";
	}
	
	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}
	
	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
	public String saveSurvey(Survey survey) {
		surveyRepository.save(survey);
		return "redirect:surveylist";
	}
	
}
