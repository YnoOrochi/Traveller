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
public class Library extends BaseSW {
    /* ---------
     *  Constructor
    --------- */
    public Library() { setName("Library"); }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        VO( 8,  0,        0);
        
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
    *  isOptiOn
    --------- */
    @Override
    public boolean isOptiOn() { return true; }

    /* ---------
     *  Version Attribute
    --------- */
    private Version version = Version.VO;
    
    @Override
    public Version getVersion() { return this.version; }
    
    @Override
    public boolean setVersion(double ver) { 
        this.version = Version.VO;
        return true;
    }

    /* ---------
    *  Get Methods
    --------- */
    @Override
    public int getTL() { return version.getTL(); }
    
    @Override
    public int getBW() { return version.getBW(); }
    
    @Override
    public double getCost() { return version.getCost(); }
}
