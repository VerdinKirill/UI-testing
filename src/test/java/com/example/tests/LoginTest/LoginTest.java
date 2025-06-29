package com.example.tests.LoginTest;

import io.github.cdimascio.dotenv.Dotenv;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.tests.*;
// import com.example.Pages.LoginPage.*;;
import com.example.Pages.LoginPage.LoginPage;
import com.example.Pages.MainPage.MainPage;
import com.example.Pages.StartPage.StartPage;

public class LoginTest extends BaseTest {
	@Test
	public void successfulLogin() {
		open("/");
		Dotenv dotenv = Dotenv.load();
		String login = dotenv.get("USER_LOGIN");
		String password = dotenv.get("USER_PASSWORD");
		String fakePassword = dotenv.get("FAKE_PASSWORD");
		StartPage startPage = new StartPage();
		System.out.printf("%s\n", startPage.checkLoginModalButtonIsVisisble() ? "true" : "false");
		LoginPage loginPage = startPage.openLoginModal(LoginPage.class);
		loginPage.login(login, fakePassword, MainPage.class);
		assertTrue(loginPage.checkIncorrectMessage());
		MainPage mainPage = loginPage.login(login, password, MainPage.class);
		assertTrue(mainPage.isDisplayed());
	}

	// @Test
	// public void failedLogin() {
	// LoginPage loginPage = new LoginPage();
	// loginPage.login("wrong", "credentials", LoginPage.class);
	// assertThat(loginPage.getErrorMessage()).contains("Invalid credentials");
	// }
}