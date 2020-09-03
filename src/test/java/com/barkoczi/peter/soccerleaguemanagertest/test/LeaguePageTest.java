package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddLeagueModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
import org.junit.jupiter.api.AfterEach;
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

    @AfterEach
    public void deleteCreatedLocations() {
        deleteLocation(testLocationName);
    }

    private void goToLeaguePage(String locationName) {
        addNewLocation(locationName, driver);
        homePage.clickOnLocation(locationName);
    }

    private void addNewLeague(String leagueName) {
        leaguePage.clickOnAddLeagueButton();
        AddLeagueModal addLeagueModal = new AddLeagueModal(driver);
        addLeagueModal.fillAddNameInputField(leagueName);
        addLeagueModal.clickOnSubmitButton();
    }

    @Test
    @DisplayName("Header title is appeared")
    public void headerTitleIsAppearedTest() {
        goToLeaguePage(testLocationName);
        assertTrue(leaguePage.locationHeaderTitleIsAppeared());
    }

    @Test
    @DisplayName("Nav Menu is appeared")
    public void navMenuIsAppeared() {
        goToLeaguePage(testLocationName);
        assertTrue(header.headerNavMenuIsAppeared());
    }

    @Test
    @DisplayName("Is 'Bajnokság' appeared")
    public void checkLeagueTitle() {
        goToLeaguePage(testLocationName);
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isLeagueTitleAppeared());
    }

    @Test
    @DisplayName("Is Add League button appeared")
    public void checkAddLeagueButton() {
        goToLeaguePage(testLocationName);
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isAddLeagueButtonAppeared());
    }

    @Test
    public void checkAddLeagueModal() {
        goToLeaguePage(testLocationName);
        leaguePage.clickOnAddLeagueButton();
        AddLeagueModal addLeagueModal = new AddLeagueModal(driver);
        assertTrue(addLeagueModal.isModalAppeared());
    }

    @Test
    public void addNewLeague() {
        String leagueName = "Test League";
        goToLeaguePage(testLocationName);
        addNewLeague(leagueName);
        assertTrue(leaguePage.getNewLeaguesNames().stream().anyMatch(name -> name.equals(leagueName)));
    }

    @Test
    @DisplayName("Is Leagues list appeared")
    public void checkLeaguesList() {
        goToLeaguePage(testLocationName);
        addNewLeague("Test League");
        assertTrue(leaguePage.isLeaguesListAppeared());
    }
}
