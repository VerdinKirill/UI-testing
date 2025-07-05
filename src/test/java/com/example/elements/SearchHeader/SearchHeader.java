package com.example.Elements.SearchHeader;

import com.example.Elements.Button.Button;
import com.example.Elements.BaseElement;
import com.example.Elements.Input.Input;

public class SearchHeader extends BaseElement {
    private static final String CLASS_XPATH = "//*[@id='%s']";
    private final Input searchInput = Input.byName("searchBoxInput");
    private final Button accountButton = Button.byXPath("//*[@id=\"HeaderContent\"]/div/div/div[2]/div/div/div/div[2]/div/div/div/a");


    private SearchHeader(String xpath, String param) {
        super(xpath, param);
    }

    public static SearchHeader byId(String text) {
        return new SearchHeader(CLASS_XPATH, text);
    }

    public void open() {
        searchInput.click();
    }

    public void fillSearchText(String text) {
        searchInput.fill(text);
    }

    public void pressEnter() {
        searchInput.pressEnter();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

}