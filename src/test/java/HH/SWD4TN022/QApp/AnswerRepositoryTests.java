package HH.SWD4TN022.QApp;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AnswerRepositoryTests {
	@Autowired
	private AnswerRepository repository;
	
	@Test
	public void createNewAnswerTest() {
		Answer answer = new Answer();
		repository.save(answer);
		assertThat(answer.getAnswerId()).isNotNull();
	}
}