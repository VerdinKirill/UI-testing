package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.Pages.LoginPage.*;
import com.example.Pages.MainPage.*;

import io.qameta.allure.selenide.AllureSelenide;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        // WebDriverManager.chromiumdriver().setup();

        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x720";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 100000; // 30 секунд
        Configuration.pageLoadTimeout = 60000;
        // Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "https://ru.pinterest.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "--disable-blink-features=AutomationControlled");

        Configuration.browserCapabilities = options;

        // Логирование
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
        // open("/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    protected void auth(String username, String password) {

        LoginPage loginPage = new LoginPage();
        // loginPage.login(username, password, DashboardPage.class);
        // loginPage.login(login, password, DashboardPage.class);
    }
}