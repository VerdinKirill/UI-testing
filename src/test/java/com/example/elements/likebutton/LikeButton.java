package com.example.elements.likebutton;

import com.example.elements.Button.Button;
import com.example.elements.path.Path;

/**
 * Класс для работы с кнопкой "лайк".
 * Расширяет функциональность базовой кнопки, добавляя специфичные для лайков методы.
 */
public class LikeButton extends Button {
    // Константы для шаблонов XPath
    private static final String PATH_XPATH_SUFFIX = "//*[name()='path']";
    private static final String DATA_TEST_ID_XPATH = "//button[@data-test-id='%s']";

    // Дочерний элемент
    private final Path path;

    /**
     * Конструктор класса.
     *
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter параметр для подстановки в шаблон XPath
     */
    private LikeButton(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
        this.path = Path.byXpath(String.format(xpathTemplate, parameter) + PATH_XPATH_SUFFIX);
    }

    /**
     * Получает значение атрибута 'd' элемента path внутри кнопки.
     * Используется для проверки состояния лайка (заполненный/пустой).
     *
     * @return значение атрибута 'd'
     */
    public String getPathD() {
        return path.getD();
    }

    /**
     * Находит кнопку лайка по значению атрибута data-test-id.
     *
     * @param dataTestId значение атрибута data-test-id
     * @return экземпляр класса LikeButton
     */
    public static LikeButton byDataTestId(String dataTestId) {
        return new LikeButton(DATA_TEST_ID_XPATH, dataTestId);
    }
}