/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces;

/**
 *
 * @author PR3J
 */
public class Definitions {
    /* ---------
     *  room types table
    --------- */
    public enum RoomType {
        NONE(   0,  0  , 0,     0, 0,       0, "No Rooms"),
        LBERTH( 0,  0.5, 1,     0, 0,   50000, "Low Berths"),
        EBERTH( 0,  1  , 1,     0, 0, 1000000, "Emergency Low Berths"),
        CABINS( 0,  1.5, 0,   375, 1,   75000, "Cabin Space"),
        SROOMS( 0,  4  , 0,  1000, 1,  500000, "Staterooms"),
        DROOMS( 0,  4  , 0,  2000, 2,  500000, "Double Occupancy Staterooms"),
        HROOMS( 0,  6  , 0,  1500, 1,  800000, "High Staterooms"),
        LROOMS( 0, 10  , 0,  5000, 1, 1500000, "Luxury Staterooms"),
        COMMON( 0,  1  , 0,     0, 0,  100000, "Common Area & Living Space"),
        ABENCH( 0,  1  , 0,     0, 0,   10000, "Acceleration Benches (4 seats)"),
        ASEATS( 0,  0.5, 0,     0, 0,   30000, "Acceleration Seats"),
        BARRCK( 0,  2  , 0,   500, 1,  100000, "Barracks"),
        BRIG06( 0,  4  , 0,  1000, 0,  250000, "Brig (6 prisoners)"),
        MENVSP( 0, 20  , 0,     0, 0,  500000, "Multi-environment Space"),
        BIOSPH( 0,  1  , 1, -2000, 0,  200000, "Biosphere"),
        STABLE( 0, 10  , 0,  2500, 0,   25000, "Stables"),
        ARMORY( 0,  1  , 0,     0, 0,  250000, "Armories"),
        BRIEFG( 0,  4  , 0,     0, 0,  500000, "Briefing Rooms"),
        CNCEAL( 0,  1  , 0,     0, 0,   20000, "Concealed Compartment"),
        CTDECK( 0,  1  , 1,     0, 0,  500000, "Construction Deck"),
        DOCKSP( 0,  1.1, 0,     0, 0,  275000, "Docking Space"),
        GAMING( 0,  1  , 0,     0, 0,    6000, "Gaming Space"),
        GRAVSC(12,  1  , 2,     0, 0, 1000000, "Grav Screen (per 200T shielded)"),
        HANGAR( 0,  2  , 0,     0, 0,  200000, "Full Hangar"),
        LABTRY( 0,  4  , 0,     0, 0, 1000000, "Laboratories (per scientist)"),
        LIBRRY( 0,  4  , 0,     0, 0,  500000, "Library"),
        MEDBAY( 0,  4  , 1,     0, 0, 2000000, "Medical Bay (per 5 patients)"),
        PSYONS(12,  4  , 0,     0, 0, 2000000, "Psion Stateroom"),
        RECOVR( 0,  1  , 1,     0, 0,  500000, "Recovery Deck"),
        STUDIO( 0,  4  , 0,     0, 0,  400000, "Studios"),
        TRAINF(10,  2  , 2,     0, 0,  400000, "Trainning Facilities (per trainee)"),
        UNREPS( 0,  1  , 1,     0, 0, 6000000, "UNREP Systems"),
        VAULTS(14, 12  , 0,     0, 0, 6000000, "Vaults"),
        WRKSHP( 0,  6  , 0,     0, 0,  900000, "Workshops (per 2 mechanics)");
        
        private final int tl;
        private final double weight;
        private final int power;
        private final int lfsup;
        private final int passenger;
        private final double cost;
        private final String name;
        
        private RoomType(int tl, double wg, int pw, int lf, int ps, double ct, String nm) {
            this.tl = tl;
            this.weight = wg;
            this.power = pw;
            this.lfsup = lf;
            this.passenger = ps;
            this.cost = ct;
            this.name = nm;
        }

        public int getTL() { return tl; }
        public double getWeight() { return weight; }
        public int getPower() { return power; }
        public int getLfSup() { return lfsup; }
        public int getPassengers() { return passenger; }
        public double getCost() { return cost; }
        public String getName() { return name; }
        
    }
}
