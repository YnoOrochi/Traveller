/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull;

import static traveller.hull.Definitions.Streamlined.*;

/**
 *
 * @author PR3J
 */
public class Definitions {
    // --------------
    // Constants
    // --------------
    private static final int BSIC_COST = 50000;
    private static final int PLNT_COST = 4000;
    
    // ----------------
    // Hull Types
    // ----------------
    public enum Streamlined {
        Yes,
        Partial,
        No
    }
    
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
    
    // ----------------
    // Hull Configurations
    // ----------------
    public enum HullConfiguration {
        STRD("Standard", Partial, 0, 0, BSIC_COST, 1, " "),
        SLND("Streamlined", Yes, 0, 0.2, BSIC_COST, 1, " "),
        SPHR("Sphere", Partial, 0, -0.2, BSIC_COST, 1, " "),
        CLST("Close Structure", Partial, +0.1, -0.1, BSIC_COST, 1, " "),
        DIST("Dispersed Structure", No, -0.1, -0.5, BSIC_COST, 1, " "),
        PNTD("Planetoid", No, +0.25, 0, PLNT_COST, 0.85, " "),
        BPTD("Buffered Planetoid", No, +0.5, 0, PLNT_COST, 0.65, " ");
        
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

    // ----------------
    // Coating - Reflec, Stealth or Superior Stealth
    // ----------------
    public enum Coating {
        NONE("None", 0, 0, "Standard hull"),
        RFLC("Reflec", 10, 100000, " "),
        STTH("Stealth", 10, 100000, " "),
        SSTH("Superior Stealth", 12, 1000000, " ");
        
        private final String coating;
        private final int coatTL;
        private final int coatCost;
        private final String text;

        private Coating(String coating, int coatTL, int coatCost, String text) {
            this.coating = coating;
            this.coatTL = coatTL;
            this.coatCost = coatCost;
            this.text = text;
        }
        
        public String getCoating() {
            return this.coating;
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
            sb.append("Coating{").append(coating);
            sb.append('}');
            return sb.toString();
        }
    }
}
