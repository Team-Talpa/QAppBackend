package HH.SWD4TN022.QApp.domain;

public class AnswerStatistics {

	private String answerBody;
	private long count;
	
	public AnswerStatistics() {
		super();
		this.answerBody = null;
		this.count = 0;
		
	}
	
	public AnswerStatistics(String answerBody, long count) {
		super();
		this.answerBody = answerBody;
		this.count = count;
		
	}

	public String getAnswerOptionBody() {
		return answerBody;
	}

	public void setAnswerOptionBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AnswerStatistics [answerBody=" + answerBody + ", count=" + count + "]";
	}
	
	
}
