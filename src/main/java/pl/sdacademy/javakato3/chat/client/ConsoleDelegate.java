package pl.sdacademy.javakato3.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDelegate {

    public String readFromUser() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(inputStreamReader);
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void writeToUser(String message) {
        System.out.println(message);
    }

}
