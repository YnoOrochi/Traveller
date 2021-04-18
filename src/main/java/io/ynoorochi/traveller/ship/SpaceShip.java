/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

import io.ynoorochi.traveller.ship.equip.*;
import io.ynoorochi.traveller.ship.hull.*;

import static io.ynoorochi.traveller.ship.Customization.*;
import static io.ynoorochi.traveller.ship.equip.Definitions.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.*;

/**
 *
 * @author PR3J
 */
public class SpaceShip {

    // -------------
    // choice variables
    // -------------
    //
    private String name;
    private String version;
    private int tonnage;
    private Customization custom;             // Custom or Standard Type
    
    /* ---------
    *  Create variables for classes
    --------- */
    public Hull hull;
    public MDrive mDrive;
    public JDrive jDrive;
    public PwrPlant pwrPlant;
    public FTanks fTank;
//    private Bridge bridge = new Bridge();
//    private Computer computer = new Computer();
//    private Sensors sensors = new Sensors();
//    private Weapons[] wPoints;
//    private Systems[] systems;
//    private Rooms[] rooms;

    // -------------
    // calculated variables
    // -------------
    //
    private double costMCr;         // Custom/Standard ship MCr costMCr
    private double cargo;           // Cargo hullSize
    private double useable;      // % of hullSize useable
    private int tl;                 // Tech Level (TL)
    private int ap;                 // Armour Points
    private int hp;                 // AttHull Points
    private int power;              // PwrPlant plant generation
    private int mCostMaint;         // Monthly maintenance costMCr
    private int mCostLifeS;         // Monthly Life Support costMCr
    private int mCostCrewS;         // Monthly Crew Salary costMCr
    private int wpPoints;           // qty of ...
    private String wpPointType;         //   firmpoints ou hardpoints

    // -------------
    // construction variables
    // -------------
    //
    private int usdPwr;
    private double bldCost;
    private double bldTon;
    
    /* ---------
    *  Class Constructor
    --------- */
    public SpaceShip(String name, String version, int tonnage, Customization custom) {
        this.name = name;
        this.version = version;
        this.custom = custom;

        this.hull = new Hull(HullConfiguration.SLND, tonnage);
        this.mDrive = new MDrive(MDriveTypes.Maneuver, 1, tonnage);
        this.jDrive = new JDrive(JDriveTypes.Jump, 2, tonnage);
        this.pwrPlant = new PwrPlant(PwrPlants.Fission, 80);
        this.fTank = new FTanks();

        this.tonnage = this.hull.getHullSize();

        this.costMCr = Math.round(this.bldCost * (isCustomized() ? 1.01 : 0.9) / 1E6);
        this.bldCost = 0;
        this.bldTon = 0;
        this.cargo = 0.0;
        this.useable = 1.0;
        this.tl = 7;
        this.ap = 0;
        this.hp = 0;
        this.power = 0;
        this.mCostMaint = 0;         // Monthly maintenance costMCr
        this.mCostLifeS = 0;         // Monthly Life Support costMCr
        this.mCostCrewS = 0;         // Monthly Crew Salary costMCr
        this.wpPoints = 1;
        this.usdPwr = 0;
    }

    /* ---------
    *  Hull Size
    --------- */
    public int getHullSize() {
        return hull.getHullSize();
    }

    public void setHullSize(int tonnage) {
        this.tonnage = hull.setHullSize(tonnage);
        
        this.jDrive.setHullSize(this.tonnage);
        this.mDrive.setHullSize(this.tonnage);
    }
    
    /* ---------
    *  Object Methods
    --------- */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Customization getType() {
        return custom;
    }

    public void setType(Customization custom) {
        this.custom = custom;
        setCostMCr(this.bldCost); 
    }

    /* ---------
    *  Object Methods
    --------- */
    public void updateTonnage(int ton) {
        this.tonnage = ton;
        
        // calcula cargo hullSize
        this.cargo = this.useable * ton - this.bldTon;
        
        // calcula weapon points
        if (ton >= 100) {
            this.wpPointType = "Hardpoints";
            this.wpPoints = ton / 100;
        } else {
            this.wpPointType = "Firmpoints";
            this.wpPoints = 1 + ((ton - 1) / 35);
        }
    }

    public double getCostMCr() {
        return costMCr;
    }

    public void setCostMCr(double cost) {
        this.costMCr = Math.round(cost * (isCustomized() ? 1.01 : 0.9) / 1E6); 
    }

    public boolean isCustomized() {
        return custom == CUSTOMIZED;
    }


    // -------------
    // object methods
    // -------------
    //
    public void changeCost (double cost) {
        this.bldCost += cost;
        this.setCostMCr(this.bldCost);
    }
    
    public void changePower (int power) {
        this.usdPwr += power;
    }
    
    public void changeTon (double ton) {
        this.bldTon += ton;
        this.cargo -= ton;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpaceShip{name=").append(name);
        sb.append(", version=").append(version);
        sb.append(", tonnage=").append(hull.getHullSize());
        sb.append(", cost=MCr").append(costMCr);
        sb.append(", cargo=").append(cargo);
        sb.append(", tl=").append(tl);
        sb.append(", ap=").append(ap);
        sb.append(", hp=").append(hp);
        sb.append(", power=").append(power);
        sb.append(", mCostMaint=").append(mCostMaint);
        sb.append(", mCostLifeS=").append(mCostLifeS);
        sb.append(", mCostCrewS=").append(mCostCrewS);
        sb.append(", wpPoints=").append(wpPoints);
        sb.append(", wpPointType=").append(wpPointType);
        sb.append(", usdPwr=").append(usdPwr);
        sb.append(", bldCost=").append(bldCost);
        sb.append(", bldTon=").append(bldTon);
        sb.append(", hull=").append(hull);
        sb.append(", mDrive=").append(mDrive);
        sb.append(", jDrive=").append(jDrive);
        sb.append(", pwrPlant=").append(pwrPlant);
//        sb.append(", tanks=").append(tanks);
//        sb.append(", bridge=").append(bridge);
//        sb.append(", computer=").append(computer);
//        sb.append(", sensors=").append(sensors);
//        sb.append(", wPoints=").append(weapons);
//        sb.append(", systems=").append(systems);
//        sb.append(", rooms=").append(rooms);
        sb.append('}');
        return sb.toString();
    }


}
