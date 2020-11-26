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
import HH.SWD4TN022.QApp.domain.AnswerOption;
import HH.SWD4TN022.QApp.domain.AnswerOptionRepository;
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
	public CommandLineRunner demo(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, 
			AnswerOptionRepository answeroptionrepository) {
		
		return (args) -> {
			
			//V13, HH-demosurvey
			
			/*
			
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
			
			*/
			
			// Demo vastausten kanssa
			
			
			
			Survey answerSurvey = new Survey ("Haaga-Helian kouluruokakysely");
			
			surveyRepository.save(answerSurvey);
			
			Question q1 = new Question("Ruokailetko millä kampuksella?", answerSurvey);
			Question q2 = new Question("Kuinka monta kertaa viikossa käyt koulussa syömässä?", answerSurvey);
			Question q3 = new Question("Monta kertaa viikosta otat kasvisvaihtoehdon?", answerSurvey);
			Question q4 = new Question("Ostatko Premium vai Halpis-ruoan?", answerSurvey);
			Question q5 = new Question("1-5 Kuinka tyytyväinen olet kouluruokaan?", answerSurvey);
			
			AnswerOption q5a1 = new AnswerOption("1" , q5);
			AnswerOption q5a2 = new AnswerOption("2" , q5);
			AnswerOption q5a3 = new AnswerOption("3" , q5);
			AnswerOption q5a4 = new AnswerOption("4" , q5);
			AnswerOption q5a5 = new AnswerOption("5" , q5);
			
			AnswerOption q4a1 = new AnswerOption("Premium" , q4);
			AnswerOption q4a2 = new AnswerOption("Halpis" , q4);
			
			AnswerOption q3a1 = new AnswerOption("1-2" , q3);
			AnswerOption q3a2 = new AnswerOption("3-4" , q3);
			AnswerOption q3a3 = new AnswerOption("5" , q3);
			
			AnswerOption q2a1 = new AnswerOption("1-2" , q2);
			AnswerOption q2a2 = new AnswerOption("3-4" , q2);
			AnswerOption q2a3 = new AnswerOption("5" , q2);
			
			AnswerOption q1a1 = new AnswerOption("Porvoo" , q1);
			AnswerOption q1a2 = new AnswerOption("Pasila" , q1);
			AnswerOption q1a3 = new AnswerOption("Haaga" , q1);
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			
			answerRepository.save(new Answer(q1a2.getAnswerOptionBody(), q1));
			answerRepository.save(new Answer(q2a3.getAnswerOptionBody(), q2));
			answerRepository.save(new Answer(q3a2.getAnswerOptionBody(), q3));
			answerRepository.save(new Answer(q4a2.getAnswerOptionBody(), q4));
			answerRepository.save(new Answer(q5a1.getAnswerOptionBody(), q5));
			
			log.info("list all surveys");

			  for(Survey s : surveyRepository.findAll()) {
				log.info(s.toString());

			}
			  
		};
	}

}
