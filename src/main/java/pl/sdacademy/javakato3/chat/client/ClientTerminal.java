package pl.sdacademy.javakato3.chat.client;

import pl.sdacademy.javakato3.chat.model.ChatMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTerminal implements Runnable {

    private final Socket socket;
    private String serverAddress = "127.0.0.1";
    private int serverPort = 5568;
    private ConsoleDelegate consoleDelegate;

    public ClientTerminal() throws IOException {
        socket = new Socket(serverAddress, serverPort);
        consoleDelegate = new ConsoleDelegate();
    }

    @Override
    public void run() {
        consoleDelegate.writeToUser("What is you nickname?");
        String nickname = consoleDelegate.readFromUser();
        String message;
        try (ObjectOutputStream serverConnection = new ObjectOutputStream(socket.getOutputStream())) {
            do {
                message = consoleDelegate.readFromUser();
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setAuthor(nickname);
                chatMessage.setMessage(message);
                serverConnection.writeObject(chatMessage);
                serverConnection.flush();
            } while (!message.equalsIgnoreCase("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
