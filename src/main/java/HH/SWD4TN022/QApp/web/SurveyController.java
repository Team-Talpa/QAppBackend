package HH.SWD4TN022.QApp.web;

import java.util.ArrayList;

import java.util.List;
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

	
	@GetMapping({"/", "/frontpage"})
	public String showFrontpage() {
		return "frontpage";
	}
	
	//REST method to retrieve a list of all surveys
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepository.findAll();
	}
	
	//REST method to retrieve a single survey by surveyId
	@RequestMapping(value="/surveys/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("id") Long surveyId) {	
    	return surveyRepository.findById(surveyId);
    }  
	
	//retrives a list of all surveys
	@GetMapping("/surveylist")
	public String listSurveys(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "surveylist";
	}

	//retrieves a list of all surveys to REST homepage
	@GetMapping({"/resthomepage"})
	public String showRestHomepage(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "resthomepage";
	}
	
	//adds a new survey
	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model) {

		model.addAttribute("survey", new Survey());

		return "addsurvey";
	}
	
	//saves a survey
	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
	public String saveSurvey(Survey survey) {
		//survey.setQuestions(questions); Liittyy alla olevaan keskeneräiseen
		// tarvitsee myös parametrin lista questions
		surveyRepository.save(survey);
		return "redirect:surveylist";
	}
	
	//edit an existing survey
	@RequestMapping(value="/editsurvey/{id}")
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		model.addAttribute("survey", surveyRepository.findById(surveyId));
		return "editsurvey";
	}
	
	//delete an existing survey
	@RequestMapping(value="/deletesurvey/{id}", method = RequestMethod.GET)
	public String deleteSurvey(@PathVariable("id") Long surveyId) {
		surveyRepository.deleteById(surveyId);
		return "redirect:../surveylist";
	}
	
	

	
}
