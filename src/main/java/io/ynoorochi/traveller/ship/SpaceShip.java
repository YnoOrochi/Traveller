/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

import io.ynoorochi.traveller.ship.equip.*;
import io.ynoorochi.traveller.ship.hull.*;
import io.ynoorochi.traveller.ship.space.*;
import io.ynoorochi.traveller.ship.systems.*;
import io.ynoorochi.traveller.ship.weapons.*;

import static io.ynoorochi.traveller.ship.Customization.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.*;
import static io.ynoorochi.traveller.ship.equip.Definitions.*;
import static io.ynoorochi.traveller.ship.equip.Definitions.JDriveTypes.*;
import static io.ynoorochi.traveller.ship.equip.Definitions.MDriveTypes.*;

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
    
    // -------------
    // Class Constructor
    // -------------
    //
    public SpaceShip(String name, String version, int tonnage, Customization custom) {
        this.setName(name);
        this.setVersion(version);
        this.setHullSize(tonnage);
        this.setType(custom);
    }

    /* ---------
    *  Hull Size
    --------- */
    public int getHullSize() {
        return hull.getHullSize();
    }

    public void setHullSize(int size) {
        this.tonnage = hull.setHullSize(size);
        
        this.jDrive.setHullSize(hull.getHullSize());
        this.mDrive.setHullSize(hull.getHullSize());
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
    *  Intialize other components classes
    --------- */
    public Hull hull = new Hull(tonnage, HullType.STRD,
            CoatOptions.NONE, HullConfiguration.SLND,
            false, 0, 0, false, false, false, false, ArmourOptions.TTST);

    public MDrive mDrive = new MDrive(Maneuver, 1, getHullSize());
    public JDrive jDrive = new JDrive(Jump, 2, getHullSize());

    public PwrPlant pwrPlant = new PwrPlant(PwrPlants.Fission, 80);
    
//    private Tanks tanks = new Tanks();
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
    private double costMCr = 0;         // Custom/Standard ship MCr costMCr
    private double cargo = 0;           // Cargo hullSize
    private double useable = 1.00;      // % of hullSize useable
    private int tl = 7;                 // Tech Level (TL)
    private int ap = 0;                 // Armour Points
    private int hp = 0;                 // AttHull Points
    private int power = 0;              // PwrPlant plant generation
    private int mCostMaint = 0;         // Monthly maintenance costMCr
    private int mCostLifeS = 0;         // Monthly Life Support costMCr
    private int mCostCrewS = 0;         // Monthly Crew Salary costMCr
    private int wpPoints = 1;           // qty of ...
    private String wpPointType;         //   firmpoints ou hardpoints
    
    // -------------
    // construction variables
    // -------------
    //
    private int usdPwr = 0;
    private double bldCost = 0;
    private double bldTon = 0;

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
