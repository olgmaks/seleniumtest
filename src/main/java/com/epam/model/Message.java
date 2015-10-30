package com.epam.model;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Message {

	private static final String INDICATED_CHECK_BOX_CLASS_NAME = "oZ-jc";

	private WebElement indicatedCheckBox;

	private String sender;
	private String subject;

	public Message(WebElement message) {
		super();
		indicatedCheckBox = message.findElement(By.className(INDICATED_CHECK_BOX_CLASS_NAME));

		// try {
		sender = message.findElement(By.className("yX")).getText();

		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		subject = message.findElement(By.className("xS")).getText();
		// messageText = message.findElement(By.className("y2")).getText();
	}

	public WebElement getIndicatedCheckBox() {
		return indicatedCheckBox;
	}

	public void setIndicatedCheckBox(WebElement indicatedCheckBox) {
		this.indicatedCheckBox = indicatedCheckBox;
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

}
