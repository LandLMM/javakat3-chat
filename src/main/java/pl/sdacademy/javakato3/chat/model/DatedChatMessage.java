package pl.sdacademy.javakato3.chat.model;

import java.util.Date;

public class DatedChatMessage extends ChatMessage {
    private Date receiveDate;

    public DatedChatMessage(ChatMessage chatMessage) {
        super(chatMessage);
        receiveDate = new Date();
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /*

Będzie rozrzeszała klasę ChatMessage
Będzie zawierała pole Date receiveDate
Będzie posiadała konstruktor, który przyjmuje ChatMessage.
Konstruktor będzie ustawiał receiveDate
Zaimplementuj interface Serializable
     */
}
