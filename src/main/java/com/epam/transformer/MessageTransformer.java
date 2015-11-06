package com.epam.transformer;

import com.epam.control.marker.Decorable;
import com.epam.model.Message;
import com.epam.page.MessageElement;

import java.util.ArrayList;
import java.util.List;

public class MessageTransformer {


    private MessageTransformer() {

    }



    public static List<MessageElement> transformTableRowsToPageObjectMessages(List<Decorable> elements) {
//		
        if (elements == null) {
            System.out.println(Message.class + "Message : " + "toMessages : elements = null");
            return null;
        }

        List<MessageElement> results = new ArrayList<>();

        for (Decorable element : elements) {
            results.add(new MessageElement(element));
        }


        return results;
    }

    public static Message getOneMessage(MessageElement messageItemFragment) {

        Message message = new Message();

        message.setSender(messageItemFragment.getSender().getText());
        message.setSubject(messageItemFragment.getSubject().getText());

        return message;
    }

    public static List<Message> transformPageObjectToModelMessages(List<MessageElement> messageItemFragments) {

        List<Message> results = new ArrayList<>();

        for (MessageElement me : messageItemFragments) {
            results.add(getOneMessage(me));
        }

        return results;
    }

}
