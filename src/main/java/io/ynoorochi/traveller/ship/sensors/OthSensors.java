/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class OthSensors extends Items {
    /* ---------
    *  Other sensors
    --------- */
    protected enum OtherSensors {
        ESP("Enhanced Signal Processing", false, 13, 2,  2, 8000000, false),
        ISP("Improved Signal Processing", false, 11, 1,  1, 4000000, false),
        MDS("Mineral Detection Suite",    false,  7, 0,  0, 5000000, false),
        SPS("Shallow Penetration Suite",  false, 10, 1, 10, 5000000, false);

        private final String name;
        private boolean used;
        private final int tl;
        private final int power;
        private final int weight;
        private final double cost;
        private boolean hardened;
        
        private OtherSensors(String name, boolean used, int tl, int pwr, 
                            int wgt, double cst, boolean hard) {
            this.name = name;
            this.used = used;
            this.tl = tl;
            this.power = pwr;
            this.weight = wgt;
            this.cost = cst;
        }

        public boolean  isUsed()     { return used; }
        public String   getName()    { return name; }
        public int      getTl()      { return tl; }
        public int      getPower()   { return power; }
        public int      getWeight()  { return weight; }
        public double   getCost()    { return cost; }
        public boolean  isHardened() { return hardened; }
        
        public void     setUsed(boolean used) { this.used = used; }
        public void     setHardened(boolean hard) { this.hardened = hard; }
}

    /* ---------
    *  type
    --------- */
    private OtherSensors type;
    
    public OtherSensors getType () {
        return this.type;
    }

    /* ---------
    *  Tech Level
    --------- */
//    @Override
//    public int getTL() {
//        for (var Type : OtherSensors.values()) {
//            return getTl(Type.);
//        }
//    }
    
    public int getTL(OtherSensors type) {
        return type.getTl();
    }
    
    /* ---------
    *  Power used
    --------- */
    public double getPower(OtherSensors type) {
        return type.getPower();
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    public double getWeight(OtherSensors type) {
        return type.getWeight();
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    public double getCost(OtherSensors type) {
        return getHardened() * type.getCost();
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(getType());
        sb.append(", TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Power=").append(getPower());
        if (isHardened()) sb.append(", Hardened");
        sb.append('}');
        return sb.toString();
    }
}
