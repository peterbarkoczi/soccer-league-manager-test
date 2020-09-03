package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.AddTeamModal;
import com.barkoczi.peter.soccerleaguemanagertest.pages.Header;
import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.TeamPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertTrue(teamPage.getTeams().stream().anyMatch(team -> team.equals(teamName)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test team 1", "Test team 2", "Test team 3", "Test team 4", "Test team 5"})
    public void addDifferentTeams(String teamName) {
        goToLocationTeamPage(testLocationName);
        addNewTeam(teamName);
        assertTrue(teamPage.getTeams().stream().anyMatch(team -> team.equals(teamName)));
    }

    @Test
    public void addMultipleTeams() {
        goToLocationTeamPage(testLocationName);
        List<String> newTeams = Arrays.asList("Test team 1", "Test team 2", "Test team 3", "Test team 4", "Test team 5");
        for (String newTeam : newTeams) {
            addNewTeam(newTeam);
        }
        assertEquals(newTeams, teamPage.getTeams());
    }

    @ParameterizedTest
    @MethodSource("provideTeams")
    public void addDifferentTeamLists(List<String> teamList) {
        goToLocationTeamPage(testLocationName);
        for (String team : teamList) {
            addNewTeam(team);
        }
        assertEquals(teamList, teamPage.getTeams());
    }

    private static Stream<Arguments> provideTeams() {
        return Stream.of(
                Arguments.of(Arrays.asList("Test team 1", "Test team 2", "Test team 3")),
                Arguments.of(Arrays.asList("Test team 4", "Test team 5", "Test team 6")),
                Arguments.of(Arrays.asList("Test team 7", "Test team 8", "Test team 9"))
        );
    }

}
