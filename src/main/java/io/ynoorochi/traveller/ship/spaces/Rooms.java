/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces;

import io.ynoorochi.traveller.ship.spaces.Definitions.RoomType;

/**
 *
 * @author PR3J
 */
public class Rooms {
    /* ---------
     *  Passenger Rooms
    --------- */
    public ShipSpaces lBerth = new ShipSpaces(RoomType.LBERTH, 0);
    public ShipSpaces eBerth = new ShipSpaces(RoomType.EBERTH, 0);
    public ShipSpaces cabins = new ShipSpaces(RoomType.CABINS, 0);
    public ShipSpaces sRooms = new ShipSpaces(RoomType.SROOMS, 0);
    public ShipSpaces dRooms = new ShipSpaces(RoomType.DROOMS, 0);
    public ShipSpaces hRooms = new ShipSpaces(RoomType.HROOMS, 0);
    public ShipSpaces lRooms = new ShipSpaces(RoomType.LROOMS, 0);
    public ShipSpaces psyons = new ShipSpaces(RoomType.PSYONS, 0);
    public ShipSpaces aBench = new ShipSpaces(RoomType.ABENCH, 0);
    public ShipSpaces aSeats = new ShipSpaces(RoomType.ASEATS, 0);
    public ShipSpaces brrack = new ShipSpaces(RoomType.BARRCK, 0);
    public ShipSpaces brig   = new ShipSpaces(RoomType.BRIG06, 0);
    
    /* ---------
     *  Other Rooms
    --------- */
    public ShipSpaces armory = new ShipSpaces(RoomType.ARMORY, 0);
    public ShipSpaces bSphre = new ShipSpaces(RoomType.BIOSPH, 0);
    public ShipSpaces briefg = new ShipSpaces(RoomType.BRIEFG, 0);
    public ShipSpaces common = new ShipSpaces(RoomType.COMMON, 0);
    public ShipSpaces cnceal = new ShipSpaces(RoomType.CNCEAL, 0);
    public ShipSpaces ctDeck = new ShipSpaces(RoomType.CTDECK, 0);
    public ShipSpaces gaming = new ShipSpaces(RoomType.GAMING, 0);
    public ShipSpaces gravSc = new ShipSpaces(RoomType.GRAVSC, 0);
    public ShipSpaces labtry = new ShipSpaces(RoomType.LABTRY, 0);
    public ShipSpaces lbrary = new ShipSpaces(RoomType.LBRARY, 0);
    public ShipSpaces medBay = new ShipSpaces(RoomType.MEDBAY, 0);
    public ShipSpaces mEnvro = new ShipSpaces(RoomType.MENVSP, 0);
    public ShipSpaces recovr = new ShipSpaces(RoomType.RECOVR, 0);
    public ShipSpaces stable = new ShipSpaces(RoomType.STABLE, 0);
    public ShipSpaces studio = new ShipSpaces(RoomType.STUDIO, 0);
    public ShipSpaces trainF = new ShipSpaces(RoomType.TRAINF, 0);
    public ShipSpaces unrepS = new ShipSpaces(RoomType.UNREPS, 0);
    public ShipSpaces vaults = new ShipSpaces(RoomType.VAULTS, 0);
    public ShipSpaces wrkshp = new ShipSpaces(RoomType.WRKSHP, 0);
    
    /* ---------
    *  Rooms list
    --------- */
    private final ShipSpaces[] rooms = {
        lBerth, eBerth, cabins, sRooms, dRooms, hRooms, lRooms, common,
        aBench, aSeats, brrack, brig, mEnvro, bSphre, stable, armory,
        briefg, cnceal, ctDeck, gaming, gravSc, labtry, lbrary, medBay,
        psyons, recovr, studio, trainF, unrepS, vaults, wrkshp
    };
    
    public ShipSpaces[] getRooms() {
        return this.rooms;
    }
    
    /* ---------
    *  Rooms best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var obj : getRooms() ) {
            tl = Math.max(tl, obj.getTL());
        }
        return tl;
    }

    /* ---------
    *  Total Rooms Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var obj : getRooms() ) {
            aux += obj.getWeight();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var obj : getRooms() ) {
            aux += obj.getPower();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Life Support
    --------- */
    public int getLifeSupport() { 
        int aux = 0;
        for (var obj : getRooms() ) {
            aux += obj.getLifeSupport();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public int getPassengers() { 
        int aux = 0;
        for (var obj : getRooms() ) {
            aux += obj.getPassengers();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var obj : getRooms() ) {
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
        sb.append(", Power=").append(getPower());
        sb.append(", Life Support=").append(getLifeSupport());
        sb.append(", Passengers=").append(getPassengers());
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var room : getRooms()) 
            sb.append("    ").append(room.toString()).append("\n");
        return sb.toString();
    }
}
