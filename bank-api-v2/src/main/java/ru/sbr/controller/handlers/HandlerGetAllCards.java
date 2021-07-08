package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HandlerGetAllCards implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;
        OutputStream output;

        if ("GET".equals(exchange.getRequestMethod())) {
            response = new Service().getAllCards();
            exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);

            output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
        } else {
            response = "HTTP 405 Method Not Allowed";
            exchange.sendResponseHeaders(405, response.getBytes(StandardCharsets.UTF_8).length);
            output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
        }
        exchange.close();
    }
}


