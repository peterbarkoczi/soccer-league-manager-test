package com.barkoczi.peter.soccerleaguemanagertest.pages;

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
public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "headerNavMenu")
    private WebElement headerNavMenu;

    @FindBy(id = "navButtonLeagues")
    private WebElement leaguesButton;

    @FindBy(id = "navButtonCups")
    private WebElement cupsButton;

    @FindBy(id = "navButtonTeams")
    private WebElement teamsButton;


    public boolean headerNavMenuIsAppeared() {
        return wait.until(ExpectedConditions.visibilityOf(headerNavMenu)).isDisplayed();
    }

    public void clickOnLeaguesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(leaguesButton));
        clickOn(leaguesButton);
    }

    public void clickOnCupsButton() {
        clickOn(cupsButton);
    }

    public void clickOnTeamsButton() {
        clickOn(teamsButton);
    }

}
