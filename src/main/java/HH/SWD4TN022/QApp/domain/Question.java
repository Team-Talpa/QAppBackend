package HH.SWD4TN022.QApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long questionId;
	
	private String questionBody;
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	//TODO: check UML- classes from Teams: answers: List<Answer> --> Answer- class, AnswerRepository, AnswerController
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<Answer> answers;

	public Question() {
		
	};
	
	public Question(String questionBody, Survey survey) {
		super();
		this.questionBody = questionBody;
		this.survey = survey;
	}

	public String getQuestionBody() {
		return questionBody;
	}
	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "Question [questionBody=" + questionBody + "]";
	}

}
