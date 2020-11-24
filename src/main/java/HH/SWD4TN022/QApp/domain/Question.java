package HH.SWD4TN022.QApp.domain;

import java.util.ArrayList;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<AnswerOption> answerOptions;
	
	//TODO: check UML- classes from Teams: answers: List<Answer> --> Answer- class, AnswerRepository, AnswerController
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<Answer> answers;

	public Question() {
		this.questionBody = null;
		this.survey = null;
		this.answers = new ArrayList<>();
		this.answerOptions = new ArrayList<>();
	};
	
	public Question(String questionBody, Survey survey) {
		super();
		this.questionBody = questionBody;
		this.survey = survey;
		this.answers = new ArrayList<>();
	}
	
	public Question(String questionBody, Survey survey, List<Answer> answers) {
		super();
		this.questionBody = questionBody;
		this.survey = survey;
		this.answers = answers;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	@Override
	public String toString() {
		return "Question [questionBody=" + questionBody + "]";
	}

}
