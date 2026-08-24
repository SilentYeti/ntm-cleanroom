// ============================================================================
// Chemical Plant: the raw-material chain for AE2's own basic materials
// (Certus Quartz Crystal, Fluix Crystal, Quartz Fiber part) + the
// fallen-star-to-XP-juice recipe.
//
// Converted from the earlier config-JSON-override hack to NTM-CE's new
// dedicated native GroovyScript integration: mods.hbm.chemicalPlant. See
// schizophrenia_ntm_assemblymachine.groovy's header for the full rationale
// and the item()/ore() syntax notes (2nd arg to item() is META, not count;
// use * N for count).
//
// hbm's own FluidStack type (not Forge's) is required here - construct with
// new com.hbm.inventory.fluid.FluidStack(com.hbm.inventory.fluid.Fluids.X, mB).
// ============================================================================

mods.hbm.chemicalPlant.recipeBuilder()
    .name('chem.ae2_quartzfiber')
    .input(item('hbm:powder_quartz'), item('hbm:ingot_fiberglass'))
    .inputFluid(new com.hbm.inventory.fluid.FluidStack(com.hbm.inventory.fluid.Fluids.WATER, 2000))
    .output(item('appliedenergistics2:part', 140) * 2)
    .duration(100)
    .power(100)
    .register()

mods.hbm.chemicalPlant.recipeBuilder()
    .name('chem.ae2_certus')
    .input(item('hbm:powder_quartz'))
    .inputFluid(new com.hbm.inventory.fluid.FluidStack(com.hbm.inventory.fluid.Fluids.WATER, 2000))
    .output(item('appliedenergistics2:material', 0))
    .duration(100)
    .power(100)
    .register()

mods.hbm.chemicalPlant.recipeBuilder()
    .name('chem.ae2_fluix')
    .input(item('appliedenergistics2:material', 1), item('minecraft:redstone'))
    .inputFluid(new com.hbm.inventory.fluid.FluidStack(com.hbm.inventory.fluid.Fluids.WATER, 2000))
    .output(item('appliedenergistics2:material', 7) * 2)
    .duration(100)
    .power(100)
    .register()

mods.hbm.chemicalPlant.recipeBuilder()
    .name('chem.fallenstar_xp')
    .input(item('nyx:fallen_star'))
    .outputFluid(new com.hbm.inventory.fluid.FluidStack(com.hbm.inventory.fluid.Fluids.XPJUICE, 1000))
    .duration(500)
    .power(1000)
    .register()
