package esinf;

import java.util.*;


public class Message {

    private String senderEmail;
    private Set<String> recipientList;
    private String subject;
    private String text;

    public Message(String senderEmail, Set<String> recipientList, String subject, String text) {
        this.senderEmail = senderEmail;
        this.recipientList = recipientList;
        this.subject = subject;
        this.text = text;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Set<String> getRecipientList() {
        return recipientList;
    }

    public void setRecipientlist(Set<String> recipientList) {
        this.recipientList = recipientList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
