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
        System.out.println("[INFO] Начало теста: shouldOpenPostAndReturnToMainPage");

        // Аутентификация и открытие главной страницы
        System.out.println("[ACTION] Выполняется аутентификация");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Аутентификация прошла успешно, главная страница загружена");

        // Получение URL первого поста
        System.out.println("[ACTION] Получение href первого изображения (поста)");
        String firstPostUrl = mainPage.getHrefOfFirstImage();
        System.out.println("[INFO] Получен href поста: " + firstPostUrl);

        // Открытие страницы поста
        System.out.println("[ACTION] Переход к первому посту");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.waitForPinPageLoad(firstPostUrl);
        System.out.println("[SUCCESS] Страница поста загружена");

        // Проверка URL страницы поста
        System.out.println("[ASSERTION] Проверка, что текущий URL содержит href поста");
        String currentUrl = pinPage.getCurrentUrl();
        boolean urlMatches = currentUrl.contains(firstPostUrl);
        System.out.println("[INFO] currentUrl = " + currentUrl);
        assertTrue(urlMatches, "URL страницы поста должен содержать URL превью");
        System.out.println("[ASSERTION PASSED] URL содержит href поста");

        // Возврат на главную страницу
        System.out.println("[ACTION] Нажатие кнопки назад (возврат на главную страницу)");
        mainPage = pinPage.clickBackButton(MainPage.class);

        // Проверка отображения главной страницы
        System.out.println("[ASSERTION] Проверка, что главная страница отображается");
        boolean isMainPageVisible = mainPage.isDisplayed();
        assertTrue(isMainPageVisible, "Главная страница должна отображаться после возврата");
        System.out.println("[ASSERTION PASSED] Главная страница отображается");

        System.out.println("[INFO] Завершение теста: shouldOpenPostAndReturnToMainPage");
    }
}