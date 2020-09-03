package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddTeamModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.TeamPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TeamPageTest extends BaseTest {

    @BeforeEach
    public void setHomePage() {
        homePage = new HomePage(this.driver);
        teamPage = new TeamPage(this.driver);
        homePage.navigateToHomePage();
    }

    @AfterEach
    public void deleteCreatedLocation() {
        deleteLocation(testLocationName);
    }

    private void goToLocationTeamPage(String location) {
        addNewLocation(location, driver);
        homePage.clickOnLocation(location);
        header = new Header(driver);
        header.clickOnTeamsButton();
    }

    private void addNewTeam(String teamName) {
        teamPage.clickOnAddTeamButton();
        AddTeamModal addTeamModal = new AddTeamModal(driver);
        addTeamModal.fillAddNameInputField(teamName);
        addTeamModal.clickOnSubmitButton();
    }

    @Test
    public void checkPageTitle() {
        goToLocationTeamPage(testLocationName);
        assertTrue(teamPage.isTitleAppeared());
    }

    @Test
    public void checkAddTeamButton() {
        goToLocationTeamPage(testLocationName);
        assertTrue(teamPage.isAddTeamButtonAppeared());
    }

    @Test
    public void checkAddTeamModal() {
        goToLocationTeamPage(testLocationName);
        teamPage.clickOnAddTeamButton();
        AddTeamModal addTeamModal = new AddTeamModal(driver);
        assertTrue(addTeamModal.isModalAppeared());
    }

    @Test
    public void checkTeamsList() {
        goToLocationTeamPage(testLocationName);
        addNewTeam("Test team");
        assertTrue(teamPage.isTeamsListAppeared());
    }

    @Test
    public void addNewTeam() {
        String teamName = "Test team";
        goToLocationTeamPage(testLocationName);
        addNewTeam(teamName);
        boolean isContains = teamPage.getTeams().stream().anyMatch(team -> team.equals(teamName));
        assertTrue(isContains);
    }

    

}
