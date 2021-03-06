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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Service
public class LeaguePage extends BasePage {

    public LeaguePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "locationHeaderTitle")
    private WebElement locationHeaderTitle;

    @FindBy(id = "leagueTitle")
    private WebElement leagueTitle;

    @FindBy(id = "addLeagueButton")
    private WebElement addLeagueButton;

    @FindBy(id = "leaguesList")
    private WebElement leaguesList;

    public boolean locationHeaderTitleIsAppeared() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("locationHeaderTitle"))));
        return isDisplayed(driver.findElement(By.id("locationHeaderTitle")));
    }

    public boolean isLeagueTitleAppeared() {
        return isDisplayed(leagueTitle);
    }

    public boolean isAddLeagueButtonAppeared() {
        return isDisplayed(addLeagueButton);
    }

    public boolean isLeaguesListAppeared() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("leaguesList"))));
        return isDisplayed(driver.findElement(By.id("leaguesList")));
    }

    public void clickOnAddLeagueButton() {
        clickOn(addLeagueButton);
    }

    public List<String> getNewLeaguesNames() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"leaguesList\"]/a")));
        List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"leaguesList\"]/a/div"));
        List<String> leagueNames = new ArrayList<>();
        for (WebElement name : names) {
            leagueNames.add(name.getText());
        }
        return leagueNames;
    }

}
