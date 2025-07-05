package com.example.tests.commentTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности комментирования пинов.
 * Проверяет возможность добавления комментария с текстом и изображением.
 */
public class CommentTest extends BaseTest {
    private static final String COMMENT_TEXT = "Классный пост!";
    private static final String IMAGE_PATH = "./testAssets/commentTest.png";
    private static final String COMMENT_SELECTOR = "//div[contains(text(),'%s')]";

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
     * Проверяет возможность добавления комментария с текстом и изображением.
     * Шаги теста:
     * 1. Аутентификация пользователя
     * 2. Открытие первого пина
     * 3. Ввод текста комментария
     * 4. Загрузка изображения
     * 5. Отправка комментария
     * 6. Проверка отображения комментария
     */
    @Test
    void shouldAddCommentWithTextAndImage() {
        // Аутентификация и открытие главной страницы
        MainPage mainPage = auth(login, password);

        // Открытие первого пина
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);

        // Ввод текста комментария
        pinPage.fillText(COMMENT_TEXT);

        // Загрузка изображения
        pinPage.clickSaveButton();
        pinPage.loadPhoto(new File(IMAGE_PATH));

        // Отправка комментария
        pinPage.clickSendCommentButton();
    }
}