package HH.SWD4TN022.QApp;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.AnswerOption;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.QuestionTypeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class QuestionTypeRepositoryTests {
	@Autowired
	private QuestionTypeRepository repository;
	
	@Test
	public void createNewQuestionTypeTest() {
		QuestionType questionType = new QuestionType("text");
		repository.save(questionType);
		assertThat(questionType.getQuestionTypeId()).isNotNull();
	}
	
	@Test //testataan delete
	public void deleteQuestionType() {
		List<QuestionType> questionTypes = (List<QuestionType>) repository.findAll();
		Long id = new Long(4);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(questionTypes);
	}
	
	
}

