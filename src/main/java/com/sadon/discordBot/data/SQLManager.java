package com.sadon.discordBot.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLManager {
    public static void createTables(){
        LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS numbers(number1 INTEGER, number2 INTEGER)");
    }

    public static void insertValues(){
        LiteSQL.onUpdate("INSERT INTO numbers(number1, number2) VALUES(10, 25)");
    }

    public static void getValues(){
        ResultSet resultSet = LiteSQL.onQuery("SELECT * FROM numbers");
        try{
            System.out.println(resultSet.getInt(1));
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}
