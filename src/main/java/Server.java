import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4753);
        Socket inputClient = serverSocket.accept();
        Scanner in = new Scanner(inputClient.getInputStream());
        while(in.hasNext()){
            System.out.println(in.nextLine());
        }
        in.close();
        inputClient.close();
        serverSocket.close();
    }
}
