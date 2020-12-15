package HH.SWD4TN022.QApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.Survey;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class QuestionRepositoryTests {
	private static final Logger log = LoggerFactory.getLogger(QAppApplication.class);
	
	@Autowired
	private QuestionRepository repository;
	
	@Test
	public void createNewQuestionTest() {
		Survey demoSurvey = new Survey("Hyvinvointikysely");
		QuestionType radio = new QuestionType("radiobutton");
		Question question = new Question("Mikä on koulutusohjelmasi?", radio, demoSurvey);
		repository.save(question);
		assertThat(question.getQuestionId()).isNotNull();
	}
	
	@Test
	public void deleteQuestion() {
		List<Question> questions = (List<Question>) repository.findAll();
		Long id = new Long(5);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(questions);
	}
}
