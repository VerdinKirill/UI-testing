package com.example.tests.SortingTest;

import org.junit.jupiter.api.Test;

import com.example.pages.MainPage;
import com.example.tests.BaseTest;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Тестовый класс для проверки функциональности сортировки досок.
 * Проверяет сортировку по нажатию.
 */
public class SortingTest extends BaseTest {
    private String login;
    private String password;

    @Test
    public void checkAuth() {
        initTestData();
        MainPage mainPage = auth(login, password);
        mainPage.clickAccountButton();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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