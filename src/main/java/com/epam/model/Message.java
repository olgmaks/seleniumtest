package com.epam.model;

public class Message {



	private boolean isIndicated;

	private boolean isImportant;

	private String sender;

	private String subject;



	public Message() {

	}


	public boolean isIndicated() {
		return isIndicated;
	}

	public void setIndicated(boolean isIndicated) {
		this.isIndicated = isIndicated;
	}

	public boolean isImportant() {
		return isImportant;
	}

	public void setImportant(boolean isImportant) {
		this.isImportant = isImportant;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Message message = (Message) o;

		if (isImportant != message.isImportant) return false;
		if (isIndicated != message.isIndicated) return false;
		if (sender != null ? !sender.equals(message.sender) : message.sender != null) return false;
		if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (isIndicated ? 1 : 0);
		result = 31 * result + (isImportant ? 1 : 0);
		result = 31 * result + (sender != null ? sender.hashCode() : 0);
		result = 31 * result + (subject != null ? subject.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Message{" +
				"isIndicated=" + isIndicated +
				", isImportant=" + isImportant +
				", sender='" + sender + '\'' +
				", subject='" + subject + '\'' +
				'}';
	}
}
