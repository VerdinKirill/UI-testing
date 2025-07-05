package com.example.tests.OpenClosePostTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenClosePostTest extends BaseTest {

    //    @Test
    public void openClosePost() {
        Dotenv dotenv = Dotenv.load();
        String login = dotenv.get("USER_LOGIN");
        String password = dotenv.get("USER_PASSWORD");
        MainPage mainPage = auth(login, password);
        String hrefPreview = mainPage.getHrefOfFirstImage();
        System.out.println(hrefPreview);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.waitForPinPageLoad(hrefPreview);
        String hrefPinPage = webdriver().driver().getCurrentFrameUrl();
        System.out.println(hrefPinPage);
        assertTrue(hrefPinPage.contains(hrefPreview));
        mainPage = pinPage.clickBackButton(MainPage.class);
        assertTrue(mainPage.isDisplayed());
    }
}
