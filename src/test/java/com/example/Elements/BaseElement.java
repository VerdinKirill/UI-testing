package com.example.Elements;

import java.lang.reflect.UndeclaredThrowableException;
import java.time.Duration;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;  // Add this import
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class BaseElement {
    protected static final int WAIT_SECONDS = 10;
    protected final SelenideElement baseElement;

    protected BaseElement(String xpath, String attributeValue) {
        baseElement = $x(String.format(xpath, attributeValue));
    }

    public boolean isDisplayed() {
        try {
            return baseElement
                    .shouldBe(visible, Duration.ofSeconds(WAIT_SECONDS))
                    .isDisplayed();
        } catch (UndeclaredThrowableException | ElementNotFound e) {
            return false;
        }
    }
}