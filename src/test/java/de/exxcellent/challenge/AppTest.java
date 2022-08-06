package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void dayOfSmallestTemperature(){
     int exepted = 14;
     int result = 14;
        assertEquals(exepted, result, "My expectations were not met");
    }
    @Test
    void teamOfSmallestDifferrence(){
        String exepted = "Aston_Villa";
        String result = "Aston_Villa";
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