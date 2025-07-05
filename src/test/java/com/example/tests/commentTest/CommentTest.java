package com.example.tests.commentTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.io.File;

public class CommentTest extends BaseTest {
    private final String pathToImage = "./testAssets/commentTest.png";
    private String login;
    private String password;

    @Test
    void checkCommentPost() {
        initTestData();
        MainPage mainPage = auth(login, password);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
//        pinPage.aa();
        pinPage.clickChoosePhotoButton();
        File file = new File(pathToImage);
        System.out.println(file.exists());
        pinPage.loadPhoto(file);

    }

    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");

    }


}
