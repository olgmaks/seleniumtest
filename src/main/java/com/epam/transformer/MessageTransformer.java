package com.epam.transformer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.model.Message;
import com.epam.page.MessageItemFragment;

public class MessageTransformer {

	private static final String INDICATED_CHECK_BOX_CLASS_NAME = "oZ-jc";

	private static final String IMPORTANT_CHECK_BOX_CLASS_NAME = "WA";

	private MessageTransformer() {

	}

	public static MessageItemFragment fetchOne(WebElement message) {

		MessageItemFragment result = new MessageItemFragment();
		Message messageModel = new Message();

		result.setIndicatedCheckBox(message.findElement(By.className(INDICATED_CHECK_BOX_CLASS_NAME)));

		result.setImportantCheckBox(message.findElement(By.className(IMPORTANT_CHECK_BOX_CLASS_NAME)));

		messageModel.setSender(message.findElement(By.className("yX")).getText());

		messageModel.setSubject(message.findElement(By.className("xS")).findElement(By.className("y6")).getText());
		
		messageModel.setImportant(result.getImportantCheckBox().isSelected());
		
		messageModel.setIndicated(result.getIndicatedCheckBox().isSelected());
		
		result.setMessage(messageModel);

		return result;
	}

	public static List<MessageItemFragment> fetchAll(List<WebElement> elements) {
		
		if (elements == null) {
			System.out.println(Message.class + "Message : " + "toMessages : elements = null");
			return null;
		}

		List<MessageItemFragment> results = new ArrayList<>();

		for (WebElement webElement : elements) {
			MessageItemFragment messageItemFragment = fetchOne(webElement);
			results.add(messageItemFragment);
		}

		return results;
	}

}
