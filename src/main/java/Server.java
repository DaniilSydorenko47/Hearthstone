import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

// проблемы: клиент2 после закрытия сервера выдает ошибку, проблема с пересылкой сообщений
public class Server {
    public static void main(String[] args) {
        int port = 8345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ждёт подключений на порту " + port);

            // Ожидание клиентов
            Socket client1 = serverSocket.accept();
            Socket client2 = serverSocket.accept();

            // Чтение входящего логина 1
            BufferedReader readLogin1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            String loginOut1 = readLogin1.readLine();

            //Чтение входящего логина 2
            BufferedReader readLogin2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            String loginOut2 = readLogin2.readLine();

            // Проверка логинов
            if (loginOut1.equals(loginOut2)){
                System.out.println("Клиенты подключились");

                // Отправка ответа клиентам
                PrintWriter answerOut1 = new PrintWriter(client1.getOutputStream(),true);
                answerOut1.println("Вы подключились!");
                PrintWriter answerOut2 = new PrintWriter(client2.getOutputStream(),true);
                answerOut2.println("Вы подключились!");
            } else {
                System.out.println("Клиенты ввели неправельный логин");
                PrintWriter answerOut1 = new PrintWriter(client1.getOutputStream(),true);
                answerOut1.println("Вы ввели неправельный логин");
                PrintWriter answerOut2 = new PrintWriter(client2.getOutputStream(),true);
                answerOut2.println("Вы ввели неправельный логин");
                client1.close();
                client2.close();
                serverSocket.close();
            }

            // Потоки для отправки и получения данных
            BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);

            while (true) {
                // Чтение сообщения от клиента
                String clientMessage1 = in1.readLine();
                if (clientMessage1.equals("null")){
                    break;
                }
                out2.println(clientMessage1);

                String clientMessage2 = in2.readLine();
                if (clientMessage2.equals("null")){
                    break;
                }
                out1.println(clientMessage2);
            }
            client1.close();
            client2.close();

        } catch (IOException e) {
            System.out.println("Ошибка на сервере: " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Клиент отключился");
        }
    }

}
