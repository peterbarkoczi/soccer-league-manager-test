package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddLocationModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LeaguePage leaguePage;
    protected Header header;
    protected AddLocationModal addLocationModal;

    protected final String testLocationName = "New test location";

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        this.driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void addNewLocation(String newLocationName, WebDriver driver) {
        addLocationModal = new AddLocationModal(driver);
        homePage.clickOnAddLocationButton();
        addLocationModal.fillAddNameField(newLocationName);
        addLocationModal.clickOnSubmitButton();
    }

    protected void deleteLocation(String locationName) {
        homePage.navigateToHomePage();
        homePage.clickOnDeleteButton(locationName);
        homePage.clickOnConfirmButton();
    }

}
