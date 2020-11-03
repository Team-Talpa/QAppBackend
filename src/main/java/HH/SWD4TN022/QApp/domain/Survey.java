package HH.SWD4TN022.QApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Survey {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long surveyId;
	private String surveyHeader;
	private List<Question> questions;
	
	public Survey() {
		super();
		this.surveyHeader = null;
		this.questions = new ArrayList<>();
	}
	
	public Survey(String header) {
		super();
		this.surveyHeader = header;
		this.questions = new ArrayList<>();
	}
	
	public Survey(String header, List<Question> questions) {
		super();
		this.surveyHeader = header;
		this.questions = questions;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyHeader() {
		return surveyHeader;
	}

	public void setSurveyHeader(String surveyHeader) {
		this.surveyHeader = surveyHeader;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyHeader=" + surveyHeader + "]";
	}
	
}
