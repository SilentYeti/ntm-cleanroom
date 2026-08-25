// ============================================================================
// Arc Welder: combine each AE2 storage/spatial cell Part + an Empty Storage
// Cell (material:39) into the finished cell.
//
// Converted from the recipeOverrides.override(...) JSON-splice hack to
// NTM-CE's new dedicated native GroovyScript integration: mods.hbm.arcWelder.
// IMPORTANT WHY THIS MATTERED: any script anywhere in the pack still calling
// mods.hbm.recipeOverrides.override(...) triggers a GLOBAL wipe-and-reload-
// from-JSON across every single hbm recipe handler (SerializableRecipe.
// initialize(), called from RecipeOverrideManager.afterScriptLoad()) - not
// just the target being overridden. Since this pack's Assembly Machine/
// Chemical Plant JSON files had their custom recipes stripped out (moved to
// groovy), that global wipe silently erased them on every reload, with
// nothing left to re-add them afterward. Migrating every remaining
// override(...) caller (this file + soldering) to a native builder removes
// the trigger entirely. See schizophrenia_ntm_assemblymachine.groovy's
// header for the item()/ore() syntax notes.
// ============================================================================

mods.hbm.arcWelder.recipeBuilder()
    .input(item('appliedenergistics2:material', 35), item('appliedenergistics2:material', 39))
    .output(item('appliedenergistics2:storage_cell_1k'))
    .duration(100)
    .power(2000)
    .register()

mods.hbm.arcWelder.recipeBuilder()
    .input(item('appliedenergistics2:material', 36), item('appliedenergistics2:material', 39))
    .output(item('appliedenergistics2:storage_cell_4k'))
    .duration(300)
    .power(10000)
    .register()

mods.hbm.arcWelder.recipeBuilder()
    .input(item('appliedenergistics2:material', 37), item('appliedenergistics2:material', 39))
    .output(item('appliedenergistics2:storage_cell_16k'))
    .duration(400)
    .power(500000)
    .register()

mods.hbm.arcWelder.recipeBuilder()
    .input(item('appliedenergistics2:material', 38), item('appliedenergistics2:material', 39))
    .output(item('appliedenergistics2:storage_cell_64k'))
    .duration(600)
    .power(2500000)
    .register()
