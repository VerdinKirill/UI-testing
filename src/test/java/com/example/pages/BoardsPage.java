package com.example.pages;

import com.example.elements.Button.Button;
import com.example.elements.ImagePreview.ImagePreview;
import com.example.elements.MansoryContainer.MansoryContainer;

public class BoardsPage extends BasePage {
    private final Button moreOptionsButton = Button.byAriaLabel("Упорядочить");
    private final Button alphabeticOrderButton = Button.byId("actionBarMenuButton-item-0");
    private final Button lastAddedOrderButton = Button.byId("actionBarMenuButton-item-2");
    private final MansoryContainer mansoryContainer = MansoryContainer.byClass("masonryContainer");

    public BoardsPage() {
        super(BoardsPage.class, "//*[@class=\"mainContainer\"]");
    }

    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
    }

    public void clickAlphabeticOrderButton() {
        alphabeticOrderButton.click();
    }

    public void clickLastAddedOrderButton() {
        lastAddedOrderButton.click();
    }

    public String getPreviewName(){
        return mansoryContainer.getPreviewName();
    }


}
