package HH.SWD4TN022.QApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			
			surveyrepository.save(s1);
			surveyrepository.save(s2);
			
			log.info("list all surveys");

			  for(Survey s : surveyrepository.findAll()) {
				log.info(s.toString());

			}
			  
		};
	}

}
