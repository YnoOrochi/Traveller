/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull;

import static traveller.hull.Definitions.CoatOptions;
import static traveller.hull.Definitions.HullConfiguration;
import static traveller.hull.Definitions.HullType;
import traveller.hull.options.Coating;
import traveller.hull.options.Configuration;
import traveller.hull.options.DoubleHull;
import traveller.hull.options.EAGrid;
import traveller.hull.options.HamsterCase;
import traveller.hull.options.HeatShield;
import traveller.hull.options.NonGHull;
import traveller.hull.options.Options;
import traveller.hull.options.RadShield;
import traveller.hull.options.Type;

/**
 *
 * @author PR3J
 */
public class ClsHull {

    /* ---------
    *  Hull Size
    --------- */
    public void setHullSize(int size) {
        config.setHullSize(size);
    }
    
    public int getHullSize() {
        return config.getHullSize();
    }

    /* ---------
    *  Hull Options
    --------- */
    private Configuration config = new Configuration();
    private Type type = new Type();
    private Coating coat = new Coating();
    private NonGHull nonGHull = new NonGHull();
    private DoubleHull dblHull = new DoubleHull();
    private HamsterCase hmsCase = new HamsterCase();
    private EAGrid eAGrid = new EAGrid();
    private HeatShield hShield = new HeatShield();
    private RadShield rShield = new RadShield();

    public Options[] hullOpt = { 
//      0       1     2     3         4        5        6       7        8
        config, type, coat, nonGHull, dblHull, hmsCase, eAGrid, hShield, rShield
    };
    
    public ClsHull(int size) {
        this.setHullSize(size);
    }
    
    public ClsHull(int size,
                HullType hullType,
                CoatOptions coating,
                HullConfiguration hullConfig,
                boolean nonGravity,
                int doubleHull,
                int hamsterCase,
                boolean eAGrid,
                boolean heatShield,
                boolean radShield) {
        this.setHullSize(size);
        this.type.setType(hullType);
        this.coat.setCoat(coating);
        this.config.setConfig(hullConfig);
        this.nonGHull.setOption(nonGravity);
        this.dblHull.setOption(doubleHull);
        this.hmsCase.setOption(hamsterCase);
        this.eAGrid.setOption(eAGrid);
        this.hShield.setOption(heatShield);
        this.rShield.setOption(radShield);
    }
}
