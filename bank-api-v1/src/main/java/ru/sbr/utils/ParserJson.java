package ru.sbr.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sbr.entity.Cards;
import ru.sbr.entity.Deposite;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ParserJson {
    private final ObjectMapper mapper = new ObjectMapper();
    private String response = "";

    public String toJson(List<Cards> statement) {
        try {
            response = mapper.writeValueAsString(statement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public String toJson(Map<Long, Float> statement) {
        try {
            response = mapper.writeValueAsString(statement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public Deposite fromJson(InputStream response) {
        Deposite deposite = null;
        try {
            deposite = mapper.readValue(response, Deposite.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
     return deposite;
    }
}

