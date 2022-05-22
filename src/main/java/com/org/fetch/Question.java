package com.org.fetch;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@Column(name = "question_id")
	private int quesionId;

	private String question;
	@OneToMany(mappedBy = "questions", fetch = FetchType.LAZY)
	private List<Answer> answers;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int quesionId, String question, List<Answer> answers) {
		super();
		this.quesionId = quesionId;
		this.question = question;
		this.answers = answers;
	}

	public int getQuesionId() {
		return quesionId;
	}

	public void setQuesionId(int quesionId) {
		this.quesionId = quesionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
