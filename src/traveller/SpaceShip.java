/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller;

//import traveller.hull.AttHull;
import traveller.hull.ClsHull;
import traveller.hull.Definitions.*;
import static traveller.Customization.*;

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
    // calculated variables
    // -------------
    //
    private double costMCr = 0;         // Custom/Standard ship MCr costMCr
    private double cargo = 0;           // Cargo tonnage
    private double useable = 1.00;      // % of tonnage useable
    private int tl = 7;                 // Tech Level (TL)
    private int ap = 0;                 // Armour Points
    private int hp = 0;                 // AttHull Points
    private int power = 0;              // Power plant generation
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

    // -------------
    // other component classes
    // -------------
    //
//    public AttHull aHull = new AttHull(tonnage, HullType.STRD, CoatOptions.NONE, HullConfiguration.SLND, true, 60, 20, true, true, true);
    
    public ClsHull cHull = new ClsHull(tonnage, HullType.RFCD, 
            CoatOptions.STTH, HullConfiguration.PNTD, 
            true, 60, 20, true, true, true, ArmourOptions.TTST);
    
    private MDrive mDrive = new MDrive();
    private JDrive jDrive = new JDrive();
    private PwrPlant pwrPlant = new PwrPlant();
    private Tanks tanks = new Tanks();
    private Bridge bridge = new Bridge();
    private Computer computer = new Computer();
    private Sensors sensors = new Sensors();
    private WeaponPoints[] wPoints;
    private Systems[] systems;
    private Rooms[] rooms;

    // -------------
    // class alternative constructors
    // -------------
    //
    public SpaceShip(String name, String version, int tonnage, Customization custom) {
        setName(name);
        setVersion(version);
        setTonnage(tonnage);
        setType(custom);
    }

    // -------------
    // object constructors
    // -------------
    //
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

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int ton) {
        this.tonnage = ton;
        
//        this.aHull.hullUpdate(ton);
        this.cHull.setHullSize(ton);
        
        // calcula cargo tonnage
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

    public Customization getType() {
        return custom;
    }

    public void setType(Customization custom) {
        this.custom = custom;
        setCostMCr(this.bldCost); 
    }

    public double getCostMCr() {
        return costMCr;
    }

    public void setCostMCr(double cost) {
        this.costMCr = cRound(cost * (isCustomized() ? 1.01 : 0.9) / 1E6, 2); 
    }

    public boolean isCustomized() {
        return custom == CUSTOMIZED;
    }


    // -------------
    // aux methods
    // -------------
    //
    public double cRound (double number, int dec) {
        return Math.round(number * Math.pow(10, dec)) / Math.pow(10, dec);
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
        sb.append(", tonnage=").append(tonnage);
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
        sb.append(", hull=").append(cHull);
        sb.append(", mDrive=").append(mDrive);
        sb.append(", jDrive=").append(jDrive);
        sb.append(", pwrPlant=").append(pwrPlant);
        sb.append(", tanks=").append(tanks);
        sb.append(", bridge=").append(bridge);
        sb.append(", computer=").append(computer);
        sb.append(", sensors=").append(sensors);
        sb.append(", wPoints=").append(wPoints);
        sb.append(", systems=").append(systems);
        sb.append(", rooms=").append(rooms);
        sb.append('}');
        return sb.toString();
    }


}
