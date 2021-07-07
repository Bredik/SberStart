package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.service.Service;
import ru.sbr.utils.ParserURI;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HandlerCheckBalance implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;
        OutputStream output;

        if ("GET".equals(exchange.getRequestMethod())) {
            long idCard = new ParserURI().getNumberFromUri(exchange.getRequestURI().getPath());
            String balance  = new Service().checkBalance(idCard);

            response = checkResponse(balance);

            exchange.sendResponseHeaders(200, response.getBytes().length);
            output = exchange.getResponseBody();
            output.write(response.getBytes());
        } else {
            response = "HTTP 405 Method Not Allowed";
            exchange.sendResponseHeaders(405, response.getBytes(StandardCharsets.UTF_8).length);
            output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
        }
        exchange.close();
    }

    private String checkResponse(String data) {
        if (data == null) {
            return "SERVER ERROR";
        }
        if (data.equals("{}")) {
            return "There is no such card";
        }
        return data;
    }
}
