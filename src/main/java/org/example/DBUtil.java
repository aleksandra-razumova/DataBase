package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    //Команда для вывода значений по конкретному id автора
    private static final String GET_BY_ID ="SELECT * FROM library WHERE library.author_id =?";
    //Команда для вывода всех значений
    private static final String GET_ALL ="SELECT * FROM library";
    public static Connection createConnection() throws SQLException {

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"));
        return connection;
    }

    public ResultSet getById(int id) throws SQLException {
        //PreparedStatement - подготовленное выражение, через него будем отправлять запросы к БД.
        //Cначала компилируется, проверяется, после этого выполняется.
        PreparedStatement preparedStatement = createConnection().prepareStatement(GET_BY_ID);
        preparedStatement.setInt(1,id);

        return  preparedStatement.executeQuery();
    }

    public ResultSet getAll() throws SQLException {
        PreparedStatement preparedStatement = createConnection().prepareStatement(GET_ALL);
        return  preparedStatement.executeQuery();
    }
}
