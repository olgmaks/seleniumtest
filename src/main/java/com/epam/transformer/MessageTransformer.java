package com.epam.transformer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.model.Message;

public class MessageTransformer {

	private static final String INDICATED_CHECK_BOX_CLASS_NAME = "oZ-jc";

	private static final String IMPORTANT_CHECK_BOX_CLASS_NAME = "WA";

	private MessageTransformer() {

	}

	public static Message fetchOne(WebElement message) {

		Message result = new Message();

		result.setIndicatedCheckBox(message.findElement(By.className(INDICATED_CHECK_BOX_CLASS_NAME)));

		result.setImportantCheckBox(message.findElement(By.className(IMPORTANT_CHECK_BOX_CLASS_NAME)));

		result.setSender(message.findElement(By.className("yX")).getText());

		result.setSubject(message.findElement(By.className("xS")).findElement(By.className("y6")).getText());

		return result;
	}

	public static List<Message> fetchAll(List<WebElement> elements) {
		
		if (elements == null) {
			System.out.println(Message.class + "Message : " + "toMessages : elements = null");
			return null;
		}

		List<Message> results = new ArrayList<>();

		for (WebElement webElement : elements) {
			Message message = fetchOne(webElement);
			results.add(message);
		}

		return results;
	}

}
