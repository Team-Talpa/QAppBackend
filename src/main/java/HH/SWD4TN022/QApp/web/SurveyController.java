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

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;  
	
	@Autowired
	private QuestionRepository questionRepository; 

	@RequestMapping(value="/surveys/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("id") Long surveyId) {	
    	return surveyRepository.findById(surveyId);
    }  
	
	@GetMapping({"/", "/surveylist"})
	public String listSurveys(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "surveylist";
	}
	
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepository.findAll();
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
		//survey.setQuestions(questions); Liittyy alla olevaan keskeneäiseen
		// tarvitsee myös parametrin lista questions
		surveyRepository.save(survey);
		return "redirect:surveylist";
	}
	
	//Yritys tehdä surevy form johon voisi 
	//luodessa surveyn lisätä kysymykset
	//Ensimmäinen versio joka ei vielä toimi
	//voi poistaa myöhemmin
//	@RequestMapping(value = "/addsurvey")
//	public String addSurvey(Model model) {
//		
//		Survey newsurvey = new Survey();
//		model.addAttribute("survey", newsurvey);
//		
//		List<Question> newquestions = new ArrayList<Question>();
//		for(int i = 0; i > 4; i++) {
//			Question newquestion = new Question("testi poista", newsurvey);
//
//			newquestions.add(newquestion);
//		}
//		System.out.print("--->" + newquestions.get(0));
//		model.addAttribute("questions", newquestions);
//		
//		return "addsurvey";
//	}
	
}
