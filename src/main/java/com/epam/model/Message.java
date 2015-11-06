package com.epam.model;

public class Message {

    private String sender;

    private String subject;


    public Message() {

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

        if (sender != null ? !sender.equals(message.sender) : message.sender != null) return false;
        return !(subject != null ? !subject.equals(message.subject) : message.subject != null);

    }

    @Override
    public int hashCode() {
        int result = sender != null ? sender.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                " sender='" + sender + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
