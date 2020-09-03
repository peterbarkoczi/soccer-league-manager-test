package com.barkoczi.peter.soccerleaguemanagertest.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Service;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class AddLeagueModal extends BasePage {

    public AddLeagueModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewLeague")
    private WebElement addLeagueModal;

    @FindBy(id = "addLeagueName")
    private WebElement addNameInputField;

    @FindBy(id = "addLeagueSubmit")
    private WebElement submitButton;

    public boolean isModalAppeared() {
        return isDisplayed(addLeagueModal);
    }

    public void fillAddNameInputField(String leagueName) {
        fillInputField(addNameInputField, leagueName);
    }

    public void clickOnSubmitButton() {
        clickOn(submitButton);
    }

}
