package ebkr.expansive.energy.mod.common.tile;

import ebkr.expansive.energy.annotations.registry.info.RegistryName;
import ebkr.expansive.energy.annotations.registry.info.ValidBlocksForTile;
import ebkr.expansive.energy.annotations.registry.type.IsTile;
import ebkr.expansive.energy.mod.common.block.EnergyRouterBlock;
import ebkr.expansive.energy.mod.common.capabilities.ExpansiveEnergyStorage;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@IsTile
@RegistryName("energy_router_te")
@ValidBlocksForTile({EnergyRouterBlock.class})
public class EnergyRouterTile extends TileEntity implements ITickableTileEntity {

    private final ExpansiveEnergyStorage expansiveEnergyStorage;

    public EnergyRouterTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        expansiveEnergyStorage = new ExpansiveEnergyStorage(2048, 512, 256, 0);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        expansiveEnergyStorage.setStorage(compound.getInt("storedEnergy"));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("storedEnergy", expansiveEnergyStorage.getEnergyStored());
        return compound;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap.equals(CapabilityEnergy.ENERGY)) {
            return LazyOptional.of(() -> expansiveEnergyStorage).cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public void tick() {

    }

    @Override
    public void validate() {
        super.validate();
    }


}
