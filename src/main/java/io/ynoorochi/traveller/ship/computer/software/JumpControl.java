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
public class JumpControl extends BaseSW {
    /* ---------
     *  Constructor
    --------- */
    public JumpControl() { setName("Jump Control"); }
    
    /* ---------
    *  Attributes
    --------- */
    private Version jump = Version.V1;
    
    /* ---------
    *  Software Version
    --------- */
    public enum Version {
        NO( 0,  0,        0),
        V1( 9,  5,   100000),
        V2(11, 10,   200000),
        V3(12, 15,   300000),
        V4(13, 20,   400000),
        V5(14, 25,   500000),
        V6(15, 30,   600000);
        
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
    public boolean setVersion(double jump) {
        switch((int) jump) {
            case 1: return setVersion(version.V1);
            case 2: return setVersion(version.V2);
            case 3: return setVersion(version.V3);
            case 4: return setVersion(version.V4);
            case 5: return setVersion(version.V5);
            case 6: return setVersion(version.V6);
            default: return setVersion(version.NO);
        }
    }

    private boolean setVersion(Version ver) { 
        this.version = ver;
        return true;
    }

    /* ---------
    *  Get Methods
    --------- */
    @Override
    public int getTL() { return this.version.getTL(); }
    
    @Override
    public int getBW() { return this.version.getBW(); }
    
    @Override
    public double getCost() { return this.version.getCost(); }
}
