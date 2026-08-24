// ============================================================================
// Soldering: the Press+Soldering chain that replaces the AE2 Inscriber's
// Logic/Calculation/Engineering Processor step (Silicon Print + a Processor
// Print + redstone -> the finished Processor). This is the actual
// replacement path for the Inscriber recipes removed in schizophrenia_ae2.groovy
// (mods.appliedenergistics2.inscriber.removeByOutput calls).
//
// Converted from the recipeOverrides.override(...) JSON-splice hack to
// NTM-CE's new dedicated native GroovyScript integration: mods.hbm.soldering.
// See schizophrenia_ntm_arcwelder.groovy's header for why every remaining
// override(...) caller needed migrating (global recipe-system wipe trigger).
// ============================================================================

mods.hbm.soldering.recipeBuilder()
    .toppings(item('appliedenergistics2:material', 20), item('minecraft:redstone'), item('appliedenergistics2:material', 17))
    .solder(ore('wireFineLead') * 8)
    .output(item('appliedenergistics2:material', 24))
    .duration(100)
    .power(1000)
    .register()

mods.hbm.soldering.recipeBuilder()
    .toppings(item('appliedenergistics2:material', 20), item('minecraft:redstone'), item('appliedenergistics2:material', 18))
    .solder(ore('wireFineLead') * 8)
    .output(item('appliedenergistics2:material', 22))
    .duration(100)
    .power(1000)
    .register()

mods.hbm.soldering.recipeBuilder()
    .toppings(item('appliedenergistics2:material', 20), item('minecraft:redstone'), item('appliedenergistics2:material', 16))
    .solder(ore('wireFineLead') * 8)
    .output(item('appliedenergistics2:material', 23))
    .duration(100)
    .power(1000)
    .register()
