package com.epam.model;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Message {

	private static final String INDICATED_CHECK_BOX_CLASS_NAME = "oZ-jc";
	private static final String IMPORTANT_CHECK_BOX_CLASS_NAME = "WA";

	private WebElement indicatedCheckBox;
	private WebElement importantCheckBox;

	private String sender;
	private String subject;

	public Message(WebElement message) {
		super();
		//
		indicatedCheckBox = message.findElement(By.className(INDICATED_CHECK_BOX_CLASS_NAME));
		//
		importantCheckBox = message.findElement(By.className(IMPORTANT_CHECK_BOX_CLASS_NAME));

		// try {
		sender = message.findElement(By.className("yX")).getText();

		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		subject = message.findElement(By.className("xS")).findElement(By.className("y6")).getText();
		// messageText = message.findElement(By.className("y2")).getText();
	}

	public WebElement getIndicatedCheckBox() {
		return indicatedCheckBox;
	}

	public void setIndicatedCheckBox(WebElement indicatedCheckBox) {
		this.indicatedCheckBox = indicatedCheckBox;
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

	public static List<Message> toMessages(List<WebElement> elements) {

		if (elements == null) {
			System.out.println(Message.class + "Message : " + "toMessages : elements = null");
			return null;
		}

		List<Message> results = new ArrayList<>();

		for (WebElement webElement : elements) {
			Message message = new Message(webElement);
			results.add(message);
		}

		return results;
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
