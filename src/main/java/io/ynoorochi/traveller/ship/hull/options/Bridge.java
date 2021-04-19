/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.BridgeTypes;
import static io.ynoorochi.traveller.ship.hull.Definitions.BridgeTypes.*;

/**
 *
 * @author PR3J
 */
public class Bridge extends Items {
    /* ---------
     *  Constructor
    --------- */
    public Bridge() {
        setOptiOn(true);
    }
    
    /* ---------
    *  Bridge Types
    *       Command bridge can be used by any ship of 5,000 tons or more
    *       Instead of a bridge, ships of 50 tons or less may install a cockpit.
    --------- */
    private BridgeTypes type = Normal;

    public BridgeTypes getType() {
        return this.type;
    }

    public boolean setType(BridgeTypes type) {
        this.type = type;
        switch (type) {
            case Command: 
                if (getHullSize() < 5000) this.type = Normal;
                break;
            case Cockpit:
            case DualCockpit:
                if (getHullSize() > 50) this.type = Normal;
                break;
        }
        return (this.type == type);
    }

    /* ---------
    *  Bridge Size
    *       Command bridge consumes 80 tons
    *       Cockpit consumes 1.5 ton of space
    *       DualCockpit consumes 2.5 tons of space
    *       A ship can have a bridge one size smaller than in the Bridges table
    --------- */
    @Override
    public double getWeight() {
        final int[] bgSizes = { 3,  3,  6, 10, 20, 40, 60 };
        final int[] detach = { 15, 15, 15, 15, 30, 50, 70 };
        int pos = 0;
        switch (getType()) {
            case Command: return 80;
            case Cockpit: return 1.5;
            case DualCockpit: return 2.5;
            case Smaller: pos -= 1;
            default:
                if      (getHullSize() <    50) pos += 1;
                else if (getHullSize() <   100) pos += 2;
                else if (getHullSize() <=  200) pos += 3;
                else if (getHullSize() <= 1000) pos += 4;
                else if (getHullSize() <= 2000) pos += 5;
                else                            pos += 6;
                return  bgSizes[pos] +
                        getSStations() +
                        (isDetach() ? detach[pos] : 0);
        }
    }
    
    /* ---------
    *  Bridge Cost
    *       Command bridge costs MCr0.75 per 100 tons (or part of) of the ship.
    *       Cockpit costs Cr10000.
    *       DualCockpit costs Cr15000
    *       Smaller halves the cost of the bridge.
    *       Otherwise the cost is MCr0.5 per 100 tons (or part of) of the ship
    --------- */
    @Override
    public double getCost() {
        int modf = 1;
        int optCost = 0;
        if (isDetach()) optCost += 300000 * Math.ceil(getHullSize());
        
        switch (getType()) {
            case Command: optCost += 7500 * getHullSize();
                break;
            case Cockpit: optCost += 10000;
                break;
            case DualCockpit: optCost += 15000;
                break;
            case Smaller: modf = 2;
            default: optCost += 5000 * getHullSize() / modf;
        }
        return Math.ceil((isHolog() ? 1.25 : 1) * optCost) + 500000 * getSStations();
    }

    /* ---------
    *  Bridge Option: Detachable
    --------- */
    private boolean detachable = false;
            
    public boolean isDetach() {
        return this.detachable;
    }
    
    public void setDetach(boolean opt) {
        this.detachable = opt;
    }
    
    /* ---------
    *  Bridge Option: Holographic Controls
    --------- */
    private boolean holographic = false ;
    
    public boolean isHolog() {
        return this.holographic;
    }
    
    public void setHolog(boolean opt) {
        this.holographic = opt;
    }
    
    /* ---------
    *  Bridge Option: Sensor Stations
    --------- */
    private int sStations = 0;
    
    public int getSStations() {
        return this.sStations;
    }
    
    public void setSStations(int n) {
        this.sStations = n;
    }
    
    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(getType());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Cost=").append(getCost());
        if (isDetach()) sb.append(", Detachable");
        if (isHolog()) sb.append(", Holographic Controls");
        if (getSStations() > 0) sb.append(", Sensor Stations=").append(getSStations());
        sb.append('}');
        return sb.toString();
    }
}

