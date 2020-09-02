package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddLocationModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LeaguePageTest extends BaseTest {

    @BeforeEach
    public void setHomePage() {
        homePage = new HomePage(this.driver);
        leaguePage = new LeaguePage(this.driver);
        header = new Header(this.driver);
        homePage.navigateToHomePage();

    }

    @Ignore
//    @Test
    @DisplayName("Header title is appeared")
    public void headerTitleIsAppearedTest() {
        String locationName = createNewLocation("New test location");
        homePage.clickOnLocation(locationName);
        assertTrue(leaguePage.locationHeaderTitleIsAppeared());
    }

    private String createNewLocation(String location) {
        AddLocationModal addLocationModal = new AddLocationModal(this.driver);
        homePage.clickOnAddLocationButton();
        addLocationModal.fillAddNameField(location);
        addLocationModal.clickOnSubmitButton();
        return location;
    }

    @Test
    @DisplayName("Nav Menu is appeared")
    public void navMenuIsAppeared() {
        String locationName = "New test location";
        createNewLocation(locationName);
        homePage.clickOnLocation(locationName);
        assertTrue(header.headerNavMenuIsAppeared());
    }

    @Test
    @DisplayName("Is League title appeared")
    public void checkLeagueTitle() {
        homePage.clickOnLocation("Kistarcsa");
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isLeagueTitleAppeared());
    }

    @Test
    @DisplayName("Is Add League button appeared")
    public void checkAddLeagueButton() {
        homePage.clickOnLocation("Kistarcsa");
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isAddLeagueButtonAppeared());
    }

    @Test
    @DisplayName("Is Leagues list appeared")
    public void checkLeaguesList() {
        homePage.clickOnLocation("Kistarcsa");
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isLeaguesListAppeared());
    }
}
