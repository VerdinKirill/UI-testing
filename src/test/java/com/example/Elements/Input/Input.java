package com.example.Elements.Input;

import org.openqa.selenium.Keys;

import com.example.Elements.BaseElement;

public class Input extends BaseElement {
    private static final String ID_XPATH = "//input[@id='%s']";
    private static final String NAME_XPATH = "//input[@name='%s']";
    private static final String CLASS_XPATH = "//input[@class='%s']";

    private Input(String xpath, String param) {
        super(xpath, param);
    }

    public void fill(String value) {
        // baseElement.clear() не работает :(
        while (!baseElement.getAttribute("value").equals("")) {
            baseElement.sendKeys(Keys.BACK_SPACE);
        }
        baseElement.sendKeys(value);
    }

    public static Input byId(String id) {
        return new Input(ID_XPATH, id);
    }

    public static Input byName(String name) {
        return new Input(NAME_XPATH, name);
    }

    public static Input byClass(String text) {
        return new Input(CLASS_XPATH, text);
    }
}