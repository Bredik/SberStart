package ru.borisova.solution1.OOP.Actions;

import ru.borisova.solution1.entity.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteIntoFile implements Exec {

    @Override
    public void exec(List<Person> data) throws Exception {
        try(FileWriter writer = new FileWriter("notes.txt", true))
        {
            writer.write(String.valueOf(data));
            writer.flush();
            writer.append("\n");
            System.out.println("File save!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
