package com.example.elements.Input;

import com.example.elements.BaseElement;
import org.openqa.selenium.Keys;

/**
 * Класс для работы с элементами типа "поле ввода".
 * Предоставляет методы для поиска полей ввода по различным атрибутам
 * и выполнения действий над ними.
 */
public class Input extends BaseElement {
    private static final String ID_XPATH = "//input[@id='%s']";
    private static final String NAME_XPATH = "//input[@name='%s']";
    private static final String CLASS_XPATH = "//input[@class='%s']";

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private Input(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Очищает поле ввода.
     */
    public void clear() {
        while (!baseElement.getAttribute("value").equals("")) {
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
     * @return экземпляр класса Input
     */
    public static Input byId(String id) {
        return new Input(ID_XPATH, id);
    }

    /**
     * Находит поле ввода по имени.
     *
     * @param name имя поля ввода
     * @return экземпляр класса Input
     */
    public static Input byName(String name) {
        return new Input(NAME_XPATH, name);
    }

    /**
     * Находит поле ввода по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса Input
     */
    public static Input byClass(String text) {
        return new Input(CLASS_XPATH, text);
    }
}