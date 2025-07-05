package com.example.Elements.span;

import com.example.Elements.BaseElement;
import org.openqa.selenium.Keys;

public class Span extends BaseElement {
    private static final String ID_XPATH = "//span[@id='%s']";
    private static final String NAME_XPATH = "//span[@name='%s']";
    private static final String CLASS_XPATH = "//span[@class='%s']";

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private Span(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Очищает поле ввода.
     */
    public void clear() {
        while (!baseElement.getAttribute("value").isEmpty()) {
            baseElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    /**
     * Вводит указанное значение в поле ввода.
     *
     * @param value значение для ввода
     */
    public void fill(String value) {
        clear();
        baseElement.sendKeys(value);
    }

    /**
     * Кликает на элемент.
     */
    public void click() {
        baseElement.click();
    }

    /**
     * Нажимает Enter для подтверждения.
     */
    public void pressEnter() {
        baseElement.pressEnter();
    }

    /**
     * Находит поле ввода по идентификатору.
     *
     * @param id идентификатор поля ввода
     * @return экземпляр класса span
     */
    public static Span byId(String id) {
        return new Span(ID_XPATH, id);
    }

    /**
     * Находит поле ввода по имени.
     *
     * @param name имя поля ввода
     * @return экземпляр класса span
     */
    public static Span byName(String name) {
        return new Span(NAME_XPATH, name);
    }

    /**
     * Находит поле ввода по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса span
     */
    public static Span byClass(String text) {
        return new Span(CLASS_XPATH, text);
    }
}
