/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

/**
 *
 * @author PR3J
 */
public class Definitions {

    public enum Computers {
        NONE(   "No",                 0,   0,  0),
        COMP05( "Computer/5",     30000,   5,  7),
        COMP10( "Computer/10",   160000,  10,  9),
        COMP15( "Computer/15",  2000000,  15, 11),
        COMP20( "Computer/20",  5000000,  20, 12),
        COMP25( "Computer/25", 10000000,  25, 13),
        COMP30( "Computer/30", 20000000,  30, 14),
        COMP35( "Computer/35", 30000000,  35, 15),
        CORE40( "Core/40",     45000000,  40,  9),
        CORE50( "Core/50",     60000000,  50, 10),
        CORE60( "Core/60",     75000000,  60, 11),
        CORE70( "Core/70",     80000000,  70, 12),
        CORE80( "Core/80",     95000000,  80, 13),
        CORE90( "Core/90",    120000000,  90, 14),
        CORE100("Core/100",   130000000, 100, 15);
        
        private final String name;
        private final double cost;
        private final int band;
        private final int tl;
        
        private Computers(String name, double cost, int band, int tl) {
            this.name = name;
            this.cost = cost;
            this.band = band;
            this.tl = tl;
        }
        
        public String getName()     { return this.name; }
        public double getCost()     { return this.cost; }
        public int    getBandwidth() { return this.band; }
        public int    getTL()       { return this.tl; }
    }
}
