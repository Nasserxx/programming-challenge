package de.exxcellent.challenge;

public class Weather {

    public float day;
    public float mxT;
    public float mnT;
    public float avT;
    public float avDP;
    public float lHrP;
    public float tPcpn;
    public float pDir;
    public float avSp;
    public float dir;
    public float mxS;
    public float skyC;
    public float mxR;
    public float mn;
    public float r_avSLP;
    public Weather() {}
    public Weather(float... values) {
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


}
