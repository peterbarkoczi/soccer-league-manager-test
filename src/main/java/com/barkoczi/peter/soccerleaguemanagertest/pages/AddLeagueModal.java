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

    @FindBy(id = "addLeagueDate")
    private WebElement addDateInputField;

    @FindBy(id = "addLeagueStartTime")
    private WebElement addStartTimeInputField;

    @FindBy(id = "addLeagueMatchTime")
    private WebElement addMatchTimeInputField;

    @FindBy(xpath = "//*[@id=\"addNewLeague\"]/div/div[2]/form/div[5]/div[1]/input")
    private WebElement firstCheckBox;

    @FindBy(id = "addLeagueSubmit")
    private WebElement submitButton;

    public boolean isModalAppeared() {
        return isDisplayed(addLeagueModal);
    }

    public void fillInputFields(String leagueName) {
        fillNameField(leagueName);
        fillDateField();
        fillStartTimeField();
        fillMatchTimeField();
        clickOnFirstCheckBox();
    }

    private void fillNameField(String leagueName) {
        fillInputField(addNameInputField, leagueName);
    }

    private void fillDateField() {
        fillInputField(addDateInputField, "2020.10.03");
    }

    private void fillStartTimeField() {
        fillInputField(addStartTimeInputField, "18:00");
    }

    private void fillMatchTimeField() {
        fillInputField(addMatchTimeInputField, "20");
    }

    private void clickOnFirstCheckBox() {
        clickOn(firstCheckBox);
    }

    public void clickOnSubmitButton() {
        clickOn(submitButton);
    }

}
