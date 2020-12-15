package HH.SWD4TN022.QApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// junit 5:n kanssa import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
//junit 5:n kanssa import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import HH.SWD4TN022.QApp.web.AnswerController;
import HH.SWD4TN022.QApp.web.AnswerOptionController;
import HH.SWD4TN022.QApp.web.QuestionController;
import HH.SWD4TN022.QApp.web.QuestionTypeController;
import HH.SWD4TN022.QApp.web.SurveyController;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class QAppApplicationTests {
	
	@Autowired
	private SurveyController surveyController;

	@Autowired
	private AnswerController answerController;
	
	@Autowired
	private QuestionController questionController;
	
	@Autowired
	private QuestionTypeController qTypeController;
	
	@Autowired 
	private AnswerOptionController aOptionController;
	
	@Test
	void surveyContextLoads() throws Exception {
		assertThat(surveyController).isNotNull();
	}
	
	@Test
	void answerContextLoads() throws Exception {
		assertThat(answerController).isNotNull();
	}
	
	@Test
	void QuestionContextLoads() throws Exception {
		assertThat(questionController).isNotNull();
	}

	@Test
	void answerOptionContextLoads() throws Exception {
		assertThat(aOptionController).isNotNull();
	}
	
	@Test
	void QuestionTypeContextLoads() throws Exception {
		assertThat(qTypeController).isNotNull();
	}
	
}
