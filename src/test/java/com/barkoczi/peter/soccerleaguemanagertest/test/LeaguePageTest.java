package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
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

    @Test
    @DisplayName("Header title is appeared")
    public void headerTitleIsAppearedTest() {
        addNewLocation(testLocationName, driver);
        homePage.clickOnLocation(testLocationName);
        assertTrue(leaguePage.locationHeaderTitleIsAppeared());
        deleteLocation(testLocationName);
    }

    @Test
    @DisplayName("Nav Menu is appeared")
    public void navMenuIsAppeared() {
        addNewLocation(testLocationName, driver);
        homePage.clickOnLocation(testLocationName);
        assertTrue(header.headerNavMenuIsAppeared());
        deleteLocation(testLocationName);
    }

    @Test
    @DisplayName("Is 'Bajnokság' appeared")
    public void checkLeagueTitle() {
        addNewLocation(testLocationName, driver);
        homePage.clickOnLocation(testLocationName);
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isLeagueTitleAppeared());
        deleteLocation(testLocationName);
    }

    @Test
    @DisplayName("Is Add League button appeared")
    public void checkAddLeagueButton() {
        addNewLocation(testLocationName, driver);
        homePage.clickOnLocation(testLocationName);
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isAddLeagueButtonAppeared());
        deleteLocation(testLocationName);
    }

    @Test
    @DisplayName("Is Leagues list appeared")
    public void checkLeaguesList() {
        addNewLocation(testLocationName, driver);
        homePage.clickOnLocation(testLocationName);
        header.clickOnLeaguesButton();
        assertTrue(leaguePage.isLeaguesListAppeared());
        deleteLocation(testLocationName);
    }
}
