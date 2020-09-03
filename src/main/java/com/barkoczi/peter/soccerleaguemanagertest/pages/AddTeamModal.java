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
@AllArgsConstructor
@Service
public class AddTeamModal extends BasePage {

    public AddTeamModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewTeam")
    private WebElement addTeamModal;

    @FindBy(id = "addName")
    private WebElement addNameInputField;

    @FindBy(id = "addTeamSubmit")
    private WebElement submitButton;

    public boolean isModalAppeared() {
        return isDisplayed(addTeamModal);
    }

    public void fillAddNameInputField(String teamName) {
        wait.until(ExpectedConditions.visibilityOf(addNameInputField));
        fillInputField(addNameInputField, teamName);
    }

    public void clickOnSubmitButton() {
        clickOn(submitButton);
    }
}
