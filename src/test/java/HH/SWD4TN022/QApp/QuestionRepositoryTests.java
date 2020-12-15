package HH.SWD4TN022.QApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionRepository;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class QuestionRepositoryTests {
	@Autowired
	private QuestionRepository repository;
	
	@Test
	public void createNewQuestionTest() {
		Question question = new Question();
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
