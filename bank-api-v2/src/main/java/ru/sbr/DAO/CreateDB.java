package ru.sbr.DAO;

import java.sql.SQLException;
import java.sql.Statement;

import static ru.sbr.DAO.ConnectionDB.connection;

public class CreateDB {
    public static int dbCreate() {
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE PUBLIC.CLIENTS (\n" +
                    "\tID BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "\tNAME VARCHAR(100) NOT NULL,\n" +
                    "\tCONSTRAINT CLIENTS_PK PRIMARY KEY (ID)\n" +
                    ");");

            statement.executeUpdate("CREATE TABLE PUBLIC.ACCOUNTS (\n" +
                    "\tID BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "\tACCOUNT BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "\tID_CLIENT BIGINT NOT NULL,\n" +
                    "\tCONSTRAINT ACCOUNTS_PK PRIMARY KEY (ID),\n" +
                    "\tCONSTRAINT ACCOUNTS_FK FOREIGN KEY (ID_CLIENT) REFERENCES PUBLIC.CLIENTS(ID) ON DELETE SET NULL\n" +
                    ");");

            statement.executeUpdate("CREATE TABLE PUBLIC.CARDS (\n" +
                    "\tID BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "\tCARD_NUMBER BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "\tBALANCE DECIMAL(15, 2),\n" +
                    "\tID_ACCOUNT BIGINT NOT NULL,\n" +
                    "\tCONSTRAINT CARDS_PK PRIMARY KEY (ID),\n" +
                    "\tCONSTRAINT CARDS_FK FOREIGN KEY (ID_ACCOUNT) REFERENCES PUBLIC.ACCOUNTS(ID) ON DELETE SET NULL\n" +
                    ");");

            statement.executeUpdate("INSERT INTO PUBLIC.CLIENTS (NAME)\n" +
                    "\tVALUES ('Anna Sidorova');\n" +
                    "INSERT INTO PUBLIC.CLIENTS (NAME)\n" +
                    "\tVALUES ('Maxim Ivanov');\n" +
                    "INSERT INTO PUBLIC.CLIENTS (NAME)\n" +
                    "\tVALUES ('Oleg Petrov');");

            statement.executeUpdate("INSERT INTO PUBLIC.ACCOUNTS (ACCOUNT,ID_CLIENT)\n" +
                    "\tVALUES (1000000000000,1);");


            statement.executeUpdate("INSERT INTO PUBLIC.ACCOUNTS (ID_CLIENT)\n" +
                    "\tVALUES (2);\n" +
                    "INSERT INTO PUBLIC.ACCOUNTS (ID_CLIENT)\n" +
                    "\tVALUES (3);\n" +
                    "INSERT INTO PUBLIC.ACCOUNTS (ID_CLIENT)\n" +
                    "\tVALUES (1);");

            statement.executeUpdate("INSERT INTO PUBLIC.CARDS (CARD_NUMBER,BALANCE,ID_ACCOUNT)\n" +
                    "\tVALUES (111000000000,10000.0,3);");

            statement.executeUpdate("INSERT INTO PUBLIC.CARDS (BALANCE,ID_ACCOUNT)\n" +
                    "\tVALUES (5000.0,3);\n" +
                    "INSERT INTO PUBLIC.CARDS (BALANCE,ID_ACCOUNT)\n" +
                    "\tVALUES (150000.0,1);");

            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
}
