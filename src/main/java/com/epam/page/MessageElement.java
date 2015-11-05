package com.epam.page;

import org.openqa.selenium.WebElement;

import com.epam.model.Message;

public class MessageElement {
	
	
	private Message message;
	
	private WebElement indicatedCheckBox;

	private WebElement importantCheckBox; 
	
	
	public MessageElement() {
		 
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
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


	public void setImportantCheckBox(WebElement importantCheckBox) {
		this.importantCheckBox = importantCheckBox;
	}


	@Override
	public String toString() {
		return "MessageItemFragment [message=" + message + ", indicatedCheckBox=" + indicatedCheckBox
				+ ", importantCheckBox=" + importantCheckBox + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		MessageElement other = (MessageElement) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}


	 
	
	

}
