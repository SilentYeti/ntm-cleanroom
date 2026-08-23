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

// ============================================================================
// Assembly Machine: warforge:reinforcedclaimblock (PLACEHOLDER)
//
// Assembly Machine has no dedicated GroovyScript recipe builder (unlike
// Press/Shredder/Irradiation Channel above) - the only hook hbm exposes is
// mods.hbm.recipeOverrides.override(target, json), which REPLACES an entire
// recipe file's contents rather than adding one entry. So to add just this
// one recipe without wiping every stock Assembly Machine recipe: read the
// live config/hbmRecipes/hbmAssemblyMachine.json fresh, append this recipe
// to its "recipes" array, and hand the whole thing back. Since this always
// re-reads from disk rather than a previous override, running this block
// again on every /gs reload replaces cleanly instead of piling up
// duplicates - safe to iterate on live.
//
// TARGET NAME NOT VERIFIED: 'hbmAssemblyMachine' is my best read of the
// alias hbm derives from the config file's own name
// (config/hbmRecipes/hbmAssemblyMachine.json minus ".json"), not confirmed
// against a live session. If this errors, run
// `log.info(mods.hbm.recipeOverrides.listTargets())` once and check
// logs/groovy.log for the exact accepted name.
//
// Schema reference (from the real file): name / inputItem (list of
// [type, value] pairs, type "dict" or "single") / outputItem (same shape) /
// duration (ticks) / power (per tick) / optional blueprintpool /
// autoSwitchGroup.
//
// NO JSON LIBRARY AVAILABLE: groovy.json.JsonSlurper doesn't exist here -
// GroovyScript bundles Groovy's core runtime but not the separate
// groovy-json module (confirmed by decompiling the jar - no groovy/json
// package in it at all), so `unable to resolve class groovy.json.JsonSlurper`
// at script-compile time is a real missing-class error, not something an
// import fixes. Rather than fight Gson's much more verbose JsonObject/
// JsonArray builder API for this, this just inserts the new recipe's JSON
// text directly after the known "recipes": [ opening in the file - the
// override(String, String) overload takes raw text, so no parser is needed
// either way.
// ============================================================================
def assemblyFile = new File('config/hbmRecipes/hbmAssemblyMachine.json')

def placeholderRecipe = '''
    {
      "name": "ass.warforge_reinforcedclaimblock",
      "inputItem": [["dict", "obsidian"]],
      "outputItem": [["single", ["warforge:reinforcedclaimblock"]]],
      "duration": 60,
      "power": 100
    },'''

def modifiedJson = assemblyFile.text.replaceFirst(/"recipes"\s*:\s*\[/, '"recipes": [' + placeholderRecipe)

mods.hbm.recipeOverrides.override('hbmAssemblyMachine', modifiedJson)
