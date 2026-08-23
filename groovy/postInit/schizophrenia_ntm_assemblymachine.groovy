// ============================================================================
// Assembly Machine: AE2 storage/spatial cell Parts + the pack's own
// ntmcleanroom-addon machines (schrabidium transmutator, redcoil/euphemium
// capacitors) + the warforge reinforcedclaimblock/islandcollector/
// siegecampblock recipes.
//
// Split out of schizophrenia_ae2.groovy into its own file (one file per NTM
// machine) - previously ALL of hbmAssemblyMachine's custom recipes lived in
// that file, mixed in with the AE2 crafting-table recipes. Splitting them
// keeps each NTM machine's overrides self-contained and easy to find/edit.
//
// hbm has no dedicated GroovyScript recipe builder for Assembly Machine
// (unlike Press/Shredder/Irradiation Channel) - the only hook is
// mods.hbm.recipeOverrides.override(target, json), which REPLACES an
// entire target's contents rather than merging. IMPORTANT: this means
// exactly ONE script in the whole groovy/ folder may call
// override('hbmAssemblyMachine', ...) - if another script also calls it,
// whichever runs last (alphabetical order) silently wipes out the other's
// recipes on every /gs reload. This bit us once already (see git history:
// "Fix AE2 Assembly Machine recipes silently getting wiped every reload") -
// don't reintroduce a second override('hbmAssemblyMachine', ...) call
// anywhere else.
//
// Approach: read config/hbmRecipes/hbmAssemblyMachine.json fresh (which
// only holds hbm's stock catalog - all AE2/ntmcleanroom/warforge customs
// were stripped out of the JSON and now live here instead), splice this
// text in right after "recipes": [, and hand the whole thing back. Since
// it re-reads from disk every run, /gs reload always replaces cleanly with
// no duplicate buildup. No JSON library needed (groovy-json isn't bundled
// in this GroovyScript build) - override(String, String) takes raw text.
//
// TARGET NAME NOT VERIFIED against a live session - 'hbmAssemblyMachine' is
// my best read of the alias hbm derives from the config file's own name.
// If this errors, run `log.info(mods.hbm.recipeOverrides.listTargets())`
// once and check logs/groovy.log for the accepted name.
//
// Schema (from the real file): name / inputItem (list of [type, value...]
// pairs, type "dict" or "item") / outputItem (same shape, type "single") /
// duration (ticks) / power (per tick) / optional blueprintpool /
// autoSwitchGroup.
// ============================================================================

def ae2AssemblyRecipes = '''
    {
      "name": "ass.ae2_1kstorage",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 4, 10], ["item", "hbm:circuit", 1, 8], ["dict", "wireFineLead", 8]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 35]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_4kstorage",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 4, 10], ["item", "hbm:circuit", 1, 9], ["dict", "wireFineLead", 8], ["dict", "ingotAnyResistantAlloy", 1]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 36]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_16kstorage",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 4, 10], ["item", "hbm:circuit", 1, 11], ["dict", "wireFineLead", 8], ["dict", "ingotAnyResistantAlloy", 2]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 37]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_64kstorage",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 4, 10], ["item", "hbm:circuit", 1, 15], ["dict", "wireFineLead", 8], ["dict", "ingotAnyResistantAlloy", 4]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 38]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_2spatial",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 1, 9], ["item", "hbm:circuit", 1, 8], ["dict", "wireFineLead", 8]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 32]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_16spatial",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 1, 9], ["item", "hbm:circuit", 1, 9], ["dict", "wireFineLead", 8], ["dict", "ingotAnyResistantAlloy", 1]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 33]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ae2_128spatial",
      "inputItem": [["dict", "plateSteel", 4], ["item", "appliedenergistics2:material", 1, 9], ["item", "hbm:circuit", 1, 11], ["dict", "wireFineLead", 8], ["dict", "ingotAnyResistantAlloy", 2]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 34]]],
      "duration": 200,
      "power": 100
    },
    {
      "name": "ass.ntmcleanroom.schrabidium_transmutator",
      "inputItem": [["dict", "ingotMagnetizedTungsten"], ["dict", "ingotTitanium", 24], ["dict", "plateSteel", 18], ["dict", "plateSextupleSteel", 12], ["item", "hbm:plate_desh", 6], ["dict", "ingotRubber", 8], ["item", "hbm:machine_battery", 5], ["item", "hbm:circuit", 2, 9]],
      "outputItem": [["single", ["ntmcleanroom:machine_schrabidium_transmutator"]]],
      "duration": 500,
      "power": 20000
    },
    {
      "name": "ass.ntmcleanroom.redcoil_capacitor",
      "inputItem": [["dict", "plateGold", 3], ["item", "hbm:fuse"], ["dict", "wireFineAnyResistantAlloy", 4], ["item", "hbm:coil_magnetized_tungsten", 6], ["item", "minecraft:redstone_block", 2]],
      "outputItem": [["single", ["hbm:redcoil_capacitor"]]],
      "duration": 200,
      "power": 2000
    },
    {
      "name": "ass.ntmcleanroom.euphemium_capacitor",
      "inputItem": [["dict", "ingotNiobium", 4], ["item", "hbm:redcoil_capacitor"], ["item", "hbm:ingot_euphemium", 4], ["item", "hbm:circuit", 8, 10], ["item", "hbm:powder_nitan_mix", 18]],
      "outputItem": [["single", ["hbm:euphemium_capacitor"]]],
      "duration": 600,
      "power": 6000
    },
    {
      "name": "ass.warforge_reinforcedclaimblock",
      "inputItem": [["item", "hbm:circuit", 2, 8], ["item", "hbm:plate_cast", 2, 42], ["item", "hbm:brick_concrete", 8]],
      "outputItem": [["single", ["warforge:reinforcedclaimblock"]]],
      "duration": 300,
      "power": 4000
    },
    {
      "name": "ass.warforge_islandcollector",
      "inputItem": [["item", "hbm:circuit", 1, 7], ["item", "hbm:plate_cast", 4, 30], ["item", "hbm:mass_storage_iron", 1]],
      "outputItem": [["single", ["warforge:islandcollector"]]],
      "duration": 200,
      "power": 1000
    },
    {
      "name": "ass.warforge_siegecampblock",
      "inputItem": [["item", "hbm:circuit", 2, 7], ["item", "hbm:plate_cast", 8, 30], ["item", "hbm:brick_concrete", 32]],
      "outputItem": [["single", ["warforge:siegecampblock"]]],
      "duration": 200,
      "power": 2000
    },
    '''
def assemblyFile = new File('config/hbmRecipes/hbmAssemblyMachine.json')
mods.hbm.recipeOverrides.override('hbmAssemblyMachine',
    assemblyFile.text.replaceFirst(/"recipes"\s*:\s*\[/, '"recipes": [' + ae2AssemblyRecipes))
