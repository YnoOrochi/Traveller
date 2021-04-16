/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.propulsion;

import io.ynoorochi.traveller.propulsion.DriveTypes.JDriveTypes;

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
        this.setJDriveType(type);
        this.setJDriveRating(rating);
    }

    /* ---------
    *  jDriveType
    --------- */
    private JDriveTypes jDriveType = JDriveTypes.Jump;
    
    public JDriveTypes getJDriveType () {
        return this.jDriveType;
    }
    
    public boolean setJDriveType(JDriveTypes type) {
        this.jDriveType = type;
        setJDriveRating(this.jDriveRating);
        return true;
    }

    /* ---------
    *  JDriveRating
    --------- */
    private int jDriveRating = 0;

    public int getJDriveRating() {
        return this.jDriveRating;
    }

    public boolean setJDriveRating(int rating) {
        if (rating > 0)
            if (rating <= jDriveType.getJDriveMax()) {
                this.jDriveRating = rating;
                return true;
            } else {
                this.jDriveRating = jDriveType.getJDriveMax();
                return false;
            }
        else {
            jDriveRating = 0;
            return false;
        }
    }

    /* ---------
    *  JDriveCost
    --------- */
    public double getJDriveCost(int hullSize) {
        return hullSize * getJDriveCost();
    }
    
    public double getJDriveCost() {
        return jDriveType.getJDriveCost();
    }

    /* ---------
    *  MDriveTL
    --------- */
    public int getJDriveTL(int rating) {
        return jDriveType.getJDriveTL(rating);
    }
    
    /* ---------
    *  JDriveWeight
    --------- */
    public double getJDriveWeight(int hullSize) {
        return hullSize * getJDriveWeight();
    }
    
    public double getJDriveWeight() {
        switch(jDriveType) {
            case Jump: return 0.025 * jDriveRating;
            default: return 0;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JDrive{Type=").append(jDriveType);
        sb.append(", Rating=").append(jDriveRating);
        sb.append(", TL=").append(getJDriveTL(jDriveRating));
        sb.append('}');
        return sb.toString();
    }
}
