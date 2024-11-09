package javaTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MainFieldTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("Hello");
    }

}
