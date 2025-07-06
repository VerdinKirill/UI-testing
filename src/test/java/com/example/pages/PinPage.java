package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.elements.Button.Button;
import com.example.elements.H2.H2;
import com.example.elements.Input.Input;
import com.example.elements.likebutton.LikeButton;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

public class PinPage extends BasePage {

    private final Button backButton = Button.byAriaLabel("Назад");
    private final Button moreOptionsButton = Button.byAriaLabel("Другие действия");
    private final Button hidePinButton = Button.byXPath("//*[@data-test-id=\"pin-action-dropdown-hide\"]");
    private final Button notInterestedButton = Button.byXPath("//*[@data-test-id=\"hide-reason\"][1]");
    private final Button undoActionButton = Button.byXPath("//*[@data-test-id=\"undo-action-btn\"]");
    private final LikeButton likeButton = LikeButton.byDataTestId("react-button");
    private final Button downloadPinButton = Button.byXPath("//*[@data-test-id=\"pin-action-dropdown-download\"]");
    private final Button saveButton = Button.byAriaLabel("Сохранить");
    private final Button alreadySavedButton = Button.byAriaLabel("Пин сохранен");
    private final Button choosePhotoButton = Button.byAriaLabel("Выберите фото.");
    private final Input loadPhotoInput = Input.byDataTestId("photo-upload-input");
    private final SelenideElement commentTextInput = $x("//*[@class='DraftEditor-editorContainer']/div");
    private final Button sendCommentButton = Button.byAriaLabel("Опубликовать");
    private final H2 commentCount = H2.byId("comments-heading");


    /**
     * Конструктор страницы пина.
     * Инициализирует страницу с валидационным XPath.
     */
    public PinPage() {
        super(PinPage.class, "//*[@data-test-id=\"closeup-container\"]");
    }

    /**
     * Получает ссылку на эту страницу - изображение пина.
     *
     * @return URL изображения
     */
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Возвращается на предыдущую страницу.
     *
     * @return экземпляр предыдущей страницы
     */
    public <T extends BasePage> T clickBackButton(Class<T> className) {
        backButton.click();
        return page(className);
    }

    /**
     * Ожидает загрузку страницы пина по частичному совпадению URL.
     *
     * @param expectedUrlPart часть ожидаемого URL
     */
    public void waitForPinPageLoad(String expectedUrlPart) {
        Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    /**
     * Открывает меню дополнительных опций.
     */
    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
    }

    /**
     * Скрывает текущий пин.
     */
    public void clickHidePinButton() {
        hidePinButton.click();
    }

    /**
     * Открывает окно загрузки изображения.
     */
    public void clickChoosePhotoButton() {
        choosePhotoButton.click();
    }

    /**
     * Отмечает пин как "Не интересно".
     */
    public void clickNotInterestedButton() {
        notInterestedButton.click();
    }

    /**
     * Отменяет последнее действие с пином.
     */
    public void clickUndoActionButton() {
        undoActionButton.click();
    }

    /**
     * Ставит или снимает лайк с пина.
     */
    public void clickLikeButton() {
        likeButton.click();
    }

    /**
     * Получает данные SVG-пути для кнопки лайка.
     *
     * @return значение атрибута 'd'
     */
    public String getDLikeButton() {
        return likeButton.getPathD();
    }

    /**
     * Вводит текст комментария.
     *
     * @param text текст комментария
     */
    public void fillText(String text) {
        commentTextInput.sendKeys(text);
    }

    /**
     * Отправляет комментарий.
     */
    public void clickSendCommentButton() {
        sendCommentButton.click();
    }

    /**
     * Загружает фото.
     *
     * @param file файл для загрузки
     */
    public void loadPhoto(File file) {
        loadPhotoInput.load(file);
    }

    /**
     * Скачивает текущий пин.
     */
    public void clickDownloadPinButton() {
        downloadPinButton.click();
    }

    /**
     * Сохраняет текущий пин.
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Проверяет, сохранен ли пин.
     *
     * @return true если пин сохранен, иначе false
     */
    public boolean isPostSaved() {
        return alreadySavedButton.isDisplayed();
    }

    /**
     * Возвращает кол-во комментариев.
     *
     * @return количество комментариев.
     */
    public String getCommentCount() {
        return commentCount.getText();
    }
}
