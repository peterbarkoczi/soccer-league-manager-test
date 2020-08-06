package com.barkoczi.peter.soccerleaguemanagertest.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class LeaguePage extends BasePage {

    public LeaguePage(WebDriver driver) {
        super(driver);
    }



}
