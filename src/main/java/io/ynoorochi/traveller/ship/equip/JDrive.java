/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

import io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes;

/**
 *
 * @author PR3J
 */
public class JDrive {
    private final int MINW = 10;
    
    /* ---------
     *  Constructor
    --------- */
    public JDrive(JDriveTypes type, int rating) {
        this.setType(type);
        this.setRating(rating);
    }

    /* ---------
    *  type
    --------- */
    private JDriveTypes type = JDriveTypes.Jump;
    
    public JDriveTypes getType () {
        return this.type;
    }
    
    public boolean setType(JDriveTypes type) {
        this.type = type;
        setRating(this.rating);
        return true;
    }

    /* ---------
    *  JDriveRating
    *           requires a number of Power points equal to 10% of the
    *       hull’s total tonnage multiplied by the maximum jump
    *       number the drive is capable of.
    --------- */
    public double getPower() {
        return 0.1 * getRating();
    }
    
    public double getPower(int hullSize) {
        return this.getPower() * hullSize;
    }
    
    /* ---------
    *  JDriveRating
    --------- */
    private int rating = 0;

    public int getRating() {
        return this.rating;
    }

    public boolean setRating(int rating) {
        if (rating > 0)
            if (rating <= type.getMax()) {
                this.rating = rating;
                return true;
            } else {
                this.rating = type.getMax();
                return false;
            }
        else {
            this.rating = 0;
            return false;
        }
    }

    /* ---------
    *  JDriveCost
    --------- */
    public double getCost(int hullSize) {
        return hullSize * getCost();
    }
    
    public double getCost() {
        return type.getCost();
    }

    /* ---------
    *  MDriveTL
    --------- */
    public int getTL(int rating) {
        return type.getTL(rating);
    }
    
    /* ---------
    *  JDriveWeight
    --------- */
    public double getWeight(int hullSize) {
        return hullSize * getWeight();
    }
    
    public double getWeight() {
        switch(type) {
            case Jump: return 0.025 * rating;
            default: return 0;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JDrive{Type=").append(type);
        sb.append(", Rating=").append(rating);
        sb.append(", TL=").append(getTL(rating));
        sb.append('}');
        return sb.toString();
    }
}
