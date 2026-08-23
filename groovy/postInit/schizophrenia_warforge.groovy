// ============================================================================
// WarForge: Remaintained (modid "warforge") - strip the mod's default recipes
// so the faction/claim progression can be rebuilt by hand below.
//
// Ported from scripts/schizophrenia_warforge.zs (CraftTweaker). That file's
// recipes.removeByMod("warforge") has no direct GroovyScript equivalent -
// crafting only offers removeByOutput/removeByInput/remove(name)/removeAll,
// no "remove everything from this modid" - so this filters the live recipe
// stream by registry name and bulk-removes the matches instead.
//
// NOTE: registryName.resourceDomain threw "groovy.lang.MissingPropertyException:
// No such property: resourceDomain" at runtime on this Cleanroom build -
// whatever ResourceLocation exposes here, it isn't that. toString() always
// renders as "namespace:path" though, so matching against that sidesteps
// needing the exact getter name.
// ============================================================================

crafting.streamRecipes()
    .filter { it.registryName.toString().startsWith('warforge:') }
    .removeAll()

// --- For reference, this is what shipped by default (all in assets/warforge/recipes/) ---
// warforge:basicclaimblock      - glass + emerald + gold block
// warforge:citadelblock         - two alternative recipes:
//                                   overworld: glass + gold block + obsidian
//                                   nether:    glowstone + ghast tear + nether brick
// warforge:reinforcedclaimblock - obsidian + nether star + diamond block
// warforge:islandcollector      - iron ingot + redstone + hopper
// warforge:siegecampblock       - cobblestone + furnace + chest + any bed + any banner
// (legacyleaderboard / notorietyleaderboard / topleaderboard / wealthleaderboard /
//  dummy blocks never had a crafting recipe to begin with - admin/command only.)

// --- Custom recipes (folded in from the CT-GUI-generated scripts/recipes.zs) ---
crafting.addShaped(
    item('warforge:citadelblock'),
    [
        [item('hbm:plate_cast', 30), item('hbm:reinforced_stone'), item('hbm:plate_cast', 30)],
        [item('hbm:reinforced_stone'), item('hbm:motor'), item('hbm:reinforced_stone')],
        [item('hbm:plate_cast', 30), item('hbm:reinforced_stone'), item('hbm:plate_cast', 30)]
    ]
)
crafting.addShaped(
    item('warforge:basicclaimblock'),
    [
        [item('hbm:plate_iron'), item('hbm:plate_steel'), item('hbm:plate_iron')],
        [item('hbm:plate_steel'), item('hbm:reinforced_stone'), item('hbm:plate_steel')],
        [item('hbm:plate_iron'), item('hbm:plate_steel'), item('hbm:plate_iron')]
    ]
)

// --- New recipes go here ---

// NOTE: the Assembly Machine recipe for warforge:reinforcedclaimblock lives
// in groovy/postInit/schizophrenia_ae2.groovy now, not here. hbm's
// mods.hbm.recipeOverrides.override(target, json) REPLACES an entire
// target's contents rather than merging - two scripts each calling
// override('hbmAssemblyMachine', ...) meant whichever ran last (alphabetical
// order: ae2 -> irradiation -> misc -> warforge) silently wiped out the
// other's recipes on every reload. That's why the AE2 Assembly Machine
// recipes weren't actually appearing - every reload, this file's call ran
// after ae2.groovy's and threw its 10 recipes away, leaving only this one
// placeholder. Fixed by consolidating every hbmAssemblyMachine addition into
// a single override() call in schizophrenia_ae2.groovy.
