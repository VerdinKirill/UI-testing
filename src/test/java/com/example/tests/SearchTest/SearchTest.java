package com.example.tests.SearchTest;

import com.example.pages.MainPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Тестовый класс для проверки функциональности поиска.
 * Проверяет поиск по запросу.
 */
public class SearchTest extends BaseTest {
    private static final String SEARCH_STR = "Милые котики";
    private String login;
    private String password;

    @Test
    public void checkAuth() {
        initTestData();
        MainPage mainPage = auth(login, password);
        mainPage.openSearchBar();
        mainPage.fillSearchBar(SEARCH_STR);
        mainPage.submitSearch();
        String encodedNoResultsTerm = URLEncoder.encode(SEARCH_STR, StandardCharsets.UTF_8).replace("+", "%20");
        System.out.println(encodedNoResultsTerm);
        String expectedUrlPart = "?q=" + encodedNoResultsTerm;
        mainPage.waitForSearchPageLoad(expectedUrlPart);
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