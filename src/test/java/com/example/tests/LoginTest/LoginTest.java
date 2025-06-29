package com.example.tests.LoginTest;

import io.github.cdimascio.dotenv.Dotenv;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.tests.*;
import com.example.Pages.LoginPage.LoginPage;
import com.example.Pages.MainPage.MainPage;
import com.example.Pages.StartPage.StartPage;

//Класс LoginTest, насследуется от класса BaseTest
//Открывает страницу пинтереста, затем подгружает из .env логин и пароли (вы должны самостоятельно ввести логин и пароль в .env в переменные с такими же названиями)
//затем открывает модал с логином и паролем (но я не уверен опять же, это считать страницей или составным элементом, если второе, то там относительно быстро можно поменять)
public class LoginTest extends BaseTest {
	@Test
	public void successfulLogin() {
		open("/");
		Dotenv dotenv = Dotenv.load();
		String login = dotenv.get("USER_LOGIN");
		String password = dotenv.get("USER_PASSWORD");
		String fakePassword = dotenv.get("FAKE_PASSWORD");

		//тут скорее всего нужно сделать что-то по типу openStartPage() а не через new StartPage() но я не совсем уверен куда девать open(), в тест или в page
		StartPage startPage = new StartPage(); 
		LoginPage loginPage = startPage.openLoginModal(LoginPage.class);
		//попытка ввести неправильный пароль, должно появиться сообщение
		loginPage.login(login, fakePassword, MainPage.class);
		assertTrue(loginPage.checkIncorrectMessage());
		//попытка ввести правильный пароль
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