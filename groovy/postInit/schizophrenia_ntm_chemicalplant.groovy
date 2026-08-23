// ============================================================================
// Chemical Plant: the raw-material chain for AE2's own basic materials
// (Certus Quartz Crystal, Fluix Crystal, Quartz Fiber part).
//
// Split out of schizophrenia_ae2.groovy into its own file (one file per NTM
// machine). See schizophrenia_ntm_assemblymachine.groovy's header for the
// full explanation of the override(target, json)-replaces-not-merges
// mechanism and why no JSON library is used here.
//
// TARGET NAME NOT VERIFIED against a live session - 'hbmChemicalPlant' is
// my best read of the config file's own name. If this errors, run
// `log.info(mods.hbm.recipeOverrides.listTargets())` once and check
// logs/groovy.log for the accepted name.
//
// Schema (from the real file): name / inputItem (list of [type, value...]
// pairs) / inputFluid (list of [fluidName, amount]) / outputItem (same
// shape as inputItem, type "single") / duration (ticks) / power (per tick).
// ============================================================================

def ae2ChemicalPlantRecipes = '''
    {
      "name": "chem.ae2_quartzfiber",
      "inputItem": [["item", "hbm:powder_quartz", 1], ["item", "hbm:ingot_fiberglass", 1]],
      "inputFluid": [["WATER", 2000]],
      "outputItem": [["single", ["appliedenergistics2:multi_part", 2, 140]]],
      "duration": 100,
      "power": 100
    },
    {
      "name": "chem.ae2_certus",
      "inputItem": [["item", "hbm:powder_quartz", 1]],
      "inputFluid": [["WATER", 2000]],
      "outputItem": [["single", ["appliedenergistics2:material", 1, 0]]],
      "duration": 100,
      "power": 100
    },
    {
      "name": "chem.ae2_fluix",
      "inputItem": [["item", "appliedenergistics2:material", 1, 1], ["item", "minecraft:redstone", 1]],
      "inputFluid": [["WATER", 2000]],
      "outputItem": [["single", ["appliedenergistics2:material", 2, 7]]],
      "duration": 100,
      "power": 100
    },
    {
      "name": "chem.fallenstar_xp",
      "inputItem": [["item", "nyx:fallen_star", 1]],
      "outputFluid": [["XPJUICE", 1000]],
      "duration": 100,
      "power": 100
    },
    '''
def chemicalPlantFile = new File('config/hbmRecipes/hbmChemicalPlant.json')
mods.hbm.recipeOverrides.override('hbmChemicalPlant',
    chemicalPlantFile.text.replaceFirst(/"recipes"\s*:\s*\[/, '"recipes": [' + ae2ChemicalPlantRecipes))
