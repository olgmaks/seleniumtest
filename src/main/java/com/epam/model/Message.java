package com.epam.model;

import org.openqa.selenium.WebElement;

public class Message {

	private WebElement indicatedCheckBox;

	private WebElement importantCheckBox;

	private String sender;

	private String subject;

	public Message() {
 
	}

	public WebElement getIndicatedCheckBox() {
		return indicatedCheckBox;
	}

	public void setIndicatedCheckBox(WebElement indicatedCheckBox) {
		this.indicatedCheckBox = indicatedCheckBox;
	}

	public void setImportantCheckBox(WebElement importantCheckBox) {
		this.importantCheckBox = importantCheckBox;
	}

	public WebElement getImportantCheckBox() {
		return importantCheckBox;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", subject=" + subject + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

}
