package gregtech.loaders.load;

import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class GT_FuelLoader
        implements Runnable {
    public void run() {
        GT_Log.out.println("GT_Mod: Initializing various Fuels.");
        ItemList.sNitricAcid = GT_Mod.gregtechproxy.addFluid("nitricacid", "Nitric acid ", null, 1, 295);
        ItemList.sBlueVitriol = GT_Mod.gregtechproxy.addFluid("solution.bluevitriol", "Blue Vitriol water solution", null, 1, 295);
        ItemList.sNickelSulfate = GT_Mod.gregtechproxy.addFluid("solution.nickelsulfate", "Nickel sulfate water solution", null, 1, 295);
        new GT_Recipe(new ItemStack(Items.lava_bucket), new ItemStack(Blocks.obsidian), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 1L), 30, 2);

        GT_Recipe.GT_Recipe_Map.sSmallNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Naquadah, 1L)}, null, null, null, 0, 0, 25000);
        GT_Recipe.GT_Recipe_Map.sLargeNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L)}, null, null, null, 0, 0, 200000);
        GT_Recipe.GT_Recipe_Map.sFluidNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell,  Materials.Naquadah, 1L)}, null, null, null, 0, 0, 200000);

        GT_Recipe.GT_Recipe_Map.sAntimatterReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Antimatter, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.UUMatter, 1L)},  new ItemStack[]{ItemList.Cell_Empty.get(2L, new Object[0])}, null, new FluidStack[]{Materials.Nickel.getMolten(16)}, new FluidStack[]{Materials.Nickel.getPlasma(16)}, 0, 0, 14400);
        
        GT_Values.RA.addFuel(GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 1L, 4), null, 4, 5);
        GT_Values.RA.addFuel(new ItemStack(Items.experience_bottle, 1), null, 10, 5);
        GT_Values.RA.addFuel(new ItemStack(Items.ghast_tear, 1), null, 50, 5);
        GT_Values.RA.addFuel(new ItemStack(Blocks.beacon, 1), null, Materials.NetherStar.mFuelPower * 2, Materials.NetherStar.mFuelType);
    }
}
