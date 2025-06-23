package com.epam.training.wiktor_rakocki.fundamental.optional_task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createPasteWith10MinExpirationTest {

    private WebDriver driver;
    private PastebinHomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        homePage = new PastebinHomePage(driver);
    }

    // Pastebin has a CAPTCHA system so unfortunately I can't assert anything

    @Test
    public void testCreateNewPaste() {
        homePage.enterTitle("helloweb");
        homePage.enterCode("Hello from WebDriver");
        homePage.setPasteExpiration10Min();
        homePage.submitPaste();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
