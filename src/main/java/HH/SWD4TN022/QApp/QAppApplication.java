package HH.SWD4TN022.QApp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerRepository;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@SpringBootApplication
public class QAppApplication {
	private static final Logger log = LoggerFactory.getLogger(QAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(QAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
		return (args) -> {
			
			//TODO: V13, HH-survey
			
			Survey demoSurvey = new Survey("Hyvinvointikysely Haaga-Helian opiskelijoille");
			
			surveyRepository.save(demoSurvey);
			
			
			Question q1 = new Question("Mikä on koulutusohjelmasi?", demoSurvey);
			Question q2 = new Question("Milloin olet aloittanut opintosi Haaga-Heliassa? (syksy/kevät ja vuosi)", demoSurvey);
			Question q3 = new Question("Miltä etätyöskentely on sinusta tuntunut?", demoSurvey);
			Question q4 = new Question("Ovatko opintosi edenneet poikkeustilanteesta huolimatta tavoitteesi mukaisesti?", demoSurvey);
			Question q5 = new Question("Aiheuttaako etätyöskentely sinulle lisätyötä verrattuna lähiopetukseen?", demoSurvey);
			Question q6 = new Question("Koetko, että tarvitsisit tukea etäopiskeluun? Jos tarvitset, niin kerro omin sanoin millaista tukea tarvitsisit.", demoSurvey);
			Question q7 = new Question("Tiedätkö millaisia opintoihin liittyviä tukipalveluita YTHS ja Haaga-Helia tarjoavat opiskelijoille?", demoSurvey);
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			questionRepository.save(q6);
			questionRepository.save(q7);
			
			
			
			log.info("list all surveys");

			  for(Survey s : surveyRepository.findAll()) {
				log.info(s.toString());

			}
			  
		};
	}

}
