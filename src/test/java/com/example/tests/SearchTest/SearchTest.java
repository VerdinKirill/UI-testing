package com.example.tests.SearchTest;

import com.example.pages.MainPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности поиска.
 * Проверяет поиск по запросу.
 */
public class SearchTest extends BaseTest {
    private static final String SEARCH_STR = "Милые котики";
    private static final List<String> SEARCH_KEYWORDS = Arrays.asList(
            "cat", "kit", "gat", "кот", "кош"
    );
    private String login;
    private String password;

    @Test
    public void checkSearch() {
        initTestData();
        MainPage mainPage = auth(login, password);
        mainPage.openSearchBar();
        mainPage.fillSearchBar(SEARCH_STR);
        mainPage.submitSearch();
        String encodedNoResultsTerm = URLEncoder.encode(SEARCH_STR, StandardCharsets.UTF_8).replace("+", "%20");
        System.out.println(encodedNoResultsTerm);
        String expectedUrlPart = "?q=" + encodedNoResultsTerm;
        mainPage.waitForSearchPageLoad(expectedUrlPart);

        StringBuilder ariaLabels = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            String ariaLabel = mainPage.getNthAriaLabel(i);
            ariaLabels.append(ariaLabel);
        }

        assertContainsAtLeastOneKeyword(ariaLabels.toString(), SEARCH_KEYWORDS);
    }

    /**
     * Проверяет что в строке содержится хотя бы один кейворд
     * @param text Строка
     * @param keywords Кейворды
     */
    private void assertContainsAtLeastOneKeyword(String text, List<String> keywords) {
        boolean found = keywords.stream()
                .anyMatch(keyword -> text.toLowerCase().contains(keyword.toLowerCase()));

        assertTrue(found, String.format(
                "None of the expected keywords (%s) were found in the aria labels. Actual labels: %s",
                String.join(", ", keywords),
                text
        ));
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