/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

/**
 *
 * @author PR3J
 */
public class Definitions {
    /* ---------
    *  Sensors Enum
    --------- */
    public enum SensorTypes {
        Basic(    8, 0, 0,       0, -4, "Lidar, Radar"),
        Civilian( 9, 1, 1, 3000000, -2, "Lidar, Radar"),
        Military(10, 2, 2, 4100000,  0, "Lidar, Radar, Jammers"),
        Improved(12, 4, 3, 4300000, +1, "Lidar, Radar, Jammers, Densitometer"),
        Advanced(15, 6, 5, 5300000, +2, "Lidar, Radar, Jammers, Densitometer, Neural Activity");
        
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        private final int dmModf;
        private final String equips;
        
        private SensorTypes(int tl, int pwr, int wgt, double cst, int dm, String eqp) {
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
            this.dmModf = dm;
            this.equips = eqp;
        }

        public int    getTl()     { return tl; }
        public int    getPower()  { return power; }
        public int    getWeight() { return weight; }
        public double getCost()   { return cost; }
        public int    getDmModf() { return dmModf; }
        public String getEquips() { return equips; }
    }

    /* ---------
    *  Countermeasure Suits
    --------- */
    public enum CountermSuits {
        NONE(     0, 0,  0,        0),
        BASIC(   13, 1,  2,  4000000),
        MILITARY(15, 2, 15, 28000000);
        
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        
        private CountermSuits(int tl, int pwr, int wgt, double cst) {
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
        }

        public int    getTl()     { return tl; }
        public int    getPower()  { return power; }
        public int    getWeight() { return weight; }
        public double getCost()   { return cost; }
    }

    /* ---------
    *  Distributed/Extended Arrays
    --------- */
    public enum DistributedArrays {
        NONE(  0, 0, 0,        0, "No"),
        DISTR(11, 2, 4,  8200000, "Distributed"),
        EXTND(11, 4, 4,  8200000, "Extended"),
        RAPID(11, 4, 4, 16400000, "Rapid Deployment");
        
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        private final String name;
        
        private DistributedArrays(int tl, int pwr, int wgt, double cst, String name) {
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
            this.name = name;
        }

        public int    getTl()     { return tl; }
        public int    getPower()  { return power; }
        public int    getWeight() { return weight; }
        public double getCost()   { return cost; }
        public String getName()   { return name; }
    }

    /* ---------
    *  Life Scanner
    --------- */
    public enum LifeScanners {
        NONE( 0, 0, 0,       0),
        TL12(12, 1, 1, 2000000),
        TL14(14, 1, 1, 4000000);
        
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        
        private LifeScanners(int tl, int pwr, int wgt, double cst) {
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
        }

        public int    getTl()     { return tl; }
        public int    getPower()  { return power; }
        public int    getWeight() { return weight; }
        public double getCost()   { return cost; }
    }

    /* ---------
    *  Mail Distribution Array
    --------- */
    public enum MailDistArrays {
        NONE( 0, 0,  0,        0),
        TL10(10, 0, 10, 20000000),
        TL13(13, 0, 20, 10000000);
        
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        
        private MailDistArrays(int tl, int pwr, int wgt, double cst) {
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
        }

        public int    getTl()     { return tl; }
        public int    getPower()  { return power; }
        public int    getWeight() { return weight; }
        public double getCost()   { return cost; }
    }
}
