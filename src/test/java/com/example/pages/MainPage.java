package com.example.pages;

import com.example.elements.Button.Button;
import com.example.elements.Article.Article;
import com.example.elements.MansoryContainer.MansoryContainer;
import com.example.elements.SearchHeader.SearchHeader;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;

//Класс главной страницы, где уже есть картинки, наследуется от BasePage

public class MainPage extends BasePage {
    private final MansoryContainer mansoryContainer = MansoryContainer.byClass("masonryContainer");
    private final SearchHeader searchHeader = SearchHeader.byId("HeaderContent");
    private final Button settingsModalButton = Button.byAriaLabel("Другие варианты");
    private final Article settingsArticle = Article.byXpath("//*[@id=\"VerticalNav-MoreOptions-Flyout-item-0\"]/div/a");


    public MainPage() {
        super(MainPage.class, "//*[@role=main]");
    }

    public boolean isDisplayed() {
        return mansoryContainer.isDisplayed();
        // return welcomeMessage.exists() && welcomeMessage.isDisplayed();
    }

    public String getHrefOfFirstImage() {
        return mansoryContainer.getHrefOfFirstImage();
    }

    public <T extends BasePage> T clickOnFirstImage(Class<T> className) {
        mansoryContainer.clickOnImage();
        return page(className);
    }

    public void openSearchBar() {
        searchHeader.open();
    }

    public void fillSearchBar(String searchText) {
        searchHeader.fillSearchText(searchText);
    }

    public void submitSearch() {
        searchHeader.pressEnter();
    }

    public void waitForSearchPageLoad(String expectedUrlPart) {
        Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    public <T extends BasePage> T clickAccountButton(Class<T> className) {
        searchHeader.clickAccountButton();
        return page(className);
    }

    public void clickSettingsModalButton() {
        settingsModalButton.click();
    }

    public <T extends BasePage> T clickSettings(Class<T> className) {
        settingsArticle.click();
        return page(className);
    }


}

