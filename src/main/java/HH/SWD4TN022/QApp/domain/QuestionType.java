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
public class QuestionType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long questionTypeId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionType")
	@JsonIgnoreProperties("questionType")
	private List<Question> questions;
	
	private String questionTypeBody;
	
	public QuestionType() {
		this.questionTypeBody = null;
	}

	public QuestionType(String questionTypeBody) {
		super();
		this.questionTypeBody = questionTypeBody;
	}

	public long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionTypeBody() {
		return questionTypeBody;
	}

	public void setQuestionTypeBody(String questionTypeBody) {
		this.questionTypeBody = questionTypeBody;
	};
	
	@Override
	public String toString() {
		return "QuestionType [questionTypeBody=" + questionTypeBody + "]";
	}
	
	
	

}
