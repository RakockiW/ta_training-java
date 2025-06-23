package com.epam.training.wiktor_rakocki.fundamental.optional_task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createPasteTest {
    private WebDriver driver;
    private PastebinHomePage pastebin;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        pastebin = new PastebinHomePage(driver);
    }

    @Test
    @Order(1)
    public void testCreateNewPaste() {
        pastebin.open();
        pastebin.enterCode("Hello World");

    }
}
