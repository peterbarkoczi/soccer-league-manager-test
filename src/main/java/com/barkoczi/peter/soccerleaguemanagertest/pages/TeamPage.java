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
@AllArgsConstructor
@Service
public class TeamPage extends BasePage {

    public TeamPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "teamsTitle")
    private WebElement teamPageTitle;

    @FindBy(id = "addTeamButton")
    private WebElement addTeamButton;

    @FindBy(id = "teamsList")
    private WebElement teamsList;

    @FindBy(xpath = "//*[@id=\"teamsList\"]/div/a")
    private List<WebElement> teams;


    public boolean isTitleAppeared() {
        return isDisplayed(teamPageTitle);
    }

    public boolean isAddTeamButtonAppeared() {
        return isDisplayed(addTeamButton);
    }

    public void clickOnAddTeamButton() {
        clickOn(addTeamButton);
    }

    public boolean isTeamsListAppeared() {
        return isDisplayed(teamsList);
    }

    public List<String> getTeams() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"teamsList\"]/div")));
        List<WebElement> teams = driver.findElements(By.xpath("//*[@id=\"teamsList\"]/div/a"));
        List<String> teamNames = new ArrayList<>();
        for (WebElement team : teams) {
            teamNames.add(team.getText());
        }
        return teamNames;
    }

}
