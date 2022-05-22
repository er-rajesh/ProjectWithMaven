package com.org.first;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	private String courseName;
	private String Language;
	private String duration;

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certificate(String courseName, String language, String duration) {
		super();
		this.courseName = courseName;
		Language = language;
		this.duration = duration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
