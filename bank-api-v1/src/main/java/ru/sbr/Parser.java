package ru.sbr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbr.entity.Cards;

import java.util.List;

public class Parser {
    public String toJson(List<Cards> statement) {
        System.out.println("Parser, toJson");

        ObjectMapper mapper = new ObjectMapper();
        String response = "";

        try {
            response = mapper.writeValueAsString(statement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
    }
}

