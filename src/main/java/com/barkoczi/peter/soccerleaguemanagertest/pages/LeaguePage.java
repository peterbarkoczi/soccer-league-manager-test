package com.barkoczi.peter.soccerleaguemanagertest.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Service;

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
        return isDisplayed(locationHeaderTitle);
    }

    public boolean isLeagueTitleAppeared() {
        return isDisplayed(leagueTitle);
    }

    public boolean isAddLeagueButtonAppeared() {
        return isDisplayed(addLeagueButton);
    }

    public boolean isLeaguesListAppeared() {
        return isDisplayed(leaguesList);
    }
}
