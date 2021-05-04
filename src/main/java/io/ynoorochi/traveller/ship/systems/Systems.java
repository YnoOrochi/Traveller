/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.Streamlined;
import io.ynoorochi.traveller.ship.systems.Airlocks.AirlockType;
import io.ynoorochi.traveller.ship.systems.AtmosphereKit.AtmoKitType;
import io.ynoorochi.traveller.ship.systems.DockClamps.ClampType;
import io.ynoorochi.traveller.ship.systems.Drones.DroneType;
import io.ynoorochi.traveller.ship.systems.ForcedLink.FLinkType;
import io.ynoorochi.traveller.ship.systems.GrapArms.GrapArmType;
import io.ynoorochi.traveller.ship.systems.CargoLoadBelt.LoadBeltType;
import io.ynoorochi.traveller.ship.systems.ReentrySystem.ReentryType;
import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class Systems {
    /* ---------
     *  Constructor
    --------- */
    public Systems(int ton) {
        setHullSize(ton);
        otherItems();
    }

    public Systems(Streamlined cfg, int ton) {
        this(ton);
        this.streamlined = cfg;
   }
    
    /* ---------
     *  Attributes
    --------- */
    private Streamlined streamlined;

    /* ---------
     *  Array Manipulation
    --------- */
    private Items[] itemList = {};
    
    public void addItem(Items item) {
        itemList = Arrays.copyOf(itemList, itemList.length + 1);
        itemList[itemList.length - 1] = item;
    }
    
    public void delItem(Items item) {
        int pos = Arrays.binarySearch(itemList, item);
        if (pos >= 0) {
            if (itemList.length > pos + 1)
                for (int i=pos; i<itemList.length - 1; i++) {
                    itemList[i] = itemList[i+1];
                }
            itemList = Arrays.copyOf(itemList, itemList.length - 1);
        }
    }

    public Items[] getItems() { return itemList; }

    /* ---------
     * Hull Size
    --------- */
    private int hullSize;
    public int getHullSize() { return this.hullSize; }
    public void setHullSize(int hullSize) { this.hullSize = hullSize; }

    /* ---------
     * Create all items
    --------- */
    private void otherItems() {
        addItem(new Aerofins(getHullSize()));
        addItem(new Airlocks(AirlockType.ADDLCK, 1));
        addItem(new Airlocks(AirlockType.TRAP07, 1));
        addItem(new Airlocks(AirlockType.TRAP08, 1));
        addItem(new Airlocks(AirlockType.TRAP10, 1));
        addItem(new Airlocks(AirlockType.TRAP12, 1));
        addItem(new AtmosphereKit(AtmoKitType.DM1));
        addItem(new BreachTube());
        addItem(new CargoCrane());
        addItem(new CargoExtMount(streamlined, 1));
        addItem(new CargoJumpNet(1));
        addItem(new CargoLoadBelt(LoadBeltType.TL07));
        addItem(new CargoRetrieval());
        addItem(new CargoScoop());
        addItem(new CargoStorageNet(1));
        addItem(new DockClamps(ClampType.I, 1));
        addItem(new DockClamps(ClampType.II, 1));
        addItem(new DockClamps(ClampType.III, 1));
        addItem(new DockClamps(ClampType.IV, 1));
        addItem(new DockClamps(ClampType.V, 1));
        addItem(new Drones(DroneType.PROBED, 1));
        addItem(new Drones(DroneType.ADVPRB, 1));
        addItem(new Drones(DroneType.CARGOD, 1));
        addItem(new Drones(DroneType.MINING, 1));
        addItem(new Drones(DroneType.REPAIR, 1));
        addItem(new ForcedLink(FLinkType.TL07));
        addItem(new GrapArms(GrapArmType.NORML, 1));
        addItem(new GrapArms(GrapArmType.HEAVY, 1));
        addItem(new HolographicHull(getHullSize()));
        addItem(new LaunchTubes(1, 100));
        addItem(new ReentrySystem(ReentryType.CAP08, 1));
        addItem(new ReentrySystem(ReentryType.CAP10, 1));
        addItem(new ReentrySystem(ReentryType.CAP14, 1));
        addItem(new ReentrySystem(ReentryType.POD, 1));
        addItem(new TowCable(getHullSize()));
    }

    /* ---------
    *  Best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var obj : getItems() ) {
            tl = Math.max(tl, obj.getTL());
        }
        return tl;
    }

    /* ---------
    *  Total Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getWeight();
        }
        return aux;
    }

    /* ---------
    *  Total Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getPower();
        }
        return aux;
    }

    /* ---------
    *  Total Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getCost();
        }
        return aux;
    }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() {
        return this.getClass().getSimpleName();
    }
    
    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var obj : getItems()) 
            sb.append("    ").append(obj.toString()).append("\n");
        return sb.toString();
    }
}
