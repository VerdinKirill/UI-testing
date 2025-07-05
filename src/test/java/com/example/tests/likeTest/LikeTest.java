package com.example.tests.likeTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Тестовый класс для проверки функциональности лайков.
 * Проверяет постановку и снятие лайка, а также сохранение состояния после обновления страницы.
 */
public class LikeTest extends BaseTest {
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
     * Проверяет функциональность лайка:
     * 1. Постановка лайка и проверка изменения состояния
     * 2. Сохранение состояния после обновления страницы
     * 3. Снятие лайка и проверка возврата в исходное состояние
     *
     * Шаги теста:
     * 1. Аутентификация пользователя
     * 2. Открытие главной страницы
     * 3. Открытие первого пина
     * 4. Получение исходного состояния кнопки лайка
     * 5. Постановка лайка и проверка изменения состояния
     * 6. Обновление страницы и проверка сохранения состояния
     * 7. Снятие лайка и проверка возврата в исходное состояние
     */
    @Test
    public void shouldToggleLikeAndPersistStateAfterRefresh() {
        // Аутентификация и открытие главной страницы
        MainPage mainPage = auth(login, password);

        // Открытие первого пина
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);

        // Получение исходного состояния кнопки лайка
        String initialPathData = pinPage.getDLikeButton();

        // Постановка лайка
        pinPage.clickLikeButton();
        String likedPathData = pinPage.getDLikeButton();

        // Проверка изменения состояния
        assertNotEquals(initialPathData, likedPathData, "Данные пути должны измениться после постановки лайка");

        // Обновление страницы
        pinPage = pinPage.refresh(PinPage.class);
        String refreshedPathData = pinPage.getDLikeButton();

        // Проверка сохранения состояния
        assertEquals(likedPathData, refreshedPathData, "Состояние лайка должно сохраниться после обновления страницы");

        // Снятие лайка
        pinPage.clickLikeButton();
        String unlikedPathData = pinPage.getDLikeButton();

        // Проверка возврата в исходное состояние
        assertEquals(initialPathData, unlikedPathData, "Данные пути должны вернуться к исходному состоянию после снятия лайка");
    }
}