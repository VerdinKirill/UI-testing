package com.example.tests.OpenClosePostTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности открытия и закрытия постов.
 * Проверяет корректность перехода на страницу поста и возврата на главную страницу.
 */
public class OpenClosePostTest extends BaseTest {
    private String login;
    private String password;

    /**
     * Инициализирует тестовые данные перед каждым тестом.
     * Загружает учетные данные из .env файла.
     */
    @BeforeEach
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
    }

    /**
     * Проверяет функциональность открытия и закрытия поста:
     * 1. Открытие поста и проверка URL
     * 2. Возврат на главную страницу и проверка отображения
     */
    @Test
    public void shouldOpenPostAndReturnToMainPage() {
        // Аутентификация и открытие главной страницы
        MainPage mainPage = auth(login, password);

        // Получение URL первого поста
        String firstPostUrl = mainPage.getHrefOfFirstImage();

        // Открытие страницы поста
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.waitForPinPageLoad(firstPostUrl);

        // Проверка URL страницы поста
        String currentUrl = pinPage.getCurrentUrl();
        assertTrue(currentUrl.contains(firstPostUrl),
                "URL страницы поста должен содержать URL превью");

        // Возврат на главную страницу
        mainPage = pinPage.clickBackButton(MainPage.class);

        // Проверка отображения главной страницы
        assertTrue(mainPage.isDisplayed(),
                "Главная страница должна отображаться после возврата");
    }
}