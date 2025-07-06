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
        System.out.println("[INFO] Начало теста: checkSearch");

        initTestData();

        System.out.println("[ACTION] Аутентификация пользователя");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Успешный вход в систему");

        System.out.println("[ACTION] Открытие и заполнение строки поиска");
        mainPage.openSearchBar();
        mainPage.fillSearchBar(SEARCH_STR);
        mainPage.submitSearch();

        String encodedNoResultsTerm = URLEncoder.encode(SEARCH_STR, StandardCharsets.UTF_8).replace("+", "%20");
        String expectedUrlPart = "?q=" + encodedNoResultsTerm;
        System.out.println("[WAIT] Ожидание загрузки страницы поиска с URL частью: " + expectedUrlPart);
        mainPage.waitForSearchPageLoad(expectedUrlPart);

        System.out.println("[INFO] Сбор aria-label для первых 10 результатов");
        StringBuilder ariaLabels = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            String ariaLabel = mainPage.getNthAriaLabel(i);
            System.out.printf("[ARIA] #%d: %s%n", i, ariaLabel);
            ariaLabels.append(ariaLabel);
        }

        System.out.println("[ASSERTION] Проверка, что хотя бы один ключ найден в результатах");
        assertContainsAtLeastOneKeyword(ariaLabels.toString(), SEARCH_KEYWORDS);

        System.out.println("[SUCCESS] Тест checkSearch завершён успешно");
    }

    /**
     * Проверяет что в строке содержится хотя бы один кейворд.
     */
    private void assertContainsAtLeastOneKeyword(String text, List<String> keywords) {
        boolean found = keywords.stream()
                .anyMatch(keyword -> text.toLowerCase().contains(keyword.toLowerCase()));

        assertTrue(found, String.format(
                "[ERROR] Ни один из ожидаемых ключей (%s) не найден. Актуальный текст: %s",
                String.join(", ", keywords),
                text
        ));
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        System.out.println("[INIT] Загрузка данных пользователя из .env");
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
        System.out.println("[INIT DONE] Логин и пароль загружены");
    }
}