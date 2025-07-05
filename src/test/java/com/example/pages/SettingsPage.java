package com.example.pages;

import com.example.Elements.Button.Button;
import com.example.Elements.TextArea.TextArea;
import com.example.elements.Input.Input;

public class SettingsPage extends BasePage {
    private static final String PAGE_VALIDATION_XPATH = "//*[@id=\"fullpage\"]";

    private final Input firstNameInput = Input.byName("first_name");
    private final Input lastNameInput = Input.byName("last_name");
    private final TextArea aboutTextArea = TextArea.byId("about");
    private final Button saveButton = Button.byXPath("//div[@data-test-id=\"done-button\"]/button");
    private final Button cancelButton = Button.byXPath("//div[@data-test-id=\"cancel-button\"]/button");

    public SettingsPage() {
        super(LoginPage.class, PAGE_VALIDATION_XPATH);
    }

    public void fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void fillAbout(String about) {
        aboutTextArea.fill(about);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }

    public String getAbout() {
        return aboutTextArea.getText();
    }
}
