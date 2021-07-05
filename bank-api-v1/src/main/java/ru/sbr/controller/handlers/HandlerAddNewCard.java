package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;

import java.io.IOException;
import java.io.OutputStream;

public class HandlerAddNewCard implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("HandlerAddNewCard, handle");

        String response = "";
        int codeResponse = new Service().addNewCard();;

        if (codeResponse == 1) {
            response = "Card add!";
        } else response = "Your card has not been added or an error has occurred";

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
