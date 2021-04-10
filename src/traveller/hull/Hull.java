/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull;

import traveller.hull.Definitions;
import java.util.Arrays;
import traveller.hull.Definitions.Coating;
import traveller.hull.Definitions.HullConfiguration;
import traveller.hull.Definitions.HullType;
import traveller.hull.Definitions.Streamlined;

/**
 *
 * @author PR3J
 */
public class Hull {
    // --------------
    // Constants
    // --------------
    private final int MIN_HULL = 10;
    private final int NONG_MAX = 500000;
    
    // --------------
    // Hull Size
    // --------------
    private int size;

    public int hullUpdate(int size) {
        this.size = (size > MIN_HULL) ? size : MIN_HULL;
        if (getNonGHull() && this.size > NONG_MAX) this.size = NONG_MAX;
        
        this.changeHullType(hullType);
        this.changeHullConfig(hullConfig);
        this.changeCoating(coating);
        this.setEAGrid(eAGrid);
        this.setHeatShield(hShield);
        this.setRadShield(rShield);
        this.setNonGHull(nonGHull);
        this.setDoubleHull(outerHull);
        this.setHamsterCase(hmsSize);
        test("Change Size:" + this.size);
        return this.size;
    }

    // --------------
    // Hull Type
    // --------------
    private double typCostModf;
    private double typHPModf;
    private HullType hullType = HullType.STRD;

    public void changeHullType(HullType type) {
        this.hullType = type;
        this.typCostModf = type.getCostModf();
        this.typHPModf = type.getHPModf();
    }

    public HullType getHullType() {
        return this.hullType;
    }
    
    // --------------
    // Hull Configuration
    // --------------
    private int cfgHullCost;
    private double cfgCostModf;
    private double cfgHPModf;
    private double cfgUseable;
    private Streamlined streamlined;
    private HullConfiguration hullConfig = HullConfiguration.STRD;

    public void changeHullConfig(HullConfiguration config) {
        this.hullConfig = config;
        this.streamlined = config.getStrLined();
        this.cfgHullCost = config.getHullCost();
        this.cfgCostModf = config.getCostModf();
        this.cfgHPModf = config.getHPModf();
        this.cfgUseable = config.getUseable();
    }

    public HullConfiguration getHullConfig() {
        return this.hullConfig;
    }
    
    // --------------
    // Coating
    // --------------
    private Definitions.Coating coating = Definitions.Coating.NONE;
    
    public void changeCoating(Definitions.Coating coating) {
        this.coating = coating;
    }
    
    public Definitions.Coating getCoating() {
        return this.coating;
    }

    // --------------
    // Emissions Absortion Grid
    // --------------
    private int eagTL;
    private double eagUsedTon;
    private int eagCost;
    private boolean eAGrid = false;

    public void setEAGrid(boolean grid) {
        this.eAGrid = grid;
        if (grid) {
            eagTL = 8;
            eagUsedTon = 0.02 * this.size;
            eagCost = 40000;
        } else {
            eagTL = 0;
            eagUsedTon = 0;
            eagCost = 0;
        }
    }

    public boolean getEAGrid() {
        return this.eAGrid;
    }
    
    // --------------
    // Heat Shield
    // --------------
    private int hshTL;
    private int hshCost;
    private boolean hShield = false;

    public void setHeatShield(boolean shield) {
        this.hShield = shield;
        if (shield) {
            hshTL = 6;
            hshCost = 100000;
        } else {
            hshTL = 0;
            hshCost = 0;
        }
    }
    
    public boolean getHeatShield() {
        return this.hShield;
    }
    
    // --------------
    // Radiation Shield
    // --------------
    private int radTL;
    private int radCost;
    private boolean rShield = false;

    public void setRadShield(boolean shield) {
        this.rShield = shield;
        if (shield) {
            radTL = 7;
            radCost = 25000;
        } else {
            radTL = 0;
            radCost = 0;
        }
    }
    
    public boolean getRadShield() {
        return this.rShield;
    }

    // --------------
    // Non-gravity Hull
    //  cost Cr25000 per ton, maximum size of 500,000 tons
    // --------------
    private final int NONG_COST = 25000;
    private boolean nonGHull = false;
    
    public void setNonGHull(boolean nonGHull) {
        this.nonGHull = nonGHull;
    }
    
    public boolean getNonGHull() {
        return this.nonGHull;
    }
    
    // --------------
    // Double Hull
    //  Min 60T, uses 0.1 ton * outer hull and the outer hull cost 1% more
    // --------------
    private double dbUsedTon;
    private int outerHull;              // min 60T
    private double dbCostModf;
    private boolean doubleHull = false;

    public boolean setDoubleHull(int size) {
        this.outerHull = size;
        if (size < 60 || size > 0.9 * this.size) {
            this.doubleHull = false;
            this.dbUsedTon = 0;
            this.dbCostModf = 0;
        } else {
            this.doubleHull = true;
            this.dbUsedTon = 0.1 * size;
            this.dbCostModf = 0.01 * (int) (size / this.size);
        }
        return this.doubleHull;
    }
    
    public boolean getDoubleHull() {
        return this.doubleHull;
    }
    
    // --------------
    // Hamster Case
    //  Uses 0.1 ton * cage tonnage and it costs 2% more for every 1% of Hull
    // --------------
    private double hmsUsedTon;
    private int hmsSize;                // in Ton, 0-90% of the Hull
    private double hmsCostModf;
    private boolean hamsterCase = false;

    public boolean setHamsterCase(int size) {
        this.hmsSize = size;
        if (size <= 0 || size > 0.9 * this.size) {
            this.hamsterCase = false;
            this.hmsCostModf = 0;
            this.hmsUsedTon = 0;
        } else {
            this.hamsterCase = true;
            this.hmsCostModf = 0.02 * (int) (size / this.size);
            this.hmsUsedTon = 0.1 * size;
        }
        return this.hamsterCase;
    }
    
    public boolean getHamsterCase() {
        return this.hamsterCase;
    }

        public int getHamsterSize() {
        return this.hmsSize;
    }

    // --------------
    // Breakaway Hull
    // --------------
    private boolean bAwayHull = false;
    
    // --------------
    // Get Methods
    // --------------
    public double getHullCost() {
        double hCost = (this.nonGHull) ? NONG_COST : this.cfgHullCost;
        double hModf = 1 + this.typCostModf + this.cfgCostModf + 
                       this.hmsCostModf + this.dbCostModf;
        double oCost = this.eagCost + this.hshCost + 
                       this.radCost + this.getCoating().getCoatCost();

        return this.size * ((hCost * hModf) + oCost);
    }
    
    public int getHP() {
        int hp = (int) (this.size / (
                        (this.size <= 25000) ? 2.5 : (
                            (this.size <= 100000) ? 2 : 1.5)));
        return (int) ((1 + typHPModf + cfgHPModf) * hp);
    }
    
    public int getTL() {
        return maximoTL( this.eagTL, this.hshTL, this.radTL, 
                         this.getCoating().getCoatTL());
    }
    
    public int getUsedTon() {
        return (int) Math.round(this.eagUsedTon + 
                                this.hmsUsedTon + 
                                this.dbUsedTon);
    }
    
    public double getUseable() {
        return this.cfgUseable;
    }
    
    public Streamlined getStreamlined() {
        return this.streamlined;
    }
    
    // --------------
    // Other Methods
    // --------------
    
    public Hull(int size) {
        this.hullUpdate(size);
    }
    
    public Hull(int size,
                HullType hullType,
                Coating coating,
                HullConfiguration hullConfig,
                boolean nonGravity,
                int doubleHull,
                int hamsterCase,
                boolean eAGrid,
                boolean heatShield,
                boolean radShield) {
        this.hullUpdate(size);
        this.changeHullType(hullType);
        this.changeCoating(coating);
        this.changeHullConfig(hullConfig);
        this.setNonGHull(nonGravity);
        this.setDoubleHull(doubleHull);
        this.setHamsterCase(hamsterCase);
        this.setEAGrid(eAGrid);
        this.setHeatShield(heatShield);
        this.setRadShield(radShield);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hull{tl=").append(getTL());
        sb.append(", size=").append(size);
        sb.append(", usedTon=").append(getUsedTon());
        sb.append(", ").append(getHullType());
        sb.append(", ").append(getHullConfig());
        sb.append(", hullCost=").append(getHullCost());
        sb.append(", hp=").append(getHP());
        sb.append(", ").append(getCoating());
        sb.append(", EAGrid=").append(getEAGrid());
        sb.append(", HeatShield=").append(getHeatShield());
        sb.append(", RadShield=").append(getRadShield());
        sb.append('}');
        return sb.toString();
    }
    
    public void test(String text) {
        System.out.println(text);
    }
    
    private int maximoTL(int... tl) {
        return Arrays.stream(tl).max().orElse(0);
//        if ( tl.length == 0 ) {
//            return 0;
//        } else {
//            var max = tl[0];
//            for (int i = 1; i < tl.length; i++) {
//                max = Math.max(max, tl[i]);
//            }
//            return max;
//        }
    }
}

