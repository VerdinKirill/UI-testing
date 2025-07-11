package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.pages.LoginPage;
import com.example.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

/**
 * Базовый класс для UI тестов.
 * Содержит общие настройки для всех тестовых классов.
 */
public class BaseTest {

    /**
     * Конфигурация тестового окружения перед каждым тестом.
     * Устанавливает параметры браузера, таймауты и базовые настройки.
     */
    @BeforeEach
    public void setUp() {
        configureBrowser();
        configureLogging();
        open("/");
    }

    /**
     * Закрывает веб-драйвер после каждого теста.
     */
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Выполняет аутентификацию пользователя.
     *
     * @param username логин пользователя
     * @param password пароль пользователя
     */
    protected MainPage auth(String login, String password) {
        LoginPage loginPage = LoginPage.open();
        loginPage = loginPage.openLoginModal(LoginPage.class);
        loginPage.enterLogin(login, LoginPage.class);
        loginPage.enterPassword(password, LoginPage.class);
        return loginPage.clickLoginButton(MainPage.class);
    }

    /**
     * Настраивает параметры браузера.
     */
    private void configureBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x720";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.baseUrl = "https://ru.pinterest.com";

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-notifications",
                "--remote-allow-origins=*",
                "--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;
        Configuration.downloadsFolder = "./downloads";
    }

    /**
     * Настраивает систему логирования.
     */
    private void configureLogging() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }
}
