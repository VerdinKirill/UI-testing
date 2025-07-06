package com.example.tests.HideTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности скрытия пинов.
 * Проверяет возможность скрытия пина и отмены этого действия.
 */
public class HideTest extends BaseTest {
    private String login;
    private String password;

    /**
     * Проверяет функциональность скрытия пина и отмены этого действия.
     */
    @Test
    public void checkHidePost() {
        System.out.println("[INFO] Начало теста: checkHidePost");

        // Инициализация данных
        System.out.println("[ACTION] Инициализация учетных данных");
        initTestData();
        System.out.println("[SUCCESS] Данные инициализированы: login=" + login);

        // Аутентификация
        System.out.println("[ACTION] Аутентификация пользователя");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Аутентификация прошла успешно");

        // Получение ссылки на первый пин
        System.out.println("[ACTION] Получение href первого пина");
        String hrefPreview = mainPage.getHrefOfFirstImage();
        System.out.println("[INFO] href пина: " + hrefPreview);

        // Переход к пину
        System.out.println("[ACTION] Клик на первый пин");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        System.out.println("[ACTION] Ожидание загрузки страницы пина");
        pinPage.waitForPinPageLoad(hrefPreview);
        System.out.println("[SUCCESS] Страница пина загружена");

        // Скрытие пина
        System.out.println("[ACTION] Нажатие кнопки 'Еще опции'");
        pinPage.clickMoreOptionsButton();
        System.out.println("[ACTION] Нажатие кнопки 'Скрыть пин'");
        pinPage.clickHidePinButton();

        // Подтверждение "Не интересно"
        System.out.println("[ACTION] Подтверждение скрытия: 'Не интересно'");
        mainPage = pinPage.clickNotInterestedButton(MainPage.class);
        System.out.println("[SUCCESS] Возврат на главную страницу");

        // Проверка отображения кнопки "Отменить"
        System.out.println("[ASSERTION] Проверка отображения кнопки 'Отменить'");
        assertTrue(mainPage.undoDisplayed());
        System.out.println("[ASSERTION PASSED] Кнопка 'Отменить' отображается");

        System.out.println("[INFO] Завершение теста: checkHidePost");
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