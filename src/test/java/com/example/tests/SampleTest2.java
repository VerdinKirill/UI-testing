package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import io.github.cdimascio.dotenv.Dotenv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SampleTest2 {

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        WebDriverManager.chromedriver().setup();
        open("https://www.google.com");
    }

    @Test
    void googleSearchTest() {
        // try {

        // Thread.sleep(100000);
        // } catch (InterruptedException error) {

        // }
        if ($x("//*[@id=\"L2AGLb\"]").exists()) {
            $x("//*[@id=\"L2AGLb\"]").click();
            ;
        }

        // try {

        // Thread.sleep(100000);
        // } catch (InterruptedException error) {

        // }
        SelenideElement input = $x("//*[@id=\"APjFqb\"]");
        input.click();
        input.setValue("Selenide");
        input.pressEnter();
        // $x("//*[@id=\"APjFqb\"]").click();
    }
}