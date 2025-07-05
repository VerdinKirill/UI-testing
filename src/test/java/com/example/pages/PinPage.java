package com.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.elements.Button.Button;
import com.example.elements.Input.Input;
import com.example.elements.likebutton.LikeButton;
//import com.example.Elements.span.Span;
import com.example.elements.Image.Image;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

public class PinPage extends BasePage {

    private final Button backButton = Button.byAriaLabel("Назад");
    private final Button moreOptionsButton = Button.byAriaLabel("Другие действия");
    private final Image image = Image.byElementTiming("closeup-image-main-MainPinImage");
    private final Button hidePinButton = Button.byXPath("//*[@data-test-id=\"pin-action-dropdown-hide\"]");
    private final Button notInterestedButton = Button.byXPath("//*[@data-test-id=\"hide-reason\"][1]");
    private final Button undoActionButton = Button.byXPath("//*[@data-test-id=\"undo-action-btn\"]");
    private final LikeButton likeButton = LikeButton.byDataTestId("react-button");
    private final Button downloadPinButton = Button.byXPath("//*[@data-test-id=\"pin-action-dropdown-download\"]");
//    private final Span inputSpan = Span.
    private final Button choosePhotoButton = Button.byAriaLabel("Выберите фото.");
    private final Input loadPhotoInput = Input.byId("photo-upload-input");
    private final Image loadedImage = Image.byAlt("Фотография");

    public PinPage() {
        super(PinPage.class, "//*[@data-test-id=\"closeup-container\"]");
    }

    public String getImageHref() {
        return image.getHrefOfImage();
    }

    public <T extends BasePage> T clickBackButton(Class<T> className) {
        backButton.click();
        return page(className);
    }

    public void waitForPinPageLoad(String expectedUrlPart) {
        Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
    }

    public void clickHidePinButton() {
        hidePinButton.click();
    }

    public void clickNotInterestedButton() {
        notInterestedButton.click();
    }

    public void clickUndoActionButton() {
        undoActionButton.click();
    }


    public void clickLikeButton() {
        likeButton.click();
    }

    public String getDLikeButton() {
        return likeButton.getHeartD();
    }

    public void aa() {
        SelenideElement element = $x("//*[@id=\"dweb-comment-editor-container\"]");
        element.click();
        element.sendKeys("AAAAAAAAABBB");
    }

    public void clickChoosePhotoButton() {
        choosePhotoButton.click();
        System.out.println(loadedImage.isDisplayed());
    }

    public void loadPhoto(File file) {
        loadPhotoInput.load(file);
    }

    public void clickDownloadPinButton() {
        downloadPinButton.click();
    }
}
