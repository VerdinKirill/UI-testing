package com.example.tests.openClosePostTest;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;

import io.github.cdimascio.dotenv.Dotenv;

public class OpenClosePostTest extends BaseTest {

	@Test
	public void openClosePost() {
		Dotenv dotenv = Dotenv.load();
		String login = dotenv.get("USER_LOGIN");
		String password = dotenv.get("USER_PASSWORD");
		MainPage mainPage = auth(login, password);
		String hrefPreview = mainPage.getHrefOfFirstImage();
		PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
		assertTrue(pinPage.isLoaded());
		String hrefPinPage = webdriver().driver().getCurrentFrameUrl();
		assertTrue(hrefPinPage.contains(hrefPreview));
		mainPage = pinPage.clickBackButton(MainPage.class);
		assertTrue(mainPage.isDisplayed());
	}

}
