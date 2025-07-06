package com.example.pages;

import com.example.elements.Article.Article;
import com.example.elements.Button.Button;
import com.example.elements.MansoryContainer.MansoryContainer;
import com.example.elements.SearchHeader.SearchHeader;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;

//Класс главной страницы, где уже есть картинки, наследуется от BasePage

public class MainPage extends BasePage {
    private static final String MAIN_CONTAINER_XPATH = "//*[@role='main']";
    private static final String MASONRY_CONTAINER_CLASS = "masonryContainer";
    private static final String SEARCH_HEADER_ID = "HeaderContent";
    private static final String SETTINGS_BUTTON_ARIA_LABEL = "Другие варианты";
    private static final String SETTINGS_ARTICLE_XPATH = "//*[@id=\"VerticalNav-MoreOptions-Flyout-item-0\"]/div/a";
    private final Button undoActionButton = Button.byXPath("//*[@data-test-id=\"undo-action-btn\"]");

    private final MansoryContainer mansoryContainer = MansoryContainer.byClass(MASONRY_CONTAINER_CLASS);
    private final SearchHeader searchHeader = SearchHeader.byId(SEARCH_HEADER_ID);
    private final Button settingsModalButton = Button.byAriaLabel(SETTINGS_BUTTON_ARIA_LABEL);
    private final Article settingsArticle = Article.byXpath(SETTINGS_ARTICLE_XPATH);

    /**
     * Конструктор главной страницы.
     * Инициализирует страницу с валидационным XPath.
     */
    public MainPage() {
        super(MainPage.class, MAIN_CONTAINER_XPATH);
    }

    /**
     * Проверяет отображение главной страницы.
     *
     * @return true если страница отображается, иначе false
     */
    public boolean isDisplayed() {
        return mansoryContainer.isDisplayed();
    }

    /**
     * Получает ссылку на статью первого изображения.
     *
     * @return URL статьи
     */
    public String getHrefOfFirstImage() {
        return mansoryContainer.getHrefOfFirstImage();
    }

    /**
     * Открывает статью первого изображения.
     *
     * @return экземпляр страницы статьи
     */
    public <T extends BasePage> T clickOnFirstImage(Class<T> className) {
        mansoryContainer.clickOnImage();
        return page(className);
    }

    /**
     * Активирует поле поиска.
     */
    public void openSearchBar() {
        searchHeader.openSearchBar();
    }

    /**
     * Вводит текст в поле поиска.
     *
     * @param searchText текст для поиска
     */
    public void fillSearchBar(String searchText) {
        searchHeader.fillSearchText(searchText);
    }

    /**
     * Выполняет поиск.
     */
    public void submitSearch() {
        searchHeader.pressEnter();
    }

    /**
     * Ожидает загрузку страницы по частичному совпадению URL.
     *
     * @param expectedUrlPart часть ожидаемого URL
     */
    public void waitForSearchPageLoad(String expectedUrlPart) {
        Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    /**
     * Открывает страницу аккаунта.
     *
     * @return экземпляр страницы аккаунта
     */
    public <T extends BasePage> T clickAccountButton(Class<T> className) {
        searchHeader.clickAccountButton();
        return page(className);
    }

    /**
     * Получает значение атрибута aria-label для n-го элемента.
     *
     * @param n порядковый номер элемента
     * @return значение атрибута aria-label
     */
    public String getNthAriaLabel(int n) {
        return mansoryContainer.getNthArticleAriaLabel(n);
    }

    /**
     * Открывает меню настроек.
     */
    public void clickSettingsModalButton() {
        settingsModalButton.click();
    }

    /**
     * Открывает страницу настроек.
     *
     * @return экземпляр страницы настроек
     */
    public <T extends BasePage> T clickSettings(Class<T> className) {
        settingsArticle.click();
        return page(className);
    }

    /**
     * Проверяет, появилась ли возможность отменить действие скрытия
     *
     * @return true или false соответвенно
     */
    public boolean undoDisplayed() {
        return undoActionButton.isDisplayed();
    }


}

