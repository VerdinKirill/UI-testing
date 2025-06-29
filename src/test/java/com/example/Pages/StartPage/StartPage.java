package com.example.Pages.StartPage;

import com.example.Elements.Button.Button;
import com.example.Pages.BasePage;

//Класс StartPage, насследник класса BasePage, нужен для того, чтобы нажать на кнопку авторизации и открыть модалку
public class StartPage extends BasePage {

	//тут xPath особо не отличается от прямого, но отличается, у кнопки этой вообще нет properties, classname,
	//который точно такой же у другой кнопки в этом же хеддере
	private final Button loginModalButton = Button.byXPath("//*[@id=\"__PWS_ROOT__\"]/div[1]/div[1]/div[2]/div/div[2]/div[2]/button");

	public StartPage() {
		super(StartPage.class, "//*[@id=\"fullpage-wrapper\"]/div[1]/div/div/div[1]/div/div[3]/div/div[2]/div"); // Assume// container																													// 																												// name="login-container"
	}

	//Проверяет на то, видима ли кнопка открытия модалки Авторизации
	public boolean checkLoginModalButtonIsVisisble () {
		return loginModalButton.isDisplayed();
	}

	//Открывает модалку Логина (на практике чаще всего возвращает LoginPage)
	public <T extends BasePage> T openLoginModal(Class<T> nextPageClass) {
		loginModalButton.click();
		return page(nextPageClass);
	}

}
