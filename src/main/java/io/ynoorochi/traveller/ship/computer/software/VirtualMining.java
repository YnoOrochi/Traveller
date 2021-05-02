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
public class VirtualMining extends SoftItems {
   /* ---------
     *  Constructor
    --------- */
    public VirtualMining() { setName("Virtual Mining"); }
    public VirtualMining(int max) { 
        setName("Virtual Mining"); 
        setMaxBW(max);
    }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        NO( 0, 0,         0),
        YES(7, 1, 100000000);
        
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
     *  choosed Bandwidth
    --------- */
    private int mBandwidth = 0;
    
    /* ---------
     *  Version Attribute
    --------- */
    private Version version = Version.NO;
    
    @Override
    public Version getVersion() { return this.version; }
    
    @Override
    public boolean setVersion(double ver) { 
        if (ver > 0 && ver <= getMaxBW()) {
            this.mBandwidth = (int) ver;
            this.version = Version.YES;
            return true;
        } else {
            this.mBandwidth = 0;
            this.version = Version.NO;
            return (ver == 0);
        }
    }

    /* ---------
    *  Get Methods
    --------- */
    @Override
    public int getTL() { return version.getTL(); }
    
    @Override
    public int getBW() { return this.mBandwidth * version.getBW(); }
    
    @Override
    public double getCost() { return this.mBandwidth * version.getCost(); }
}
