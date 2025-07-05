package com.example.elements.path;

import com.example.elements.BaseElement;

/**
 * Класс для работы с элементами SVG-пути.
 * Предоставляет методы для взаимодействия с тегом &lt;path&gt; в SVG-графике.
 */
public class Path extends BaseElement {
    private static final String D_ATTRIBUTE = "d";

    /**
     * Конструктор класса.
     *
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter параметр для подстановки в шаблон XPath
     */
    protected Path(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
    }

    /**
     * Получает значение атрибута 'd' элемента пути.
     * Атрибут 'd' содержит команды для построения SVG-пути.
     *
     * @return значение атрибута 'd'
     */
    public String getD() {
        return getAttribute(D_ATTRIBUTE);
    }

    /**
     * Находит элемент пути по указанному XPath.
     *
     * @param xPath XPath для поиска элемента
     * @return экземпляр класса Path
     */
    public static Path byXpath(String xPath) {
        return new Path("%s", xPath);
    }
}