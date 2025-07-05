package com.example.pages;

import com.example.Elements.Button.Button;
import com.example.Elements.likebutton.LikeButton;
import com.example.elements.Image.Image;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

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
    private final Button saveButton = Button.byAriaLabel("Сохранить");
    private final Button alreadySavedButton = Button.byAriaLabel("Пин сохранен");

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
        System.out.println(likeButton.isDisplayed());
        return likeButton.getHeartD();
    }

    public void clickDownloadPinButton() {
        downloadPinButton.click();
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isPostSaved() {
        return alreadySavedButton.isDisplayed();
    }
}
