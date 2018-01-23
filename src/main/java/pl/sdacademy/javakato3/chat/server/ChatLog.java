package pl.sdacademy.javakato3.chat.server;

import pl.sdacademy.javakato3.chat.model.ChatMessage;
import pl.sdacademy.javakato3.chat.model.DatedChatMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ChatLog {
    private List<Socket> observers = new ArrayList<>();

    public void register(Socket socket) {
        observers.add(socket);
    }

    public void unregister(Socket socket) {
        observers.remove(socket);
    }

    public void acceptMessage(ChatMessage message) {
        DatedChatMessage datedMessage = new DatedChatMessage(message);
        displayMessage(datedMessage);
        notifyObservers(datedMessage);
    }

    private void displayMessage(DatedChatMessage datedMessage) {
        StringJoiner messageJoiner = new StringJoiner(" ", ">", "");
        messageJoiner.add(datedMessage.getReceiveDate().toString());
        messageJoiner.add(datedMessage.getAuthor() + ":");
        messageJoiner.add(datedMessage.getMessage());
        System.out.println(messageJoiner);
    }

    private void notifyObservers(DatedChatMessage message) {
        for (Socket observer : observers) {
            try {
                OutputStream outputStream = observer.getOutputStream();
                ObjectOutputStream clientConnection = new ObjectOutputStream(outputStream);
                clientConnection.writeObject(message);
                clientConnection.flush();
            } catch (IOException e) {
            }
        }
    }


}
