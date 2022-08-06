package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }
    @Test
    void dayOfSmallestTemperature() throws IOException {
     double exepted = 14.0;
     double result = App.dayWithSmallestTempSpread("src/main/resources/de/exxcellent/challenge/weather.csv");
        assertEquals(exepted, result, "My expectations were not met");
    }
    @Test
    void teamOfSmallestDifferrence() throws IOException {
        String exepted = "Aston_Villa";
        String result = App.teamWithSmallestGoalSpread("src/main/resources/de/exxcellent/challenge/football.csv");
        assertEquals(exepted, result, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }
    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }


}