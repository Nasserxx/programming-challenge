package de.exxcellent.challenge;

import java.util.Arrays;

public class Weather  implements  CsvDescerlizer {

    public double day;
    public double mxT;
    public double mnT;
    public double avT;
    public double avDP;
    public double lHrP;
    public double tPcpn;
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
        this.lHrP = values[5];
        this.tPcpn = values[6];
        this.pDir = values[7];
        this.avSp = values[8];
        this.dir = values[9];
        this.mxS = values[10];
        this.skyC = values[11];
        this.mxR = values[12];
        this.mn = values[13];
        this.r_avSLP = values[14];
    }

    @Override
    public Weather descrelizer(String line, String sperator) {
        String [] dataArray= line.split(sperator);
        double[] values= Arrays.stream(dataArray).mapToDouble(Double::parseDouble).toArray();

        return new Weather(values);
    }
}
