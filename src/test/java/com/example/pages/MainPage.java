package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.Wait;
import com.example.elements.MansoryContainer.MansoryContainer;
import com.example.elements.SearchHeader.SearchHeader;

//Класс главной страницы, где уже есть картинки, наследуется от BasePage

public class MainPage extends BasePage {
	private final MansoryContainer mansoryContainer = MansoryContainer.byClass("masonryContainer");
	private final SearchHeader searchHeader = SearchHeader.byId("HeaderContent");

	public MainPage() {
		super(MainPage.class, "//*[@role=main]");
	}

	public boolean isDisplayed() {
		return mansoryContainer.isDisplayed();
		// return welcomeMessage.exists() && welcomeMessage.isDisplayed();
	}

	public String getHrefOfFirstImage() {
		return mansoryContainer.getHrefOfFirstImage();
	}

	public <T extends BasePage> T clickOnFirstImage(Class<T> className) {
		mansoryContainer.clickOnImage();
		return page(className);
	}

	public void openSearchBar() {
		searchHeader.open();
	}

	public void fillSearchBar(String searchText) {
		searchHeader.fillSearchText(searchText);
	}

	public void submitSearch() {
		searchHeader.pressEnter();
	}

	public void waitForSearchPageLoad(String expectedUrlPart) {
		Wait().withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlPart));
	}

	public void clickAccountButton(){
		searchHeader.clickAccountButton();
	}
}

