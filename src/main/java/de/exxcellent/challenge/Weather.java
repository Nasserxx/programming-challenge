package de.exxcellent.challenge;

import java.util.Arrays;

public class Weather  implements  CsvDescerlizer {

    public double day;
    public double mxT;
    public double mnT;
    public double avT;
    public double avDP;
    public double lHrP_tPcpn;
    public double pDir;
    public double avSp;
    public double dir;
    public double mxS;
    public double skyC;
    public double mxR;
    public double mn;
    public double r_avSLP;
    public Weather() {}
    public Weather(double... values) {
        this.day = values[0];
        this.mxT = values[1];
        this.mnT = values[2];
        this.avT = values[3];
        this.avDP = values[4];
        this.lHrP_tPcpn = values[5];
        this.pDir = values[6];
        this.avSp = values[7];
        this.dir = values[8];
        this.mxS = values[9];
        this.skyC = values[10];
        this.mxR = values[11];
        this.mn = values[12];
        this.r_avSLP = values[13];
    }

    @Override
    public Weather descrelizer(String line, String sperator) {
        String [] dataArray= line.split(sperator);
        double[] values= Arrays.stream(dataArray).mapToDouble(Double::parseDouble).toArray();

        return new Weather(values);
    }
}
