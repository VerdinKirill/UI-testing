package com.example.Elements.Input;

import org.openqa.selenium.Keys;

import com.example.Elements.BaseElement;

//Input - класс насследник от BaseElement
//Является плашкой, куда мы вводим текст
public class Input extends BaseElement {
    private static final String ID_XPATH = "//input[@id='%s']";
    private static final String NAME_XPATH = "//input[@name='%s']";
    private static final String CLASS_XPATH = "//input[@class='%s']";

    private Input(String xpath, String param) {
        super(xpath, param);
    }

    // метод для того, чтобы очистить текст, а потом вставить свой текст в инпут
    public void fill(String value) {
        // baseElement.clear() не работает :(
        // не особо безопасная штука наверное ниже, но придумать что-то другое я не смог
        while (!baseElement.getAttribute("value").equals("")) {
            baseElement.sendKeys(Keys.BACK_SPACE);
        }
        baseElement.sendKeys(value);
    }
    //получение элемента инпута по айди
    public static Input byId(String id) {
        return new Input(ID_XPATH, id);
    }

    //получение элемента инпута по имени
    public static Input byName(String name) {
        return new Input(NAME_XPATH, name);
    }

    //получение элемента инпута по названию класса
    public static Input byClass(String text) {
        return new Input(CLASS_XPATH, text);
    }
}