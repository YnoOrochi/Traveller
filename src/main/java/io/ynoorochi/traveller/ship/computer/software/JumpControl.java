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
    *  Attributes
    --------- */
    private Version jump = Version.NO;
    
    /* ---------
    *  Constructor
    --------- */
    public JumpControl(int max, double jump) {
        super(max);
        setJump(jump);
        System.out.println("Passei" + jump);
    }
    
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
    *  Jump
    --------- */
    public void setJump(double jump) {
        switch((int) jump) {
            case 1:
                this.jump = Version.V1;
                break;
            case 2:
                this.jump = Version.V2;
                break;
            case 3:
                this.jump = Version.V3;
                break;
            case 4:
                this.jump = Version.V4;
                break;
            case 5:
                this.jump = Version.V5;
                break;
            case 6:
                this.jump = Version.V6;
                break;
            default: this.jump = Version.NO;
        System.out.println("Passei" + jump);
        }
        
    }
}
