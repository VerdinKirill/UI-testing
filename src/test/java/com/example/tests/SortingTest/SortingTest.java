package com.example.tests.SortingTest;

import com.example.pages.BoardsPage;
import com.example.pages.MainPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс для проверки функциональности сортировки досок.
 * Проверяет сортировку по нажатию.
 */
public class SortingTest extends BaseTest {
    private String login;
    private String password;

    @Test
    public void checkSort() {
        System.out.println("[INFO] Начало теста: checkSort");

        initTestData();

        System.out.println("[ACTION] Вход в систему");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Вход выполнен");

        System.out.println("[ACTION] Переход на страницу досок");
        BoardsPage boardsPage = mainPage.clickAccountButton(BoardsPage.class);

        // Сортировка по алфавиту
        System.out.println("[ACTION] Сортировка досок по алфавиту");
        boardsPage.openSortingOptions();
        boardsPage.sortAlphabetically();

        String previewName = boardsPage.getFirstBoardName();
        System.out.printf("[ASSERTION] Проверка: ожидаем 'Котята', получили '%s'%n", previewName);
        assertEquals("Котята", previewName, "После сортировки по алфавиту первой должна быть доска 'Котята'");

        // Сортировка по дате добавления
        System.out.println("[ACTION] Сортировка досок по дате последнего добавления");
        boardsPage.openSortingOptions();
        boardsPage.sortByLastAdded();

        previewName = boardsPage.getFirstBoardName();
        System.out.printf("[ASSERTION] Проверка: ожидаем 'Тестовая доска', получили '%s'%n", previewName);
        assertEquals("Тестовая доска", previewName, "После сортировки по последнему добавлению первой должна быть 'Тестовая доска'");

        System.out.println("[SUCCESS] Тест checkSort завершён успешно");
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        System.out.println("[INIT] Загрузка данных из .env");
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
        System.out.println("[INIT DONE] Данные загружены");
    }
}