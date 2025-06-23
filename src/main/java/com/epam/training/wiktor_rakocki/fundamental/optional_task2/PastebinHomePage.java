package com.epam.training.wiktor_rakocki.fundamental.optional_task2;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class PastebinHomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //Locators
    private final By codeTextArea = By.id("postform-text");
    private final By titleTextArea = By.id("postform-name");
    private final By expirationDropdown = By.id("select2-postform-expiration-container");
    private final By expiration10Min = By.xpath("//li[contains(text(), '10 Minutes')]");
    private final By submitButton = By.xpath("//button[text()='Create New Paste']");
    private final By syntaxHighlightDropDown = By.id("select2-postform-format-container");
    private final By bashSyntaxOption = By.xpath("//li[text()='Bash']");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterCode(String code) {
        driver.findElement(codeTextArea).sendKeys(code);
    }

    public void enterTitle(String title) {
        driver.findElement(titleTextArea).sendKeys(title);
    }

    public void setPasteExpiration10Min() {
        driver.findElement(expirationDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(expiration10Min)).click();
    }

    public void setPasteSyntaxToBash() {
        driver.findElement(syntaxHighlightDropDown).click();
        wait.until(ExpectedConditions.elementToBeClickable(bashSyntaxOption)).click();
    }

    public void submitPaste() {
        driver.findElement(submitButton).click();
    }

    public void handleCookiePopupIfPresent() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".css-47sehv")
            ));
            acceptBtn.click();
        } catch (TimeoutException | NoSuchElementException ignored) {
        }
    }

    public void handleBannerIfPresent() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#hideSlideBanner")
            ));
            acceptBtn.click();
        } catch (TimeoutException | NoSuchElementException ignored) {
        }
    }
}
