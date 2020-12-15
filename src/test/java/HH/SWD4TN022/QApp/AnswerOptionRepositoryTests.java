package HH.SWD4TN022.QApp;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.AnswerOption;
import HH.SWD4TN022.QApp.domain.AnswerOptionRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AnswerOptionRepositoryTests {
	@Autowired
	private AnswerOptionRepository repository;
	
	@Test
	public void createNewAnswerOptionTest() {
		AnswerOption answerOption = new AnswerOption("Tietojenkäsittelyn koulutusohjelma");
		repository.save(answerOption);
		assertThat(answerOption.getAnswerOptionId()).isNotNull();
	}
	
	@Test //testataan delete
	public void deleteAnswerOption() {
		List<AnswerOption> answerOptions = (List<AnswerOption>) repository.findAll();
		Long id = new Long(14);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(answerOptions);
	}
}

