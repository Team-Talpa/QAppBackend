package HH.SWD4TN022.QApp;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SurveyRepositoryTests {
	private static final Logger log = LoggerFactory.getLogger(QAppApplication.class);
	
	@Autowired
	private SurveyRepository repository;
	
	@Test
	public void createNewSurveyTest() {
		Survey survey = new Survey("Harry Potter -survey");
		repository.save(survey);
		assertThat(survey.getSurveyId()).isNotNull();
	}
	
	//isNotIn ei toimi Optional-tyypin kanssa (SurveyControllerissa Optional<Survey> )
	/*
	@Test
	public void deleteSurvey() {
		List<Survey> surveys = (List<Survey>) repository.findAll();
		Long id = new Long(1);
		repository.deleteById(id);
		assertThat(repository.findById(id).isNotIn(surveys));
		
	}*/
	
}
