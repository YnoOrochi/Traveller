/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer.software;

import io.ynoorochi.traveller.ship.computer.SoftItems;

/**
 *
 * @author PR3J
 */
public class AdvFireControl extends SoftItems {
    /* ---------
     *  Constructor
    --------- */
    public AdvFireControl() { setName("Advanced Fire Control"); }
    public AdvFireControl(int max) { 
        setName("Advanced Fire Control"); 
        setMaxBW(max);
    }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        NO( 0,  0,        0),
        V1(10, 15, 12000000),
        V2(12, 25, 15000000),
        V3(14, 30, 18000000);
        
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
            case 2: return setVersion(version.V2);
            case 3: return setVersion(version.V3);
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
