package com.example.integrations.studentregistration.mail;

import java.io.Serializable;
import java.util.Arrays;

public class Email implements Serializable {
    private String to;
    private String[] cc;
    private String message;
    private String subject;
    private String from;

    public Email() {
    }

    public Email(String to, String[] cc, String message, String subject, String from) {
        this.to = to;
        this.cc = cc;
        this.message = message;
        this.subject = subject;
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("to=").append(to);
        sb.append(", cc=").append(Arrays.toString(cc));
        sb.append(", message='").append(message).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", from='").append(from).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
