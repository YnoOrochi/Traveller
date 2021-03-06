/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.systems.ConfigurablePod;

/**
 *
 * @author PR3J
 */
public class Spaces extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public Spaces() {
        otherItems();
    }
    
    /* ---------
     *  Add all Available Spaces for test
    --------- */
    private void otherItems() {
        /* Passenger Spaces */
        addItem(new SpaceItems(Definitions.RoomType.LBERTH, 0));
        addItem(new SpaceItems(Definitions.RoomType.EBERTH, 0));
        addItem(new SpaceItems(Definitions.RoomType.CABINS, 0));
        addItem(new SpaceItems(Definitions.RoomType.SROOMS, 0));
        addItem(new SpaceItems(Definitions.RoomType.DROOMS, 0));
        addItem(new SpaceItems(Definitions.RoomType.HROOMS, 0));
        addItem(new SpaceItems(Definitions.RoomType.LROOMS, 0));
        addItem(new SpaceItems(Definitions.RoomType.PSYONS, 0));
        addItem(new SpaceItems(Definitions.RoomType.ABENCH, 0));
        addItem(new SpaceItems(Definitions.RoomType.ASEATS, 0));
        addItem(new SpaceItems(Definitions.RoomType.BARRCK, 0));
        addItem(new SpaceItems(Definitions.RoomType.BRIG06, 0));
        /* Docks */
        addItem(new SpaceItems(Definitions.RoomType.DOCKSP, 0));
        addItem(new SpaceItems(Definitions.RoomType.DOCKSP, 0));
        addItem(new SpaceItems(Definitions.RoomType.HANGAR, 0));
        /* Other Spaces */
        addItem(new SpaceItems(Definitions.RoomType.ARMORY, 0));
        addItem(new SpaceItems(Definitions.RoomType.BIOSPH, 0));
        addItem(new SpaceItems(Definitions.RoomType.BRIEFG, 0));
        addItem(new SpaceItems(Definitions.RoomType.COMMON, 0));
        addItem(new SpaceItems(Definitions.RoomType.CNCEAL, 0));
        addItem(new SpaceItems(Definitions.RoomType.CTDECK, 0));
        addItem(new SpaceItems(Definitions.RoomType.GAMING, 0));
        addItem(new SpaceItems(Definitions.RoomType.GRAVSC, 0));
        addItem(new SpaceItems(Definitions.RoomType.LABTRY, 0));
        addItem(new SpaceItems(Definitions.RoomType.LBRARY, 0));
        addItem(new SpaceItems(Definitions.RoomType.MEDBAY, 0));
        addItem(new SpaceItems(Definitions.RoomType.MENVSP, 0));
        addItem(new SpaceItems(Definitions.RoomType.RECOVR, 0));
        addItem(new SpaceItems(Definitions.RoomType.STABLE, 0));
        addItem(new SpaceItems(Definitions.RoomType.STUDIO, 0));
        addItem(new SpaceItems(Definitions.RoomType.TRAINF, 0));
        addItem(new SpaceItems(Definitions.RoomType.UNREPS, 0));
        addItem(new SpaceItems(Definitions.RoomType.VAULTS, 0));
        addItem(new SpaceItems(Definitions.RoomType.WRKSHP, 0));
    }

    /* ---------
    *  TotalLifeSupport
    --------- */
    public int getLifeSupport() { 
        int aux = 0;
        SpaceItems sItem;
        for (var obj : getItems() ) { 
            sItem = (SpaceItems) obj;
            aux += sItem.getLifeSupport(); }
        return aux;
    }

    /* ---------
    *  Total Passengers
    --------- */
    public int getPassengers() { 
        int aux = 0;
        SpaceItems sItem;
        for (var obj : getItems() ) { 
            sItem = (SpaceItems) obj;
            aux += sItem.getPassengers(); }
        return aux;
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
        sb.append(", Life Support=").append(getLifeSupport());
        sb.append(", Passengers=").append(getPassengers());
        sb.append(", Cost=").append(getCost());
        sb.append("}");
        for (var obj : getItems()) 
            sb.append("\n    ").append(obj.toString());
        return sb.toString();
    }
}
