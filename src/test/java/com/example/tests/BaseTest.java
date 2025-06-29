//Базовый класс теста, от него наследуем другие классы тестов и их файлы в отдельную папку
package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;


import io.qameta.allure.selenide.AllureSelenide;

//Класс BaseTest, от него насследуются другие классы Тестов
public class BaseTest {

    //Перед каждым тестом происходит настройка конфигурации
    @BeforeEach
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x720";
        Configuration.pageLoadStrategy = "eager"; //пинтерест ассинхроно очень много вещей подгружает и чтобы это не ждать 'normal' заменили на 
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 60000;
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
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
    protected void auth(String username, String password) {

        // надо добавить auth, мб через апи как то можно норм сделать а может и нет, в
        // таком случае будем как в логин тесте тыкать
    }
}