package ebkr.expansive.energy.annotations.registry.info;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

import java.util.function.Supplier;

public enum ForgeCapability {

    ENERGY(() -> CapabilityEnergy.ENERGY);

    private Supplier<Capability<?>> supplier;

    ForgeCapability(Supplier<Capability<?>> supplier) {
        this.supplier = supplier;
    }

    public Supplier<Capability<?>> get() {
        return supplier;
    }
}
