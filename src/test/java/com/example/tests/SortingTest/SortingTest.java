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
        initTestData();
        MainPage mainPage = auth(login, password);
        BoardsPage boardsPage = mainPage.clickAccountButton(BoardsPage.class);
        boardsPage.clickMoreOptionsButton();
        boardsPage.clickAlphabeticOrderButton();
        String previewName = boardsPage.getPreviewName();
        assertEquals("Котята", previewName);

        boardsPage.clickMoreOptionsButton();
        boardsPage.clickLastAddedOrderButton();
        previewName = boardsPage.getPreviewName();
        assertEquals("Тестовая доска", previewName);
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
    }


}