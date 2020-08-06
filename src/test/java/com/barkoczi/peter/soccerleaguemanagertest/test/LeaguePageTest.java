package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddLocationModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LeaguePageTest extends BaseTest {

    private AddLocationModal addLocationModal;

    @BeforeEach
    public void setHomePage() {
        homePage = new HomePage(this.driver);
        leaguePage = new LeaguePage(this.driver);
        homePage.navigateToHomePage();

    }

    @Test
    @DisplayName("Header title is appeared")
    public void headerTitleIsAppearedTest() {
        String locationName = createNewLocation();
        homePage.clickOnLocation(locationName);
        assertTrue(leaguePage.locationHeaderTitleIsAppeared());
    }

    private String createNewLocation() {
        addLocationModal = new AddLocationModal(this.driver);
        homePage.clickOnAddLocationButton();
        addLocationModal.fillAddNameField("New Test Location");
        addLocationModal.clickOnSubmitButton();
        return "New Test Location";
    }

}
