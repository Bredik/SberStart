package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerShowAllCards implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = new Service().getAllCards();

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();

        output.write(response.getBytes());
        output.flush();

        exchange.close();

    }
}
