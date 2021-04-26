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
public class FireControl extends BaseSW {
    /* ---------
     *  Constructor
    --------- */
    public FireControl(int max) {
        super(max);
    }
    
    /* ---------
     *  Software Version
    --------- */
    public enum Version {
        NO( 0,  0,        0),
        V1( 9,  5,   200000),
        V2(10, 10,   400000),
        V3(11, 15,   600000),
        V4(12, 20,   800000),
        V5(13, 25,  1000000);
        
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
}
