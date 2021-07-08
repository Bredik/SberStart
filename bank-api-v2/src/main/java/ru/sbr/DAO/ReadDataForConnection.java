package ru.sbr.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataForConnection {
    private Properties property;

    {
        FileInputStream inputStream;
        property = new Properties();

        try {
            inputStream = new FileInputStream("src/main/resources/configDB.properties");
            property.load(inputStream);
        } catch (
                FileNotFoundException e) {
            System.out.println("Не найден конфиг");
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return property.getProperty("db_login");
    }

    public String getPass() {
        return property.getProperty("db_password");
    }

    public String getJdbc_driver() {
        return property.getProperty("jdbc_driver");
    }

    public String getDb_url() {
        return property.getProperty("db_url");
    }
}


