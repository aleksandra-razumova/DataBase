package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)  throws SQLException {

        DBUtil dbUtil = new DBUtil();
        //Подключение к БД
        Connection connection = DBUtil.createConnection();

        //Проверяем, закрыто ли соединение (если будет false, значит открыто, удалось подключиться).
        System.out.println(connection.isClosed());

        //ResultSet - множество, к-е хранит результат запроса.
        ResultSet resultSet = dbUtil.getById(1); //Получение элементов по id автора

        //Вывод в консоль элементов из таблицы, котоорые соответствуют "Автор Л.Н.Толстой"
        while (resultSet.next()){
            System.out.println(resultSet.getInt("book_id")
                    + " | "+resultSet.getString("book_name")
                    + " | " + resultSet.getInt("number_of_pages")
                    + " | " + resultSet.getInt("author_id"));
        }

        System.out.println();

        resultSet = dbUtil.getAll(); //Получение всех элементов

        List<Book> books = new ArrayList<>();
        //Создаем список книг со значениями из таблицы
        int i = 0;
        while (resultSet.next()){
            books.add(new Book(
                    resultSet.getInt("book_id"),
                    resultSet.getString("book_name"),
                    resultSet.getInt("number_of_pages"),
                    resultSet.getInt("author_id")
            ));

            System.out.println(books.get(i)); //Вывод элементов полученного списка
            i++;
        }
    }
}