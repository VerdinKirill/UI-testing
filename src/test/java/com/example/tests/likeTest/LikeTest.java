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
     */
    @Test
    public void shouldToggleLikeAndPersistStateAfterRefresh() {
        System.out.println("[INFO] Начало теста: shouldToggleLikeAndPersistStateAfterRefresh");

        // Аутентификация и открытие главной страницы
        System.out.println("[ACTION] Аутентификация пользователя");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Аутентификация прошла успешно");

        // Открытие первого пина
        System.out.println("[ACTION] Открытие первого пина");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        System.out.println("[SUCCESS] Пин открыт");

        // Получение исходного состояния кнопки лайка
        System.out.println("[ACTION] Получение исходного состояния лайка");
        String initialPathData = pinPage.getDLikeButton();
        System.out.println("[INFO] Исходное состояние кнопки: " + initialPathData);

        // Постановка лайка
        System.out.println("[ACTION] Клик по кнопке лайка");
        pinPage.clickLikeButton();
        String likedPathData = pinPage.getDLikeButton();
        System.out.println("[INFO] Состояние после лайка: " + likedPathData);

        // Проверка изменения состояния
        System.out.println("[ASSERTION] Проверка, что состояние изменилось после лайка");
        assertNotEquals(initialPathData, likedPathData, "Данные пути должны измениться после постановки лайка");
        System.out.println("[ASSERTION PASSED] Состояние изменилось после лайка");

        // Обновление страницы
        System.out.println("[ACTION] Обновление страницы");
        pinPage = pinPage.refresh(PinPage.class);
        String refreshedPathData = pinPage.getDLikeButton();
        System.out.println("[INFO] Состояние после обновления страницы: " + refreshedPathData);

        // Проверка сохранения состояния
        System.out.println("[ASSERTION] Проверка, что лайк сохранился после обновления страницы");
        assertEquals(likedPathData, refreshedPathData, "Состояние лайка должно сохраниться после обновления страницы");
        System.out.println("[ASSERTION PASSED] Лайк сохранился после обновления");

        // Снятие лайка
        System.out.println("[ACTION] Снятие лайка");
        pinPage.clickLikeButton();
        String unlikedPathData = pinPage.getDLikeButton();
        System.out.println("[INFO] Состояние после снятия лайка: " + unlikedPathData);

        // Проверка возврата в исходное состояние
        System.out.println("[ASSERTION] Проверка возврата к исходному состоянию после снятия лайка");
        assertEquals(initialPathData, unlikedPathData, "Данные пути должны вернуться к исходному состоянию после снятия лайка");
        System.out.println("[ASSERTION PASSED] Состояние вернулось к исходному после снятия лайка");

        System.out.println("[INFO] Завершение теста: shouldToggleLikeAndPersistStateAfterRefresh");
    }
}