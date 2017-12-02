import dao.ConnectionUtil;
import dao.DeveloperDAO;
import dao.jdbc.JdbcDeveloperDAOImpl;
import model.Developer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 * Необходимо создать консольное приложение, которое использует БД, созданную в домашнем задании для модуля 2.1
 и позволяет выполнять CRUD (CREATE, READ, UPDATE, DELETE) операции для таблиц:
 developers
 skills
 companies
 customers
 projects

 Пример:
 Создать разработчика, добавить ему навыки.
 Создать проект, и добавить в данный проект разработчиков.

 Необходимо придерживаться паттерна MVC.
 Необходимо обработать исключительные ситуации - выход из приложения допустим только по команде пользователя.
 Все классы должны быть грамотно проименованы и разложены по пакетам.
 Рекомендуется активно использовать интерфейсы, абстрактные классы, generics и шаблоны проектирования
 (Factory method, Builder, etc.)

 Технологии:
 Java, SQL (MySQL), JDBC.

 По желанию, для импорта коннектора MySQL, разрешено использовать Maven.

 Результатом выполнения должен быть созданный ОТДЕЛЬНЫЙ репозиторий Github/Bitbucket с:
 - файлами для инициализации и заполнения БД;
 - подробным описание задачи;
 - инструкцией по разворачиванию приложения на локальной машине.
 */

public class Homework2 {

    public static void main(String[] args) throws SQLException {
        DeveloperDAO developerDAO = new JdbcDeveloperDAOImpl();
        Developer developer = developerDAO.getById(43);
        developerDAO.delete(developer);
//        developer.setId(43);
//        developer.setFirstName("Marc");
//        developer.setLastName("Marvodii");
//        developerDAO.save(developer);
//
//        System.out.println(developer);

//        List<Developer> developers = developerDAO.getAll();
//        for (Developer developer : developers) {
//            System.out.println(developer + "\n");
//        }



    }

}
