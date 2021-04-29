/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer.software;

/**
 *
 * @author PR3J
 */
public class Software {
    /* ---------
     *  Constructor
    --------- */
    public Software(int max, int jmp) {
        setMaxBW(max);
        setJump(jmp);
        initialize();
    }

    /* ---------
    *  Default Softwares
    --------- */
    public JumpControl jCtrl = new JumpControl();
    public Maneouvre mnvre = new Maneouvre();
    public Library lib = new Library();

    /* ---------
    *  Other Softwares
    --------- */
    public Evade evade = new Evade();
    public FireControl fCtrl = new FireControl();
    public AdvFireControl advFC = new AdvFireControl();
    public LaunchSolution launch = new LaunchSolution();
    public AntiHijack aHjck = new AntiHijack();
    public AutoRepair aRpr = new AutoRepair();
    public BattleSystem bSyst = new BattleSystem();
    public Intellect intel = new Intellect();
    public ConsciousIntel cnInt = new ConsciousIntel();
    public EletronicWar eWar = new EletronicWar();
    public BroadSpectrumEW bsEW = new BroadSpectrumEW();
    public PointDefense pDef = new PointDefense();
    public ScreenOptimizer screen = new ScreenOptimizer();
    public VirtualCrew vCrew = new VirtualCrew();
    public VirtualGunner vGuns = new VirtualGunner();
    public VirtualMining vMine = new VirtualMining();

    /* ---------
    *  Softwares list
    --------- */
    private final BaseSW[] softwares = {
        jCtrl, mnvre, lib, evade, fCtrl, advFC, launch, aHjck, aRpr, bSyst, 
        intel, cnInt, eWar, bsEW, pDef, screen, vCrew, vGuns, vMine
    };
    
    public BaseSW[] getSoftwares() {
        return this.softwares;
    }
    
    /* ---------
     *  Attribute MaxBandwith Allowed
    --------- */
    private int maxBW = 5;
    private int getMaxBW() { return this.maxBW; }
    public void setMaxBW(int max) { this.maxBW = max; }

    /* ---------
     *  Attribute Jump Drive Rating
    --------- */
    private int jump = 1;
    private int getJump() { return this.jump; }
    public void setJump(int jmp) { this.jump = jmp; }

    /* ---------
    *  Initialize default parameters
    --------- */
    private void initialize() {
        jCtrl.setVersion(getJump());
        for (var soft : getSoftwares()) soft.setMaxBW(getMaxBW());
    }

    /* ---------
    *  Bandwidth
    --------- */
    public int getTotBW() { 
        int bw = 0;
        for (var soft : getSoftwares() ) {
            bw += soft.getBW();
        }
        return bw;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var soft : getSoftwares() ) {
            tl = Math.max(tl, soft.getTL());
        }
        return tl;
    }

    /* ---------
    *  Bandwidth
    --------- */
    public int getCost() { 
        int cost = 0;
        for (var soft : getSoftwares() ) {
            cost += soft.getCost();
        }
        return cost;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Total Bandwidth=").append(getTotBW());
        sb.append("}\n");
        for (var soft : getSoftwares()) 
            sb.append("    ").append(soft.toString()).append("\n");
        return sb.toString();
    }
}
