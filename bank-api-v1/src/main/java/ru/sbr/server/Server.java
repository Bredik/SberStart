package ru.sbr.server;

import com.sun.net.httpserver.HttpServer;
import ru.sbr.server.handlers.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static int port = 8000;
    public static HttpServer server;

    public static void start() throws IOException {
        //todo добавить обработчик исключений
        server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Порт:" + port + ". Сервер запущен...");
        server.createContext("/", new HandlerStart());
        server.createContext("/GET", new HandlerGetNewCard());
        server.createContext("/SH", new HandlerShowAllCards());
        server.createContext("/DEP", new HandlerDepositFunds());
        server.createContext("/CH", new HandlerCheckBalance());
        server.createContext("/stop", new HandlerStop());

        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }
}