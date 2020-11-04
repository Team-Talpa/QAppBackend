package HH.SWD4TN022.QApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long questionId;
	
	public String questionBody;
	
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "surveyId")
	public Survey survey;

	
	public Question() {};
	
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

	@Override
	public String toString() {
		return "Question [questionBody=" + questionBody + "]";
	}

}
