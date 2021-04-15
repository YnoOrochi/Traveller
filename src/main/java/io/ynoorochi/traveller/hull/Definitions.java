/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.hull;

import static io.ynoorochi.traveller.hull.Definitions.Streamlined.*;

/**
 *
 * @author PR3J
 */
public class Definitions {
    /* ---------
    *  Constants
    --------- */
    private static final int BSIC_COST = 50000;
    private static final int PLNT_COST = 4000;
    
    /* ---------
    *  Armour
    --------- */
    public enum ArmourOptions {
        NONE("No Armour", 0, 0, 0),
        TTST("Titanium Steel", 7, 0.025, 0.025),        // max: TL or 9 (less)
        CRIR("Crystalion", 10, 0.0125, 0.05),           // max: TL or 13 (less)
        BDSD("Bonded Superdense", 14, 0.008, 0.08),     // max: TL
        MLBD("Molecular Bonded", 16, 0.005, 0.15);      // max: TL + 4
        
        private final String armourType;
        private final int armourBaseTL;
        private final double armourWeight;
        private final double armourCostModf;
        
        private ArmourOptions(String armourType, int armourBaseTL, 
                double armourWeight, double armourCostModf) {
            this.armourType = armourType;
            this.armourBaseTL = armourBaseTL;
            this.armourWeight = armourWeight;
            this.armourCostModf = armourCostModf;
        }
        
        public String getArmourType() {
            return this.armourType;
        }
        
        public int getArmourBaseTL() {
            return this.armourBaseTL;
        }
        
        public double getArmourWeight() {
            return this.armourWeight;
        }
        
        public double getArmourCostModf() {
            return this.armourCostModf;
        }
    }
    
    /* ---------
    *  CoatOptions - Reflec, Stealth or Superior Stealth
    --------- */
    public enum CoatOptions {
        NONE("None", 0, 0, "Standard hull"),
        RFLC("Reflec", 10, 100000, " "),
        STTH("Stealth", 10, 100000, " "),
        SSTH("Superior Stealth", 12, 1000000, " ");
        
        private final String coatType;
        private final int coatTL;
        private final int coatCost;
        private final String text;

        private CoatOptions(String coating, int coatTL, int coatCost, String text) {
            this.coatType = coating;
            this.coatTL = coatTL;
            this.coatCost = coatCost;
            this.text = text;
        }
        
        public String getCoatType() {
            return this.coatType;
        }
        
        public int getCoatTL() {
            return this.coatTL;
        }
        
        public int getCoatCost() {
            return this.coatCost;
        }
        
        public String getCoatText() {
            return this.text;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Coating{").append(coatType);
            sb.append('}');
            return sb.toString();
        }
    }

    /* ---------
    *  Hull Configurations
    --------- */
    public enum HullConfiguration {
        STRD("Standard", Partial, 0, 0, BSIC_COST, 1, " "),
        SLND("Streamlined", Yes, 0, 0.2, BSIC_COST, 1, " "),
        SPHR("Sphere", Partial, 0, -0.2, BSIC_COST, 1, " "),
        CLST("Close Structure", Partial, +0.1, -0.1, BSIC_COST, 1, " "),
        DIST("Dispersed Structure", No, -0.1, -0.5, BSIC_COST, 1, " "),
        PNTD("Planetoid", No, +0.25, 0, PLNT_COST, 0.85, " "),
        BFPN("Buffered Planetoid", No, +0.5, 0, PLNT_COST, 0.65, " ");
        
        private final String configuration;
        private final Streamlined streamlined;
        private final double hpModf;
        private final double costModf;
        private final int hullCost;
        private final double useable;
        private final String text;
        
        private HullConfiguration(String config, Streamlined strlined, 
                double hpModf, double costModf, int hullCost,
                double useable, String text) {
            this.configuration = config;
            this.streamlined = strlined;
            this.hpModf = hpModf;
            this.costModf = costModf;
            this.hullCost = hullCost;
            this.useable = useable;
            this.text = text;
        };
        
        public String getConfig() {
            return this.configuration;
        }
        
        public Streamlined getStrLined() {
            return this.streamlined;
        }
        
        public int getHullCost() {
            return this.hullCost;
        }
        
        public double getCostModf() {
            return this.costModf;
        }
        
        public double getHPModf() {
            return this.hpModf;
        }
        
        public double getUseable() {
            return this.useable;
        }

        public String getText() {
            return this.text;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HullConfiguration{").append(configuration);
            sb.append(", streamlined=").append(streamlined);
            sb.append('}');
            return sb.toString();
        }
    }

    /* ---------
    *  Hull Types
    --------- */
    public enum HullType {
        LGHT("Light", -0.25, -0.10), 
        STRD("Standard", 0, 0), 
        RFCD("Reinforced", +0.50, +0.10);
        
        private final String hullType;
        private final double costModf;
        private final double hpModf;
        
        private HullType(String hullType, double costModf, double hpModf) {
            this.hullType = hullType;
            this.costModf = costModf;
            this.hpModf = hpModf;
        }
        
        public String getType() {
            return this.hullType;
        }
        
        public double getCostModf() {
            return this.costModf;
        }
        
        public double getHPModf() {
            return this.hpModf;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HullType{").append(hullType);
            sb.append('}');
            return sb.toString();
        }
    }

    /* ---------
    *  Streamlined
    --------- */
    public enum Streamlined {
        Yes,
        Partial,
        No
    }
}
