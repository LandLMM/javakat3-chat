package pl.sdacademy.javakato3.chat.server;

import pl.sdacademy.javakato3.chat.model.ChatMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerSocketReaderRunnable implements Runnable {

    private final Socket clientConnection;
    private final ChatLog chatLog;

    public ServerSocketReaderRunnable(Socket clientConnection, ChatLog chatLog) {
        this.clientConnection = clientConnection;
        this.chatLog = chatLog;
        chatLog.register(clientConnection);
    }

    @Override
    public void run() {
        System.out.println("New client connected");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(clientConnection.getInputStream())) {
            boolean clientIsConnected = true;
            while (clientIsConnected) {
                if (clientConnection.getInputStream().available() > 0) {
                    clientIsConnected = processMessage(objectInputStream);
                } else {
                    Thread.sleep(100);
                }
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean processMessage(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object o;
        try {
             o = objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Someone has invalid package name! " + e.getMessage());
            return false;
        } catch (SocketException e) {
            System.out.println("Someone disconnected");
            return false;
        }
        if (o == null) {
            return true;
        }
        ChatMessage message = (ChatMessage) o;
        if (!"exit".equalsIgnoreCase(message.getMessage())) {
            chatLog.acceptMessage(message);
            return true;
        } else {
            return false;
        }
    }

}
