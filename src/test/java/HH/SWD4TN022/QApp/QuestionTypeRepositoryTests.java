package HH.SWD4TN022.QApp;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.QuestionTypeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class QuestionTypeRepositoryTests {
	@Autowired
	private QuestionTypeRepository repository;
	
	@Test
	public void createNewAnswerTest() {
		QuestionType questionType = new QuestionType();
		repository.save(questionType);
		assertThat(questionType.getQuestionTypeId()).isNotNull();
	}
}

