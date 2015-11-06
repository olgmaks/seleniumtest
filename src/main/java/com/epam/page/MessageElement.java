package com.epam.page;

import com.epam.control.element.CheckBox;
import com.epam.control.element.Label;
import com.epam.control.marker.Decorable;
import com.epam.control.wraper.WebElementWrapper;
import org.openqa.selenium.By;

public class MessageElement {

    private static final String INDICATED_CHECK_BOX_CLASS_NAME = "oZ-jc";
    private static final String IMPORTANT_CHECK_BOX_CLASS_NAME = "WA";
    private static final String SUBJECT_LABEL_CLASS_NAME = "y6";
    private static final String SENDER_LABEL_CLASS_NAME = "yX";

    private Label subject;

    private Label sender;

    private CheckBox indicatedCheckBox;

    private CheckBox importantCheckBox;


    public MessageElement(Decorable tableRow) {


        if (tableRow instanceof WebElementWrapper) {

            WebElementWrapper webElementWrapper = ((WebElementWrapper) tableRow);

            subject = webElementWrapper.getChildLabel(By.className(SUBJECT_LABEL_CLASS_NAME));

            sender = webElementWrapper.getChildLabel(By.className(SENDER_LABEL_CLASS_NAME));

            indicatedCheckBox = webElementWrapper.getChildCheckBox(By.className(INDICATED_CHECK_BOX_CLASS_NAME));

            importantCheckBox = webElementWrapper.getChildCheckBox(By.className(IMPORTANT_CHECK_BOX_CLASS_NAME));
        }


    }


    public CheckBox getImportantCheckBox() {
        return importantCheckBox;
    }

    public CheckBox getIndicatedCheckBox() {
        return indicatedCheckBox;
    }

    public Label getSender() {
        return sender;
    }

    public Label getSubject() {
        return subject;
    }


    @Override
    public String toString() {
        return "MessageElement{" +
                "subject=" + subject.getText() +
                ", sender=" + sender.getText() +
                ", indicatedCheckBox=" + indicatedCheckBox.isChecked() +
                ", importantCheckBox=" + importantCheckBox.isChecked() +
                '}';
    }
}
