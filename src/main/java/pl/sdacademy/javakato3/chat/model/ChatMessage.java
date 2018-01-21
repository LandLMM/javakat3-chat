package pl.sdacademy.javakato3.chat.model;

public class ChatMessage {
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

/*
Stwórz klasę ChatMessage, która będzie zawierała dwa pola:
private String author
private String message
Zaimplementuj klasę DatedChatMessage, która
Będzie rozrzeszała klasę ChatMessage
Będzie zawierała pole Date receiveDate
Będzie posiadała konstruktor, który przyjmuje ChatMessage.
Konstruktor będzie ustawiał receiveDate
Zaimplementuj interface Serializable
     */
}
