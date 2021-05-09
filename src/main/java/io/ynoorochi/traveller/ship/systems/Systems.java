/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.hull.Definitions.HullConfiguration;
import io.ynoorochi.traveller.ship.systems.Airlocks.AirlockType;
import io.ynoorochi.traveller.ship.systems.AtmosphereKit.AtmoKitType;
import io.ynoorochi.traveller.ship.systems.DockClamps.ClampType;
import io.ynoorochi.traveller.ship.systems.Drones.DroneType;
import io.ynoorochi.traveller.ship.systems.ForcedLink.FLinkType;
import io.ynoorochi.traveller.ship.systems.GrapArms.GrapArmType;
import io.ynoorochi.traveller.ship.systems.CargoLoadBelt.LoadBeltType;
import io.ynoorochi.traveller.ship.systems.ReentrySystem.ReentryType;

/**
 *
 * @author PR3J
 */
public class Systems extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public Systems(HullConfiguration cfg, int ton) {
        this.config = cfg;
        setHullSize(ton);
        
        otherItems();
   }
    
    /* ---------
     *  Attributes
    --------- */
    private HullConfiguration config;

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
        addItem(new CargoExtMount(config, 1));
        addItem(new CargoJumpNet(1));
        addItem(new CargoLoadBelt(LoadBeltType.TL07));
        addItem(new CargoRetrieval());
        addItem(new CargoScoop());
        addItem(new CargoStorageNet(1));
        addItem(new ConfigurablePod());
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
        addItem(new FuelProcessor(1));
        addItem(new FuelScoop(config));
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
}
