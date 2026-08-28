// ============================================================================
// BetterQuesting / Storage Drawers / Gravity Gun recipe changes
// Ported from scripts/schizophrenia_misc.zs (CraftTweaker) - see that file's
// header for the original porting notes. Mechanical 1:1 conversion: every
// recipes.remove/addShaped call maps directly to crafting.removeByOutput/
// addShaped, and <modid:item:meta> bracket handlers become item(...) calls.
// ============================================================================

// --- BetterQuesting reward items: disable crafting entirely (quest-reward only) ---
// The source pack removed these and never re-added a crafting recipe - they're
// meant to only be obtainable as quest rewards, not player-craftable.
crafting.removeByOutput(item('betterquesting:extra_life'))
crafting.removeByOutput(item('betterquesting:extra_life', 1))
crafting.removeByOutput(item('betterquesting:extra_life', 2))
crafting.removeByOutput(item('betterquesting:submit_station'))
// betterquesting:observation_station was removed in the source pack too, but
// that item id doesn't exist in BetterQuestingUnofficial 4.3.2 - skipped.
crafting.removeByOutput(item('hbm:desh_sword'))
crafting.removeByOutput(item('hbm:cobalt_sword'))
mods.hbm.anvil_construction.remove(item('hbm:cobalt_decorated_sword'))
crafting.removeByOutput(item('hbm:starmetal_sword'))
crafting.removeByOutput(item('hbm:cmb_sword'))

// --- Storage Drawers: gate behind NTM's wooden Mass Storage Unit ---
// CONFIDENCE NOTE: storagedrawers:basicdrawers is a single block with meta
// variants (0=fulldrawers1, 1=fulldrawers2, 2=fulldrawers4, 3=halfdrawers2,
// 4=halfdrawers4) reconstructed from declaration order in the mod's lang
// file - not verified in-game. Check with "/ct hand" (or hover + look at
// the GroovyScript item ID overlay) if a recipe below doesn't look right.
crafting.removeByOutput(item('storagedrawers:basicdrawers', 0)) // Basic Drawer (1x1)
crafting.removeByOutput(item('storagedrawers:basicdrawers', 1)) // Basic Drawers 1x2
crafting.removeByOutput(item('storagedrawers:basicdrawers', 2)) // Basic Drawers 2x2
crafting.removeByOutput(item('storagedrawers:basicdrawers', 3)) // Half Drawers 1x2
crafting.removeByOutput(item('storagedrawers:basicdrawers', 4)) // Half Drawers 2x2
crafting.removeByOutput(item('storagedrawers:compdrawers'))
crafting.removeByOutput(item('storagedrawers:controller'))
crafting.removeByOutput(item('storagedrawers:controllerslave'))

crafting.addShaped(item('storagedrawers:basicdrawers', 0),
    [[ore('plankWood'), ore('plankWood'), ore('plankWood')],
     [null, item('hbm:mass_storage_wood'), null],
     [ore('plankWood'), ore('plankWood'), ore('plankWood')]])
crafting.addShaped(item('storagedrawers:basicdrawers', 1),
    [[ore('plankWood'), item('hbm:mass_storage_wood'), ore('plankWood')],
     [ore('plankWood'), ore('plankWood'), ore('plankWood')],
     [ore('plankWood'), item('hbm:mass_storage_wood'), ore('plankWood')]])
crafting.addShaped(item('storagedrawers:basicdrawers', 2),
    [[item('hbm:mass_storage_wood'), ore('plankWood'), item('hbm:mass_storage_wood')],
     [ore('plankWood'), ore('plankWood'), ore('plankWood')],
     [item('hbm:mass_storage_wood'), ore('plankWood'), item('hbm:mass_storage_wood')]])
crafting.addShaped(item('storagedrawers:basicdrawers', 3),
    [[ore('slabWood'), item('hbm:mass_storage_wood'), ore('slabWood')],
     [ore('slabWood'), ore('slabWood'), ore('slabWood')],
     [ore('slabWood'), item('hbm:mass_storage_wood'), ore('slabWood')]])
crafting.addShaped(item('storagedrawers:basicdrawers', 4),
    [[item('hbm:mass_storage_wood'), ore('slabWood'), item('hbm:mass_storage_wood')],
     [ore('slabWood'), ore('slabWood'), ore('slabWood')],
     [item('hbm:mass_storage_wood'), ore('slabWood'), item('hbm:mass_storage_wood')]])
crafting.addShaped(item('storagedrawers:compdrawers'),
    [[ore('craftingPiston'), ore('drawerBasic'), ore('craftingPiston')]])
crafting.addShaped(item('storagedrawers:controller'),
    [[null, ore('plateSteel'), null],
     [ore('plateSteel'), ore('drawerBasic'), ore('plateSteel')],
     [null, ore('plateSteel'), null]])
crafting.addShaped(item('storagedrawers:controllerslave'),
    [[null, ore('plateSteel'), null],
     [ore('plateSteel'), item('storagedrawers:trim'), ore('plateSteel')],
     [null, ore('plateSteel'), null]])

// --- Gravity Gun ---
// Source pack used a different mod also named "GraviGun"; Schizophrenia has
// iChun's GravityGun instead (modid "gravitygun") - same concept (gate the
// gun behind NTM weapon-tier materials) applied to the actual installed mod.
crafting.removeByOutput(item('gravitygun:gravitygun', 0))
crafting.addShaped(item('gravitygun:gravitygun', 0),
    [[null, ore('tinySchrabidium'), item('hbm:circuit', 8)],
     [ore('barrelHeavyWeaponSteel'), ore('receiverHeavyWeaponSteel'), ore('stockAnyPlastic')],
     [null, ore('gripAnyPlastic'), null]])
crafting.removeByOutput(item('gravitygun:gravitygun', 1))

// --- Weapon Balancing ---
// Fuck bobcat and his fuckass weapon progression
// I'm just gonna wipe all recipes and rewrite them because the barriers to unlock
// some of these things are all over the place
crafting.removeByOutput(item('hbm:gun_amat'))
crafting.removeByOutput(item('hbm:gun_pepperbox'))
crafting.removeByOutput(item('hbm:gun_light_revolver'))
crafting.removeByOutput(item('hbm:gun_light_revolver_atlas'))
crafting.removeByOutput(item('hbm:gun_henry'))
crafting.removeByOutput(item('hbm:gun_henry_lincoln'))
crafting.removeByOutput(item('hbm:gun_greasegun'))
crafting.removeByOutput(item('hbm:gun_maresleg'))
crafting.removeByOutput(item('hbm:gun_maresleg_akimbo'))
crafting.removeByOutput(item('hbm:gun_flaregun'))
crafting.removeByOutput(item('hbm:gun_am180'))
crafting.removeByOutput(item('hbm:gun_star_f'))
crafting.removeByOutput(item('hbm:gun_star_f_akimbo'))
crafting.removeByOutput(item('hbm:gun_liberator'))
crafting.removeByOutput(item('hbm:gun_congolake'))
crafting.removeByOutput(item('hbm:gun_mk108'))
crafting.removeByOutput(item('hbm:gun_flamer'))
crafting.removeByOutput(item('hbm:gun_flamer_topaz'))
crafting.removeByOutput(item('hbm:gun_heavy_revolver'))
crafting.removeByOutput(item('hbm:gun_carbine'))
crafting.removeByOutput(item('hbm:gun_uzi'))
crafting.removeByOutput(item('hbm:gun_uzi_akimbo'))
crafting.removeByOutput(item('hbm:gun_spas12'))
crafting.removeByOutput(item('hbm:gun_panzerschreck'))
crafting.removeByOutput(item('hbm:gun_g3'))
crafting.removeByOutput(item('hbm:gun_g3_zebra'))
crafting.removeByOutput(item('hbm:gun_stinger'))
crafting.removeByOutput(item('hbm:gun_chemthrower'))
crafting.removeByOutput(item('hbm:gun_m2'))
crafting.removeByOutput(item('hbm:gun_autoshotgun'))
crafting.removeByOutput(item('hbm:gun_autoshotgun_shredder'))
crafting.removeByOutput(item('hbm:gun_quadro'))
crafting.removeByOutput(item('hbm:gun_lag'))
crafting.removeByOutput(item('hbm:gun_minigun'))
crafting.removeByOutput(item('hbm:gun_missile_launcher'))
crafting.removeByOutput(item('hbm:gun_tesla_cannon'))
crafting.removeByOutput(item('hbm:gun_laser_pistol'))
crafting.removeByOutput(item('hbm:gun_laser_pistol_pew_pew'))
crafting.removeByOutput(item('hbm:gun_stg77'))
crafting.removeByOutput(item('hbm:gun_fatman'))
crafting.removeByOutput(item('hbm:gun_tau'))
crafting.removeByOutput(item('hbm:gun_lasrifle'))
crafting.removeByOutput(item('hbm:gun_double_barrel_sacred_dragon'))
crafting.removeByOutput(item('hbm:gun_charge_thrower'))
crafting.removeByOutput(item('hbm:gun_drill'))
crafting.removeByOutput(item('hbm:gun_pa_melee'))
crafting.removeByOutput(item('hbm:gun_pa_ranged'))
crafting.removeByOutput(item('hbm:gun_fireext'))

