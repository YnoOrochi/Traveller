/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes;
import static io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes.*;

/**
 *
 * @author PR3J
 */
public class JDrive extends Items {
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
        setRating(getRating());
        return true;
    }

    /* ---------
    *  JDrivePower
    *           requires a number of Power points equal to 10% of the
    *       hull’s total tonnage multiplied by the maximum jump
    *       number the drive is capable of.
    --------- */
    @Override
    public double getPower() {
        return 0.1 * getRating() * getHullSize();
    }
    
    /* ---------
    *  JDriveRating
    --------- */
    public double getRating() {
        return getAttribute();
    }
    
    public boolean setRating(double rating) {
        if (rating > 0)
            if (rating <= getType().getMax()) {
                setAttribute(rating);
                return true;
            } else {
                setAttribute(getType().getMax());
                return false;
            }
        else {
            setAttribute(0);
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
        return getType().getTL((int) Math.ceil(getRating()));
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
        sb.append("JDrive{").append((int) getRating());
        sb.append(", HullSize=").append(getHullSize());
        if(getType() == Jump) sb.append(", Cost=").append(getCost());
        if(getType() == Jump) sb.append(", Pwr=").append(getPower());
        if(getType() == Jump) sb.append(", TL=").append(getTL());
        if(getType() == Jump) sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
