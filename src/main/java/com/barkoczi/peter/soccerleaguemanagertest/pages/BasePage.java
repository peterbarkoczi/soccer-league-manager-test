package com.barkoczi.peter.soccerleaguemanagertest.pages;

import org.openqa.selenium.WebDriver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasePage {

    protected WebDriver driver;
    String baseUrl;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        this.baseUrl = "http://localhost:3000/";
        this.wait = new WebDriverWait(driver, 20);
    }

    protected void navigateTo(String extendUrl) {
        driver.get(baseUrl + extendUrl);
    }

    protected void clickOn(WebElement webElement) {
        webElement.click();
    }

    protected void fillInputField(WebElement inputField, String input) {
        inputField.sendKeys(input);
    }

    protected boolean isDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
