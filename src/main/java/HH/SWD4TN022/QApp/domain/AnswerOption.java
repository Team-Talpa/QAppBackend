package HH.SWD4TN022.QApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class AnswerOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long answerOptionId;
	
	private String answerOptionBody;
	
	@ManyToOne
	@JsonIgnoreProperties("answerOptions")
	@JoinColumn(name = "questionId")
	private Question question;

	public AnswerOption() {
		super();
	}
	
	public AnswerOption(String answerOptionBody) {
		super();
		this.answerOptionBody = answerOptionBody;
	}
	
	public AnswerOption(String answerOptionBody, Question question) {
		super();
		this.answerOptionBody = answerOptionBody;
		this.question = question;
	}

	public long getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(long answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	public String getAnswerOptionBody() {
		return answerOptionBody;
	}

	public void setAnswerOptionBody(String answerOptionBody) {
		this.answerOptionBody = answerOptionBody;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnswerOption [answerOptionBody=" + answerOptionBody + "]";
	}

	
	
}
