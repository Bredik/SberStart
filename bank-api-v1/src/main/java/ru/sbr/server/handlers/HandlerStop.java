package ru.sbr.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.DB.InitDB;
import ru.sbr.server.Server;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerStop implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Server stop...";

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(response.getBytes());

        output.flush();
        exchange.close();

        InitDB.disconnect();
        // ВОПРОС - насколько правильно здесь закрывать соединение с сервером
        Server.stop();
    }
}
