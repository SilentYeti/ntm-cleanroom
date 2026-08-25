// ============================================================================
// Assembly Machine: AE2 storage/spatial cell parts + the pack's own
// ntmcleanroom-addon machines (schrabidium transmutator, redcoil/euphemium
// capacitors) + the warforge reinforcedclaimblock/islandcollector/
// siegecampblock recipes.
//
// Converted from the earlier config-JSON-override hack (mods.hbm.recipeOverrides
// .override('hbmAssemblyMachine', ...)) to NTM-CE's new dedicated native
// GroovyScript integration: mods.hbm.assemblyMachine. Each recipe is added
// directly and independently - no more single-shot full-file replacement, so
// this file can coexist with any other script that also wants to add Assembly
// Machine recipes (the old mechanism could only tolerate exactly one script
// doing this in the whole pack - see git history: "Fix AE2 Assembly Machine
// recipes silently getting wiped every reload").
//
// Syntax notes (confirmed empirically against this GroovyScript build, since
// it's easy to get backwards - see NTM-CE's own tools/test-groovy-compat.sh):
//   item('modid:name')          -> 1x, meta 0
//   item('modid:name', META)    -> 1x, given meta (2nd arg is META, not count!)
//   item('modid:name', META) * N -> N x, given meta
//   ore('oreDictName') * N      -> N x of an ore-dict tag
// There is no 3-arg item(name, count, meta) form - trying that silently
// resolves to an empty/air stack instead of throwing, so watch for that.
// ============================================================================


mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ae2_1kstorage')
    .input(ore('plateSteel') * 5, item('appliedenergistics2:material', 0) * 4, item('hbm:circuit', 7), item('hbm:wire_fine', 31) * 8)
    .output(item('appliedenergistics2:material', 35))
    .duration(200)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ae2_4kstorage')
    .input(ore('plateGold') * 5, item('appliedenergistics2:material', 1) * 4, item('hbm:circuit', 8), item('hbm:wire_fine', 31) * 8, item('appliedenergistics2:material', 35))
    .output(item('appliedenergistics2:material', 36))
    .duration(200)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ae2_16kstorage')
    .input(ore('ingotAnyPlastic') * 5, item('appliedenergistics2:material', 10) * 4, item('hbm:circuit', 9), ore('wireDenseGold') * 2, ore('WorkersAlloy') * 2, item('appliedenergistics2:material', 36))
    .output(item('appliedenergistics2:material', 37))
    .duration(200)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ae2_64kstorage')
    .input(item('hbm:plate_titanium') * 8, item('appliedenergistics2:material', 12), item('hbm:wire_dense', 4100) * 2, item('hbm:circuit', 11), ore('ingotAnyResistantAlloy') * 2, item('appliedenergistics2:material', 37))
    .output(item('appliedenergistics2:material', 38))
    .duration(200)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ntmcleanroom.schrabidium_transmutator')
    .input(ore('ingotMagnetizedTungsten'), ore('ingotTitanium') * 24, ore('plateSteel') * 18, ore('plateSextupleSteel') * 12,
           item('hbm:plate_desh') * 6, ore('ingotRubber') * 8, item('hbm:battery_pack', 2) * 1, item('hbm:circuit', 9) * 2)
    .output(item('ntmcleanroom:machine_schrabidium_transmutator'))
    .duration(500)
    .power(20000)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ntmcleanroom.redcoil_capacitor')
    .input(ore('plateGold') * 3, item('hbm:fuse'), ore('wireFineAnyResistantAlloy') * 4, item('hbm:coil_magnetized_tungsten') * 6, item('minecraft:redstone_block') * 2)
    .output(item('hbm:redcoil_capacitor'))
    .duration(200)
    .power(2000)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.ntmcleanroom.euphemium_capacitor')
    .input(ore('ingotNiobium') * 4, item('hbm:redcoil_capacitor'), item('hbm:ingot_euphemium') * 4, item('hbm:circuit', 10) * 8, item('hbm:powder_nitan_mix') * 18)
    .output(item('hbm:euphemium_capacitor'))
    .duration(600)
    .power(6000)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.warforge_reinforcedclaimblock')
    .input(item('hbm:circuit', 8) * 2, item('hbm:plate_cast', 42) * 2, item('hbm:brick_concrete') * 8)
    .output(item('warforge:reinforcedclaimblock'))
    .duration(300)
    .power(4000)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.warforge_islandcollector')
    .input(item('hbm:circuit', 7), item('hbm:plate_cast', 30) * 4, item('hbm:mass_storage_iron'))
    .output(item('warforge:islandcollector'))
    .duration(200)
    .power(1000)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.warforge_siegecampblock')
    .input(item('hbm:circuit', 7) * 2, item('hbm:plate_cast', 30) * 8, item('hbm:brick_concrete') * 32)
    .output(item('warforge:siegecampblock'))
    .duration(200)
    .power(2000)
    .register()
