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
}
