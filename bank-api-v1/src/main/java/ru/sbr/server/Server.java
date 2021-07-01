package ru.sbr.server;

import com.sun.net.httpserver.HttpServer;
import ru.sbr.server.handlers.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {
    private static int port = 8000;
    public static HttpServer server;

    public void start1() throws IOException {
        //todo добавить обработчик исключений
        server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Порт:" + port + ". Сервер запущен...");
        server.createContext("/", new HandlerStart());
        server.createContext("/GET", new HandlerGetNewCard());
        server.createContext("/SH", new HandlerShowAllCards());
        server.createContext("/DEP", new HandlerDepositFunds());
        server.createContext("/CH", new HandlerCheckBalance());
        server.createContext("/stopr", new HandlerCheckBalance());

        server.setExecutor(null); // creates a default executor
        server.start();

    }

    public void start2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        serverSocket.accept();
        serverSocket.close();
    }
}