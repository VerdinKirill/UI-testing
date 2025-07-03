package com.example.Elements;

import java.lang.reflect.UndeclaredThrowableException;
import java.time.Duration;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Базовый класс для всех элементов пользовательского интерфейса.
 * Инкапсулирует общую функциональность для работы с веб-элементами.
 */
public class BaseElement {
    protected static final int WAIT_SECONDS = 10;
    protected final SelenideElement baseElement;

    /**
     * Конструктор базового элемента.
     * 
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter     параметр для подстановки в шаблон XPath
     */
    protected BaseElement(String xpath, String attributeValue) {
        baseElement = $x(String.format(xpath, attributeValue));
    }

    /**
     * Проверяет, отображается ли элемент на странице.
     * Ожидает появление элемента в течение стандартного времени ожидания.
     * 
     * @return true если элемент отображается, иначе false
     */
    public boolean isDisplayed() {
        try {
            return baseElement
                    .shouldBe(visible, Duration.ofSeconds(WAIT_SECONDS))
                    .isDisplayed();
        } catch (UndeclaredThrowableException | ElementNotFound e) {
            return false;
        }
    }

    /**
     * Проверяет, отображается ли элемент на странице с кастомным временем ожидания.
     * 
     * @param seconds время ожидания в секундах
     * @return true если элемент отображается, иначе false
     */
    public boolean isDisplayed(int seconds) {
        try {
            baseElement.shouldBe(visible, Duration.ofSeconds(seconds));
            return baseElement.isDisplayed();
        } catch (UndeclaredThrowableException | ElementNotFound e) {
            return false;
        }
    }

    /**
     * Проверяет, доступен ли элемент для взаимодействия.
     * 
     * @return true если элемент доступен, иначе false
     */
    public boolean isEnabled() {
        return baseElement.isEnabled();
    }

    /**
     * Возвращает значение указанного атрибута элемента.
     * 
     * @param attributeName название атрибута
     * @return значение атрибута или null, если атрибут отсутствует
     */
    public String getAttribute(String attributeName) {
        return baseElement.getAttribute(attributeName);
    }
}