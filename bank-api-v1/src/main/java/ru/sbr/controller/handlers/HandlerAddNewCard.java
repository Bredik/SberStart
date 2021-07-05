package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerAddNewCard implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        new Service().addNewCard();

        String response = "Add new Card...";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
