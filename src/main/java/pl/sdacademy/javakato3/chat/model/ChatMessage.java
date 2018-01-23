package pl.sdacademy.javakato3.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    public static final long serialVersionUID = 1L;
    private String author;
    private String message;

    public ChatMessage() {

    }

    public ChatMessage(ChatMessage origin) {
        this.author = origin.getAuthor();
        this.message = origin.getMessage();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
