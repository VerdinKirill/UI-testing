package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.elements.Button.Button;
import com.example.elements.Image.Image;
import com.example.elements.Input.Input;
import com.example.elements.likebutton.LikeButton;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

public class PinPage extends BasePage {

    // Константы для локаторов
    private static final String CLOSEUP_CONTAINER_XPATH = "//*[@data-test-id=\"closeup-container\"]";
    private static final String BACK_BUTTON_ARIA_LABEL = "Назад";
    private static final String MORE_OPTIONS_ARIA_LABEL = "Другие действия";
    private static final String IMAGE_ELEMENT_TIMING = "closeup-image-main-MainPinImage";
    private static final String HIDE_PIN_XPATH = "//*[@data-test-id=\"pin-action-dropdown-hide\"]";
    private static final String NOT_INTERESTED_XPATH = "//*[@data-test-id=\"hide-reason\"][1]";
    private static final String UNDO_ACTION_XPATH = "//*[@data-test-id=\"undo-action-btn\"]";
    private static final String REACT_BUTTON_DATA_TEST_ID = "react-button";
    private static final String DOWNLOAD_PIN_XPATH = "//*[@data-test-id=\"pin-action-dropdown-download\"]";
    private static final String SAVE_BUTTON_ARIA_LABEL = "Сохранить";
    private static final String ALREADY_SAVED_ARIA_LABEL = "Пин сохранен";
    private static final String CHOOSE_PHOTO_ARIA_LABEL = "Выберите фото.";
    private static final String PHOTO_UPLOAD_DATA_TEST_ID = "photo-upload-input";
    private static final String LOADED_IMAGE_ALT = "Фотография";
    private static final String COMMENT_INPUT_XPATH = "//*[@class='DraftEditor-editorContainer']/div";
    private static final String SEND_COMMENT_ARIA_LABEL = "Опубликовать";

    private final Button backButton = Button.byAriaLabel(BACK_BUTTON_ARIA_LABEL);
    private final Button moreOptionsButton = Button.byAriaLabel(MORE_OPTIONS_ARIA_LABEL);
    private final Image image = Image.byElementTiming(IMAGE_ELEMENT_TIMING);
    private final Button hidePinButton = Button.byXPath(HIDE_PIN_XPATH);
    private final Button notInterestedButton = Button.byXPath(NOT_INTERESTED_XPATH);
    private final Button undoActionButton = Button.byXPath(UNDO_ACTION_XPATH);
    private final LikeButton likeButton = LikeButton.byDataTestId(REACT_BUTTON_DATA_TEST_ID);
    private final Button downloadPinButton = Button.byXPath(DOWNLOAD_PIN_XPATH);
    private final Button saveButton = Button.byAriaLabel(SAVE_BUTTON_ARIA_LABEL);
    private final Button alreadySavedButton = Button.byAriaLabel(ALREADY_SAVED_ARIA_LABEL);
    private final Button choosePhotoButton = Button.byAriaLabel(CHOOSE_PHOTO_ARIA_LABEL);
    private final Input loadPhotoInput = Input.byDataTestId(PHOTO_UPLOAD_DATA_TEST_ID);
    private final Image loadedImage = Image.byAlt(LOADED_IMAGE_ALT);
    private final SelenideElement commentTextInput = $x(COMMENT_INPUT_XPATH);
    private final Button sendCommentButton = Button.byAriaLabel(SEND_COMMENT_ARIA_LABEL);

    /**
     * Конструктор страницы пина.
     * Инициализирует страницу с валидационным XPath.
     */
    public PinPage() {
        super(PinPage.class, CLOSEUP_CONTAINER_XPATH);
    }

    /**
     * Получает ссылку на изображение пина.
     *
     * @return URL изображения
     */
    public String getImageHref() {
        return image.getHref();
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
     * Открывает диалог выбора фото.
     */
    public void clickChoosePhotoButton() {
        choosePhotoButton.click();
        System.out.println(loadedImage.isDisplayed());
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
}
