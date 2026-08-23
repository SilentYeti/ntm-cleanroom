// ============================================================================
// Soldering: the Press+Soldering chain that replaces the AE2 Inscriber's
// Logic/Calculation/Engineering Processor step (Silicon Print + a Processor
// Print + redstone -> the finished Processor). This is the actual
// replacement path for the Inscriber recipes removed in schizophrenia_ae2.groovy
// (mods.appliedenergistics2.inscriber.removeByOutput calls).
//
// Split out of schizophrenia_ae2.groovy into its own file (one file per NTM
// machine). See schizophrenia_ntm_assemblymachine.groovy's header for the
// full explanation of the override(target, json)-replaces-not-merges
// mechanism and why no JSON library is used here.
//
// TARGET NAME NOT VERIFIED against a live session - 'hbmSoldering' is my
// best read of the config file's own name. If this errors, run
// `log.info(mods.hbm.recipeOverrides.listTargets())` once and check
// logs/groovy.log for the accepted name.
//
// Schema (from the real file): toppings / pcb / solder (each a list of
// [type, item, count?, meta?]) / output ([item, count?, meta?]) /
// duration (ticks) / consumption (per tick).
// ============================================================================

def ae2SolderingRecipes = '''
    {
      "toppings": [["item", "appliedenergistics2:material", 1, 20], ["item", "minecraft:redstone", 1], ["item", "appliedenergistics2:material", 1, 17]],
      "pcb": [],
      "solder": [["dict", "wireFineLead", 8]],
      "output": ["appliedenergistics2:material", 1, 24],
      "duration": 100,
      "consumption": 1000
    },
    {
      "toppings": [["item", "appliedenergistics2:material", 1, 20], ["item", "minecraft:redstone", 1], ["item", "appliedenergistics2:material", 1, 18]],
      "pcb": [],
      "solder": [["dict", "wireFineLead", 8]],
      "output": ["appliedenergistics2:material", 1, 22],
      "duration": 100,
      "consumption": 1000
    },
    {
      "toppings": [["item", "appliedenergistics2:material", 1, 20], ["item", "minecraft:redstone", 1], ["item", "appliedenergistics2:material", 1, 16]],
      "pcb": [],
      "solder": [["dict", "wireFineLead", 8]],
      "output": ["appliedenergistics2:material", 1, 23],
      "duration": 100,
      "consumption": 1000
    },'''
def solderingFile = new File('config/hbmRecipes/hbmSoldering.json')
mods.hbm.recipeOverrides.override('hbmSoldering',
    solderingFile.text.replaceFirst(/"recipes"\s*:\s*\[/, '"recipes": [' + ae2SolderingRecipes))
