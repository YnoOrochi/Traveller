/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.accomodations;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
class RoomItems extends Items {
    /* ---------
     *  room types table
    --------- */
    public enum RoomType {
        NONE(   0,  0  , 0,     0, 0,       0, "No Rooms"),
        LBERTH( 0,  0.5, 1,     0, 0,   50000, "Low Berths"),
        ELBRTH( 0,  1  , 1,     0, 0, 1000000, "Emergency Low Berths"),
        CABINS( 0,  1.5, 0,   375, 1,   75000, "Cabin Space"),
        STROOM( 0,  4  , 0,  1000, 1,  500000, "Staterooms"),
        DOUBLE( 0,  4  , 0,  2000, 2,  500000, "Double Occupancy Staterooms"),
        HROOMS( 0,  6  , 0,  1500, 1,  800000, "High Staterooms"),
        LROOMS( 0, 10  , 0,  5000, 1, 1500000, "Luxury Staterooms"),
        COMMON( 0,  1  , 0,     0, 0,  100000, "Common Area & Living Space"),
        ACCBCH( 0,  1  , 0,     0, 0,   10000, "Acceleration Benches (4 seats)"),
        ACCSTS( 0,  0.5, 0,     0, 0,   30000, "Acceleration Seats"),
        BARRCK( 0,  2  , 0,   500, 1,  100000, "Barracks"),
        BRIG06( 0,  4  , 0,  1000, 0,  250000, "Brig (6 prisoners)"),
        MENVSP( 0, 20  , 0,     0, 0,  500000, "Multi-environment Space"),
        BIOSPH( 0,  1  , 1, -2000, 0,  200000, "Biosphere"),
        STABLE( 0, 10  , 0,  2500, 0,   25000, "Stables");
        
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

    /* ---------
     *  Room
    --------- */
    private RoomType room = RoomType.NONE;
    public RoomType getRoomType() { return room; }
    protected void setRoomType(RoomType room) { this.room = room; }

    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setQtty(opt ? 1 : 0);
        return true;
    }
    /* ---------
     *  Tech Level
    --------- */
    @Override
    public int getTL() { return getRoomType().getTL(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return getQtty() * getRoomType().getWeight(); }
    
    /* ---------
     *  Power used
    --------- */
    @Override
    public double getPower() { return getQtty() * getRoomType().getPower(); }

    /* ---------
     *  Option Life Support
    --------- */
    public double getLifeSupport() { return getQtty() * getRoomType().getLfSup();
    }
    
    /* ---------
     *  Option Passenger
    --------- */
    public double getPassengers() { return getQtty() * getRoomType().getPassengers(); }
    
    /* ---------
    *  Option Get Name
    --------- */
    @Override
    public String getName() { return getRoomType().getName(); }
    
    /* ---------
    *  Input quantity of this room 
    *       Rating
    --------- */
    public int getQtty() { return (int) getAttribute(); }
    public void setQtty(int qtty) {
        setAttribute(qtty);
        super.setOptiOn(qtty > 0);
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{").append(getQtty());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            sb.append(", Life Support=").append(getLifeSupport());
            sb.append(", Passengers=").append(getPassengers());
            sb.append(", Cost=").append(getCost());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
