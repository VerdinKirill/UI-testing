package com.example.elements.SearchHeader;

import com.example.elements.BaseElement;
import com.example.elements.Button.Button;
import com.example.elements.Input.Input;

/**
 * Класс для работы с шапкой поиска.
 * Инкапсулирует функциональность элементов поисковой строки и кнопок в шапке приложения.
 */
public class SearchHeader extends BaseElement {
    private static final String CLASS_XPATH = "//*[@id='%s']";

    private final Input searchInput = Input.byName("searchBoxInput");
    private final Button accountButton = Button.byXPath("//*[@id=\"HeaderContent\"]/div/div/div[2]/div/div/div/div[2]/div/div/div/a");


    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param     параметр для подстановки в шаблон XPath
     */
    private SearchHeader(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Активирует поле поиска, выполняя по нему клик.
     */
    public void open() {
        searchInput.click();
    }

    /**
     * Вводит текст в поле поиска.
     *
     * @param text текст для поиска
     */
    public void fillSearchText(String text) {
        searchInput.fill(text);
    }

    /**
     * Выполняет поиск, нажимая Enter в поле поиска.
     */
    public void pressEnter() {
        searchInput.pressEnter();
    }

    /**
     * Нажимает на кнопку аккаунта
     */
    public void clickAccountButton() {
        accountButton.click();
    }

    /**
     * Находит шапку поиска по идентификатору.
     *
     * @param text идентификатор элемента шапки
     * @return экземпляр класса SearchHeader
     */
    public static SearchHeader byId(String text) {
        return new SearchHeader(CLASS_XPATH, text);
    }

}