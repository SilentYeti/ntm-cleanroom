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

// ============================================================================
// Weapon Balancing: guns moved to the Assembly Machine
// The crafting-table recipes for these guns were wiped in schizophrenia_misc.groovy
// ("Fuck bobcat and his fuckass weapon progression") pending a proper rebalance.
// Every gun below gets the same cheap, uniform recipe for now so nothing is
// stuck uncraftable in the meantime - TODO: replace each of these with a real,
// individually-tiered recipe once the new progression is designed.
// ============================================================================

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_amat')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_amat'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_light_revolver')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_light_revolver'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_henry')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_henry'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_greasegun')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_greasegun'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_maresleg')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_maresleg'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_flaregun')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_flaregun'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_star_f')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_star_f'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_liberator')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_liberator'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_congolake')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_congolake'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_mk108')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_mk108'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_flamer')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_flamer'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_flamer_topaz')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_flamer_topaz'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_heavy_revolver')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_heavy_revolver'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_carbine')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_carbine'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_uzi')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_uzi'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_spas12')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_spas12'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_panzerschreck')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_panzerschreck'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_g3')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_g3'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_stinger')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_stinger'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_quadro')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_quadro'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_missile_launcher')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_missile_launcher'))
    .duration(100)
    .power(100)removes built-in recipe for schrab transmutator
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_tesla_cannon')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_tesla_cannon'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_laser_pistol')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_laser_pistol'))
    .duration(100)removes built-in recipe for schrab transmutator
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_stg77')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_stg77'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_tau')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_tau'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_lasrifle')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_lasrifle'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_charge_thrower')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_charge_thrower'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_pa_melee')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_pa_melee'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_pa_ranged')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_pa_ranged'))
    .duration(100)
    .power(100)
    .register()

mods.hbm.assemblyMachine.recipeBuilder()
    .name('ass.gun_fireext')
    .input(ore('plateSteel') * 4, item('hbm:circuit', 6) * 2)
    .output(item('hbm:gun_fireext'))
    .duration(100)
    .power(100)
    .register()
