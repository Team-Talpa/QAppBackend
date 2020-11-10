package HH.SWD4TN022.QApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;
	private String answerBody;
	
	@ManyToOne
	@JsonIgnoreProperties("answers")
	private Question question;
	
	public Answer(String answerBody, Question question) {
		super();
		this.answerBody = answerBody;
		this.question = question;
		
	}

	public Long getAnswerId() {
		return answerId;
	}


	public String getAnswerBody() {
		return answerBody;
	}

	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	

}
