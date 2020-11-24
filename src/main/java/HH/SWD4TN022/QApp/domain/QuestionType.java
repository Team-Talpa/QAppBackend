package HH.SWD4TN022.QApp.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long questionTypeId;
	
	private String questionTypeBody;
	
	public QuestionType() {
		this.questionTypeBody = null;
	}

	public QuestionType(long questionTypeId, String questionTypeBody) {
		super();
		this.questionTypeId = questionTypeId;
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
