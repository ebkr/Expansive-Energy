package ebkr.expansive.energy.mod.common.capabilities;

import net.minecraftforge.energy.EnergyStorage;

public class ExpansiveEnergyStorage extends EnergyStorage {

    public ExpansiveEnergyStorage(int capacity) {
        super(capacity);
    }

    public ExpansiveEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public ExpansiveEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public ExpansiveEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    public void setStorage(int energy) {
        this.energy = energy;
    }
}
