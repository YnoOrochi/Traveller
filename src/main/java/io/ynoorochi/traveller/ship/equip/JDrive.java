/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

import io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes;
import static io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes.*;

/**
 *
 * @author PR3J
 */
public class JDrive extends Equipment {
    private final int MINW = 10;
    
    /* ---------
     *  Constructor
    --------- */
    public JDrive(JDriveTypes type, int rating, int size) {
        this.setType(type);
        this.setRating(rating);
        this.setHullSize(size);
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
    *  JDrivePower
    *           requires a number of Power points equal to 10% of the
    *       hull’s total tonnage multiplied by the maximum jump
    *       number the drive is capable of.
    --------- */
    public double getPower() {
        return 0.1 * getRating() * getHullSize();
    }
    
    /* ---------
    *  JDriveRating
    --------- */
    private int rating = 0;

    @Override
    public int getRating() {
        return this.rating;
    }

    public boolean setRating(int rating) {
        if (rating > 0)
            if (rating <= getType().getMax()) {
                this.rating = rating;
                return true;
            } else {
                this.rating = getType().getMax();
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
    @Override
    public double getCost() {
        return getType().getCost() * getHullSize();
    }

    /* ---------
    *  MDriveTL
    --------- */
    @Override
    public int getTL() {
        return getType().getTL(getRating());
    }
    
    /* ---------
    *  JDriveWeight
    --------- */
    @Override
    public double getWeight() {
        switch(getType()) {
            case Jump: return 0.025 * getRating() * getHullSize();
            default: return 0;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JDrive{").append(getRating());
        sb.append(", HullSize=").append(getHullSize());
        if(getType() == Jump) sb.append(", Cost=").append(getCost());
        if(getType() == Jump) sb.append(", Pwr=").append(getPower());
        if(getType() == Jump) sb.append(", TL=").append(getTL());
        if(getType() == Jump) sb.append(", Weight=").append(getWeight());
        sb.append(", TL=").append(getTL());
        sb.append('}');
        return sb.toString();
    }
}
