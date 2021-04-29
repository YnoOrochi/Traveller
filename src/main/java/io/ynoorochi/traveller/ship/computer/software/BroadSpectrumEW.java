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
public class BroadSpectrumEW extends BaseSW {
   /* ---------
     *  Constructor
    --------- */
    public BroadSpectrumEW() { setName("Broad Spectrum EW"); }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        NO( 0,  0,        0),
        V1(12, 12, 14000000);
        
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
    public boolean isOptiOn() { 
        return (getVersion() != Version.NO);
    }

    /* ---------
     *  Version Attribute
    --------- */
    private Version version = Version.NO;
    
    @Override
    public Version getVersion() { return this.version; }
    
    @Override
    public boolean setVersion(double ver) { 
        switch((int) ver) {
            case 1: return setVersion(version.V1);
            default: return setVersion(version.NO);
        }
    }
        
    private boolean setVersion(Version ver) { 
        if (ver.getBW() <= getMaxBW()) {  
            this.version = ver;
            return true;
        } else return false;
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
