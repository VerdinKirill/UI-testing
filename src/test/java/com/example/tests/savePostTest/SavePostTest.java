package com.example.tests.savePostTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности сохранения поста.
 */
public class SavePostTest extends BaseTest {
    private String login;
    private String password;

    @Test
    public void savePost() {
        System.out.println("[INFO] Начало теста: savePost");

        initTestData();

        System.out.println("[ACTION] Аутентификация и открытие главной страницы");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Главная страница загружена");

        System.out.println("[ACTION] Переход к первому посту");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        System.out.println("[SUCCESS] Страница поста загружена");

        System.out.println("[ACTION] Нажатие кнопки сохранения поста");
        pinPage.clickSaveButton();

        System.out.println("[ASSERTION] Проверка, что пост успешно сохранён");
        assertTrue(pinPage.isPostSaved(), "Пост должен быть сохранён");
        System.out.println("[ASSERTION PASSED] Пост сохранён");

        System.out.println("[INFO] Завершение теста: savePost");
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        System.out.println("[INIT] Загрузка данных из .env");
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
        System.out.println("[INIT DONE] Данные загружены");
    }
}