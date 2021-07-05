package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerStart implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "Server working...";
        // todo разобраться с этой строкой response.getBytes().length
        // ну и вообще разобраться с кодами ответов
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(response.getBytes());
        output.flush();
        exchange.close();
    }
}
