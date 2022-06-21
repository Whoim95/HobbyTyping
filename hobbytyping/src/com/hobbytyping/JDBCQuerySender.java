package com.hobbytyping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQuerySender implements JDBCQuerySenderInterface  {


    private final DBConnection connectionService = new DBConnection();

    @Override
    public String getParagraph(String textName) {

        try {
            Statement statement = connectionService.createConnection().createStatement();

            ResultSet result = statement.executeQuery(  "SELECT id FROM Text WHERE name = " + textName);
            result.next();
            int textId = result.getInt("id");

            result = statement.executeQuery(  "SELECT paragraph_num FROM Text WHERE name = " + textName);
            result.next();
            int paragraph = result.getInt("paragraph_num");

            result = statement.executeQuery("SELECT text_paragraph FROM Paragraph WHERE text_id = "
                                                + textId + " AND paragraph = " + paragraph);
            result.next();

            return result.getString("text_paragraph");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            connectionService.closeConnection();
        }
    }

    @Override
    public void setParagraph(String textName) {

        try {
            Statement statement = connectionService.createConnection().createStatement();

            ResultSet result = statement.executeQuery(   "SELECT MAX(paragraph) FROM Paragraph WHERE text_id = " +
                                                             "(SELECT id FROM Text WHERE name = " + textName + ")");
            result.next();
            int numberOfParagraph = result.getInt(1);

            result = statement.executeQuery(  "SELECT paragraph_num FROM Text WHERE name = " + textName);
            result.next();
            int paragraph = result.getInt("paragraph_num");

            if (paragraph == numberOfParagraph) {
                paragraph = 1;
            } else {
                paragraph++;
            }

            statement.executeUpdate("UPDATE Text SET paragraph_num = " + paragraph + " WHERE name = " + textName);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            connectionService.closeConnection();
        }
    }

    @Override
    public String [] getTextList() {

        try {
            Statement statement = connectionService.createConnection().createStatement();

            String [] list = new String[10];
            int n = 0;

            ResultSet result = statement.executeQuery(  "SELECT name FROM Text");
            while (result.next()) {
                list[n] = result.getString("name");
                n++;
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ne rabotaet");
            throw new RuntimeException();
        } finally {
            connectionService.closeConnection();
        }
    }

}