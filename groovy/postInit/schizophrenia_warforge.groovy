// ============================================================================
// WarForge: Remaintained (modid "warforge") - strip the mod's default recipes
// so the faction/claim progression can be rebuilt by hand below.
//
// Ported from scripts/schizophrenia_warforge.zs (CraftTweaker). That file's
// recipes.removeByMod("warforge") has no direct GroovyScript equivalent -
// crafting only offers removeByOutput/removeByInput/remove(name)/removeAll,
// no "remove everything from this modid" - so this filters the live recipe
// stream by registry-name domain and bulk-removes the matches instead.
// ============================================================================

crafting.streamRecipes()
    .filter { it.registryName.resourceDomain == 'warforge' }
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
        [item('hbm:plate_cast', 30), item('hbm:plate_steel'), item('hbm:plate_cast', 30)],
        [item('hbm:plate_steel'), item('hbm:reinforced_stone'), item('hbm:plate_steel')],
        [item('hbm:plate_cast', 30), item('hbm:plate_steel'), item('hbm:plate_cast', 30)]
    ]
)

// --- New recipes go here ---
