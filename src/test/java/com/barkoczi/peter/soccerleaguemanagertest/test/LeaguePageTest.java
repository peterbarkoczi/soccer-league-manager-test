package com.barkoczi.peter.soccerleaguemanagertest.test;

import com.barkoczi.peter.soccerleaguemanagertest.pages.HomePage;
import com.barkoczi.peter.soccerleaguemanagertest.pages.LeaguePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LeaguePageTest extends BaseTest {

    @BeforeEach
    public void setHomePage() {
        homePage = new HomePage(this.driver);
        leaguePage = new LeaguePage(this.driver);
        homePage.navigateToHomePage();

    }

    @Test
    @DisplayName("Header title is appeared")
    public void headerTitleIsAppearedTest() {
        String locationName = homePage.createNewLocation("New Test Location");

    }

}
