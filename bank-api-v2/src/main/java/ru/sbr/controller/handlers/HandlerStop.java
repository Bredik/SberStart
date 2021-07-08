package ru.sbr.controller.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ru.sbr.DAO.LaunchDB;
import ru.sbr.controller.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HandlerStop implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;
        OutputStream output;

        if ("GET".equals(exchange.getRequestMethod())) {
            response = "Server stop...";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
            exchange.close();
        } else  {
            response = "HTTP 405 Method Not Allowed";
            exchange.sendResponseHeaders(405, response.getBytes(StandardCharsets.UTF_8).length);
            output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.flush();
        }

        LaunchDB.disconnect();
        Server.stop();
    }
}
