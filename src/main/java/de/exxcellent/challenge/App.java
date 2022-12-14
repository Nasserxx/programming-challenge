package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static <T> List<CsvDescerlizer<T>> csvReader(String path, String sperator, T g) throws IOException {

        List<T> dataList = new ArrayList<T>();

        CsvDescerlizer<T> object = (CsvDescerlizer<T>) g;

        String line = "";

        //parsing a CSV file into BufferedReader class constructor
        BufferedReader br = new BufferedReader(new FileReader(path));


        int header = 0;
        while ((line = br.readLine()) != null) {
            header++;
            // get rid of the header
            if (header == 1) continue;
            dataList.add(object.descrelizer(line, sperator));
        }

        return (List<CsvDescerlizer<T>>) dataList;
    }

    public static String teamWithSmallestGoalSpread(String filePath) throws IOException {
        List<CsvDescerlizer<Football>> data = csvReader(filePath, ",", new Football());
        Football bestTeam = (Football) data.stream().reduce(new Football("test", 10, 1000, 10001, 10000001, 1000001, 10, 1001, 100, 10, 1000, 1000000, 10000), (accumulator, football) -> {

            if (abs(((Football) football).goalsAllowed - ((Football) football).goals) > abs(((Football) accumulator).goalsAllowed - ((Football) accumulator).goals)) {
                return accumulator;
            }
            return football;
        });
        return bestTeam.team;
    }

    public static double dayWithSmallestTempSpread(String filePath) throws IOException {
        List<CsvDescerlizer<Weather>> data = csvReader(filePath, ",", new Weather());

        Weather bestWeather = (Weather) data.stream().reduce(new Weather(30, 90, 45, 68, 63.6, 0, 240, 6, 220, 17, 4.8, 200, 41, 1022.7), (accumulator, weather) -> {

            if (abs(((Weather) weather).mxT - ((Weather) weather).mnT) > abs(((Weather) accumulator).mxT - ((Weather) accumulator).mnT)) {
                return accumulator;
            }
            return weather;
        });
        return bestWeather.day;
    }

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {

        // Your preparation code ???

        try {
            String srcPath = "src/main/resources/de/exxcellent/challenge/";
            String filePath = srcPath + args[1];
            System.out.println(filePath);

            if (args[0] == "--football") {
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread(filePath));
            } else if (args[0] == "--weather") {
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread(filePath));
            } else {
                System.out.println(args[0] + " is not supported, please make sure to pass the correct ClI argument");
            }


        } catch (IOException e) {

            System.out.println("please make sure to enter the correct file name");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please make sure to passe the CLI arguments, which are either --football (filename.csv)" +
                    " or --weather (filename.csv) otherwise the following are the results:");
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread( "src/main/resources/de/exxcellent/challenge/football.csv"));
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread( "src/main/resources/de/exxcellent/challenge/weather.csv"));
        }
    }
}
