package de.exxcellent.challenge;

import java.util.Arrays;

public class Football implements  CsvDescerlizer {
    public String team;
    public int games;
    public int wins;
    public int losses;
    public int draws;
    public int goals;
    public int goalsAllowed;
    public int points;

    public Football() {

    }
    public Football(String team,int ...values) {
        this.team = team;
        this.games = values[0];
        this.wins = values[1];
        this.losses =  values[2];
        this.draws =  values[3];
        this.goals =  values[4];
        this.goalsAllowed =  values[5];
        this.points =  values[6];
    }

    @Override
    public Football descrelizer(String line, String sperator) {
        String [] dataArray= line.split(sperator);
        String [] strValues =Arrays.copyOfRange(dataArray,1,dataArray.length);

        String team = dataArray[0];
        int[] intValues= Arrays.stream(strValues).mapToInt(Integer::parseInt).toArray();

        return new Football(team,intValues);
    }
}
