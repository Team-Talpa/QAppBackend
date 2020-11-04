package HH.SWD4TN022.QApp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@SpringBootApplication
public class QAppApplication {
	private static final Logger log = LoggerFactory.getLogger(QAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(QAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SurveyRepository surveyrepository) {
		return (args) -> {
			
			Survey s1 = new Survey("Harry Potter- survey");
			Survey s2 = new Survey("LOTR-survey");
			
			List<Question> questionsHP = new ArrayList<>();
			Question q1 = new Question("What is your favourite Patronus?", s1);
			Question q2 = new Question("What is your favourite charm?", s1);
			
			List<Question> questionsLOTR = new ArrayList<>();
			Question q3 = new Question("What is your favourite character?", s2);
			Question q4 = new Question("What is your favourite fantasy race?", s2);
			
			
			questionsHP.add(q1);
			questionsHP.add(q2);
			questionsLOTR.add(q3);
			questionsLOTR.add(q4);
			
			s1.setQuestions(questionsHP);
			s2.setQuestions(questionsLOTR);
			
			surveyrepository.save(s1);
			surveyrepository.save(s2);
			
			log.info("list all surveys");

			  for(Survey s : surveyrepository.findAll()) {
				log.info(s.toString());

			}
			  
		};
	}

}
