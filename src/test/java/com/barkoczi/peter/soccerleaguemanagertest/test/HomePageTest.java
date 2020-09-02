package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddLocationModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HomePageTest extends BaseTest {

    private AddLocationModal addLocationModal;

    @BeforeEach
    public void setHomePage() {
        homePage = new HomePage(this.driver);
        homePage.navigateToHomePage();

    }

    @Test
    @DisplayName("Go to home page")
    public void navigateToHomePage() {
        assertEquals(homePage.getAppTitle().getText(), "Soccer League Manager");
    }

    @Test
    public void logInButtonIsDisplayed() {
        assertTrue(homePage.getLogInButton().isDisplayed());
    }

    @Test
    public void signInButtonIsDisplayed() {
        assertTrue(homePage.getSignInButton().isDisplayed());
    }

    @Test
    public void addLocationButtonIsDisplayed() {
        assertTrue(homePage.getAddLocationButton().isDisplayed());
    }

    @Test
    public void locationTitleIsDisplayed() {
        assertTrue(homePage.getLocationTitle().isDisplayed());
    }

    @Test
    public void locationListIsDisplayed() {
        assertTrue(homePage.getLocationList().isDisplayed());
    }

    @Test
    public void addLocationModalIsDisplayed() {
        addLocationModal = new AddLocationModal(driver);
        homePage.clickOnAddLocationButton();
        assertTrue(addLocationModal.getAddLocationModal().isDisplayed());
    }

    @Test
    public void addNewLocationTest() {
        addLocationModal = new AddLocationModal(driver);
        String testInput = "Test Location";
        addNewLocation(testInput);
        List<String> newLocations = homePage.getNewLocationNames();
        System.out.println("NewLocations: " + newLocations);
        assertTrue(newLocations.contains(testInput));
        deleteLocation(testInput);
    }

    @Test
    public void deleteLocationTest() {
        addLocationModal = new AddLocationModal(driver);
        String testInput = "Test Location";
        addNewLocation(testInput);
        List<String> locationsWithTestLocation = homePage.getNewLocationNames();
        deleteLocation(testInput);
        List<String> locationsWithoutTestLocation = homePage.getNewLocationNames();
        assertNotEquals(
                locationsWithTestLocation.contains(testInput),
                locationsWithoutTestLocation.contains(testInput));
    }

    private void addNewLocation(String newLocationName) {
        homePage.clickOnAddLocationButton();
        addLocationModal.fillAddNameField(newLocationName);
        addLocationModal.clickOnSubmitButton();
    }

    private void deleteLocation(String locationName) {
        homePage.clickOnDeleteButton(locationName);
        homePage.clickOnConfirmButton();
    }

}
