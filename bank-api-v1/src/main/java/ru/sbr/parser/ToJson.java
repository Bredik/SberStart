package ru.sbr.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import ru.sbr.DTO.Cards;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ToJson {
    public void toJson(List<Cards> statement) throws IOException {
        ObjectMapper m = new ObjectMapper();

        String s = "";

        try {
            s = m.writeValueAsString(statement);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("List: " + s);


    }
}

