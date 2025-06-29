package com.example.Pages.LoginPage;

import com.example.Elements.Button.Button;
import com.example.Elements.Input.Input;
import com.example.Pages.BasePage;
import com.example.Elements.Text.Text;


//LoginPage, насследуется от BasePage, используется для взаимодействия с инпутами и кнопками в модалке для Авторизации
public class LoginPage extends BasePage {
    // Define input fields and button
    private final Input usernameInput = Input.byId("email");
    private final Input passwordInput = Input.byId("password");
    private final Button loginButton = Button.byType("submit");
    private final Text incorrectPasswordText = Text.byId("password-error");

    public LoginPage() {
        super(LoginPage.class, "//*[@id=\"__PWS_ROOT__\"]/div[1]/div[3]/div/div/div/div/div");
    }

    //Вводит логин и пароль, нажимает на кнопку войти и возвращает новую страницу (чаще всего mainPage)
    public <T extends BasePage> T login(String username, String password, Class<T> nextPageClass) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
        return page(nextPageClass);
    }


    //Проверяет, появилось ли сообщение об ошибке
    public boolean checkIncorrectMessage() {
        return incorrectPasswordText.isDisplayed();
    }
}
