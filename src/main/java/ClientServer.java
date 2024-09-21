import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",4753);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        out.println(sentence);
        out.close();
        socket.close();
    }
}
