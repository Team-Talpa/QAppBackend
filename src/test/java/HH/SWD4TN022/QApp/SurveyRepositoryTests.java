package HH.SWD4TN022.QApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Survey;
import HH.SWD4TN022.QApp.domain.SurveyRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SurveyRepositoryTests {
	
	@Autowired
	private SurveyRepository repository;
	
	@Test
	public void createNewSurveyTest() {
		Survey survey = new Survey("Harry Potter -survey");
		repository.save(survey);
		assertThat(survey.getSurveyId()).isNotNull();
	}
	
	
}
