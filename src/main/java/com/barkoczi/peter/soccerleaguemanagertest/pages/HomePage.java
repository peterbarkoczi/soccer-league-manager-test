package com.barkoczi.peter.soccerleaguemanagertest.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class HomePage extends BasePage {

    @Autowired
    private AddLocationModal addLocationModal;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "appTitle")
    private WebElement appTitle;

    @FindBy(id = "logInButton")
    private WebElement logInButton;

    @FindBy(id = "signInButton")
    private WebElement signInButton;

    @FindBy(id = "addLocationButton")
    private WebElement addLocationButton;

    @FindBy(id = "locationName")
    private WebElement locationTitle;

    @FindBy(id = "locationList")
    private WebElement locationList;

    @FindBy(className = "locationLink")
    private List<WebElement> locationLinks;

    public void navigateToHomePage() {
        navigateTo("");
    }

    public void clickOnAddLocationButton() {
        clickOn(addLocationButton);
    }

    public List<String> getNewLocationNames() {
        List<WebElement> names = driver.findElements(By.className("locationLink"));
        List<String> locationNames = new ArrayList<>();
        for (WebElement name : names) {
            locationNames.add(name.getText());
        }
        return locationNames;
    }

    public void clickOnLocation(String locationName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("locationLink")));
        List<WebElement> locations = driver.findElements(By.className("locationLink"));
        for (WebElement location : locations) {
            if (location.getText().equals(locationName)) {
                location.click();
            }
        }
    }

}
