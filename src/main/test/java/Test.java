
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SomeThreadd someThreadd = new SomeThreadd(sc);
        someThreadd.start();
    }
}
class SomeThreadd extends Thread{

    private BufferedReader in;
    private PrintWriter out;
    private Scanner sc;

    public SomeThreadd(Scanner sc){
        this.sc =sc;
    }

    public void run(){
        String message = sc.nextLine();
        System.out.println(message);

    }
}