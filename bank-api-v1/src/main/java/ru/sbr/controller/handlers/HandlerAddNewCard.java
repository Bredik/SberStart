package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerAddNewCard implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;

        if ("POST".equals(exchange.getRequestMethod())) {
            int codeResponse = new Service().addNewCard(exchange.getRequestBody());
            response = checkResponse(codeResponse);

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
        exchange.close();
    }

    private String checkResponse(int data) {
        if (data == 1) {
            return "Card add!";
        } else return "Your card has not been added or an error has occurred";
    }
}
