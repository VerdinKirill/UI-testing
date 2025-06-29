package com.example.Pages.StartPage;

import com.example.Elements.Button.Button;
import com.example.Pages.BasePage;
import com.example.Pages.LoginPage.LoginPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;

public class StartPage extends BasePage {
	private final Button loginModalButton = Button.byXPath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div[1]/div[2]/div/div[2]/div[2]/button");

	public StartPage() {
		super(StartPage.class, "//*[@id=\"fullpage-wrapper\"]/div[1]/div/div/div[1]/div/div[3]/div/div[2]/div"); // Assume// container																													// 																												// name="login-container"
	}

	public boolean checkLoginModalButtonIsVisisble () {
		return loginModalButton.isDisplayed();
	}

	// Fill credentials and submit
	public <T extends BasePage> T openLoginModal(Class<T> nextPageClass) {
		loginModalButton.click();
		return page(nextPageClass);
	}

	// public <T extends BasePage> T login(String username, String password, Class<T> nextPageClass) {
	// 	loginModalButton.click();
	// 	return page(nextPageClass); // Navigate to the next page (e.g., DashboardPage)
	// }
}
