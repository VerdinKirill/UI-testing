package com.example.Elements.path;

public class Path extends com.example.elements.BaseElement {

    /**
     * Конструктор базового элемента.
     *
     * @param xpath
     * @param attributeValue
     */
    protected Path(String xpath, String attributeValue) {
        super(xpath, attributeValue);
    }

    public String getD() {
        return getAttribute("d");
    }

    public static Path byXpath(String xpath) {
        return new Path(xpath, "");
    }
}