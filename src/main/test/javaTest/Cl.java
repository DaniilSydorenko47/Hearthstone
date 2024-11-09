package javaTest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cl {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",1234)){

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
