package com.example.elements.MansoryContainer;

import com.example.elements.BaseElement;
import com.example.elements.ImagePreview.ImagePreview;

import io.qameta.allure.Step;

//Mansory container - наследуется от BaseElement
//является классом контейнером для всех картинок на MainPage
//100% в дальнейшем будет составным элементом, а пока что нужен чисто для того, чтобы проверять прогрузилась ли Главная страница после авторизации
public class MansoryContainer extends BaseElement {
	private static final String CLASS_XPATH = "//div[@class='%s']";

	private static final ImagePreview firstImagePreview = ImagePreview.byXpath("//*[@role=\"listitem\"][1]");

	private MansoryContainer(String xpath, String param) {
		super(xpath, param);
	}

	public String getHrefOfFirstImage() {
		return firstImagePreview.getHrefOfArticle();
	}

	@Step("Click on Image")
	public void clickOnImage() {
		System.out.println("firstImagePreview");

		System.out.println(firstImagePreview.isDisplayed());
		firstImagePreview.click();
	}

	public static MansoryContainer byClass(String text) {
		return new MansoryContainer(CLASS_XPATH, text);
	}

}
