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
public class AddLocationModal extends BasePage {

    public AddLocationModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewLocation")
    private WebElement addLocationModal;

    @FindBy(id = "addName")
    private WebElement addNameField;

    @FindBy(id = "addLocationSubmit")
    private WebElement submitButton;

    public void fillAddNameField(String input) {
        fillInputField(addNameField, input);
    }

    public void clickOnSubmitButton() {
        clickOn(submitButton);
    }

    public boolean modalIsDisappear() {
        return wait.until(ExpectedConditions.invisibilityOf(addLocationModal));
    }
}
