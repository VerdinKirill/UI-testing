package com.example.elements.likebutton;

import com.example.elements.Button.Button;
import com.example.elements.path.Path;

import javax.xml.xpath.XPath;

public class LikeButton extends Button {
    private final String PATH_XPATH = "//*[name()='path']";
    private final Path path;
    private static final String DATA_TEST_ID_BUTTON = "//button[@data-test-id='%s']";
//    private static final String REACTION_BUTTON_XPATH = "//button[@data-test-id='react-button']";



    private LikeButton(String xPath, String param) {
        super(xPath, param);
        this.path = Path.byXpath(String.format(xPath, param) + PATH_XPATH);
    }

    public String getHeartD() {
        System.out.println(path.isDisplayed());
        return path.getD();
    }

    public static LikeButton byDataTestId(String param) {
        return new LikeButton(DATA_TEST_ID_BUTTON, param);
    }

}