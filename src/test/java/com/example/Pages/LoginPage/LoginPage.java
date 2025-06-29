package com.example.Pages.LoginPage;

import com.example.Elements.Button.Button;
import com.example.Elements.Input.Input;
import com.example.Pages.BasePage;
import com.example.Elements.Text.Text;;

public class LoginPage extends BasePage {
    // Define input fields and button
    private final Input usernameInput = Input.byId("email");
    private final Input passwordInput = Input.byId("password");
    private final Button loginButton = Button.byType("submit");
    private final Text incorrectPasswordText = Text.byId("password-error");

    public LoginPage() {
        super(LoginPage.class, "//*[@id=\"__PWS_ROOT__\"]/div[1]/div[3]/div/div/div/div/div"); // Assume //
                                                                                               // name="login-container"
    }

    public <T extends BasePage> T login(String username, String password, Class<T> nextPageClass) {
        // loginModalButton.click();
        usernameInput.fill(username);
        passwordInput.fill(password);
        System.out.printf("%s\n", loginButton.isDisplayed() ? "true" : "false");

        loginButton.click();
        try {

            Thread.sleep(10000);
        } catch (IllegalArgumentException | InterruptedException error) {

        }
        return page(nextPageClass); // Navigate to the next page (e.g., DashboardPage)
    }

    public boolean checkIncorrectMessage() {
        return incorrectPasswordText.isDisplayed();
    }
}
