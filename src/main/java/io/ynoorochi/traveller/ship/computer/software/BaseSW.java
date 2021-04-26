/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer.software;

/**
 *
 * @author PR3J
 */
public class BaseSW {

    /* ---------
     *  Attributes
    --------- */
    private int maxBW = 5;

    /* ---------
     *  Constructor
    --------- */
    public BaseSW(int max) {
        setMaxBW(max);
    }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        NO( 0,  0,        0);
        
        private int tl;
        private int bw;
        private double cost;
        
        private Version(int tl, int bw, double cost) {
            this.tl = tl;
            this.bw = bw;
            this.cost = cost;
        }
        
        public int getTL() { return this.tl; }
        public int getBW() { return this.bw; }
        public double getCost() { return this.cost; }
    }

    /* ---------
     *  Maximum Bandwidth
    --------- */
    public int getMaxBW() { return this.maxBW; }
    public void setMaxBW(int max) { this.maxBW = max; }
    
    /* ---------
    *  isOptiOn
    --------- */
    public boolean isOptiOn() { return this.version != Version.NO; }

    /* ---------
     *  Version Attribute
    --------- */
    private Version version = Version.NO;
    public Version getVersion() { return this.version; }
    public boolean setVersion(Version ver) { 
        if (ver.getBW() <= getMaxBW()) {  
            this.version = version;
            return true;
        } else return false;
    }

    /* ---------
    *  Get Methods
    --------- */
    public int getTL() { return this.version.getTL(); }
    public int getBW() { return this.version.getBW(); }
    public double getCost() { return this.version.getCost(); }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(getVersion());
        if (isOptiOn()) {
            sb.append(", BW=").append(getBW());
            sb.append(", TL=").append(getTL());
        }
        sb.append('}');
        return sb.toString();
    }

    
}
