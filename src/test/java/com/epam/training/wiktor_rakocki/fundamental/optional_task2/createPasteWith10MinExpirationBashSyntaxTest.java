package com.epam.training.wiktor_rakocki.fundamental.optional_task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createPasteWith10MinExpirationBashSyntaxTest {
    private WebDriver driver;
    private PastebinHomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        homePage = new PastebinHomePage(driver);
        driver.manage().window().maximize();
    }

    // Pastebin has a CAPTCHA system so unfortunately I can't assert anything
    @Test
    public void testCreatePasteWith10MinExpirationBashSyntax() {
        homePage.handleCookiePopupIfPresent();
        homePage.handleBannerIfPresent();
        homePage.setPasteSyntaxToBash();
        homePage.enterTitle("how to gain dominance among developers");
        homePage.enterCode(
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n"
        );
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
