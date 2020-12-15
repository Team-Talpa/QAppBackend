package HH.SWD4TN022.QApp;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import HH.SWD4TN022.QApp.domain.Answer;
import HH.SWD4TN022.QApp.domain.AnswerRepository;
import HH.SWD4TN022.QApp.domain.Question;
import HH.SWD4TN022.QApp.domain.QuestionType;
import HH.SWD4TN022.QApp.domain.Survey;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AnswerRepositoryTests {
	@Autowired
	private AnswerRepository repository;
	
	@Test
	public void createNewAnswerTest() {
		Survey demoSurvey = new Survey("Hyvinvointikysely");
		QuestionType radio = new QuestionType("radiobutton");
		Question question = new Question("Mikä koulutusohjelma", radio, demoSurvey);
		Answer answer = new Answer("Tietojenkäsittelyn koulutusohjelma", question);
		repository.save(answer);
		assertThat(answer.getAnswerId()).isNotNull();
	}
	
	@Test //testataan delete
	public void deleteAnswer() {
		List<Answer> answers = (List<Answer>) repository.findAll();
		Long id = new Long(31);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(answers);
	}
}
