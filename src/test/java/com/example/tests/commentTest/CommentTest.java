package com.example.tests.commentTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.Wait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности комментирования пинов.
 * Проверяет возможность добавления комментария с текстом и изображением.
 */
public class CommentTest extends BaseTest {
    private static final String COMMENT_TEXT = "Классный пост!";
    private static final String IMAGE_PATH = "./testAssets/commentTest.png";
    private static final Duration COMMENT_UPDATE_TIMEOUT = Duration.ofSeconds(10);

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
        pinPage.clickChoosePhotoButton();
        pinPage.loadPhoto(new File(IMAGE_PATH));

        // Отправка комментария
        String oldCount = pinPage.getCommentCount();
        pinPage.clickSendCommentButton();
        Wait().withTimeout(COMMENT_UPDATE_TIMEOUT)
                .until(d -> !pinPage.getCommentCount().equals(oldCount));

        String newCount = pinPage.getCommentCount();
        assertNotEquals(oldCount, newCount);
    }
}