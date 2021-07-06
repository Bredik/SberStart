package ru.sbr.controller;

import com.sun.net.httpserver.HttpServer;
import ru.sbr.controller.handlers.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static int port = 8000;
    public static HttpServer server;

    public static void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Порт:" + port + ". Сервер запущен...");
        server.createContext("/", new HandlerStart());
        server.createContext("/getAllCards", new HandlerShowAllCards());
        server.createContext("/addCard", new HandlerAddNewCard());
        server.createContext("/depFunds", new HandlerDepositFunds());
        server.createContext("/checkBalance", new HandlerCheckBalance());
        server.createContext("/stop", new HandlerStop());

        server.setExecutor(null);
        server.start();
    }

    public static void stop() {
        server.stop(0);
    }
}