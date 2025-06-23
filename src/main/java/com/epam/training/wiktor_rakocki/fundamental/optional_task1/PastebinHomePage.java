package com.epam.training.wiktor_rakocki.fundamental.optional_task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinHomePage {

    private WebDriver driver;

    //Locators
    private By codeTextArea = By.id("postform-text");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.pastebin.com/");
    }

    public void enterCode(String code) {
        driver.findElement(codeTextArea).sendKeys(code);
    }
}
