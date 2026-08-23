// ============================================================================
// Arc Welder: combine each AE2 storage/spatial cell Part + an Empty Storage
// Cell (material:39) into the finished cell.
//
// Split out of schizophrenia_ae2.groovy into its own file (one file per NTM
// machine). See schizophrenia_ntm_assemblymachine.groovy's header for the
// full explanation of the override(target, json)-replaces-not-merges
// mechanism, the "exactly one script may own a given target" rule, and why
// no JSON library is used here.
//
// TARGET NAME NOT VERIFIED against a live session - 'hbmArcWelder' is my
// best read of the config file's own name. If this errors, run
// `log.info(mods.hbm.recipeOverrides.listTargets())` once and check
// logs/groovy.log for the accepted name.
//
// Schema (from the real file): inputs (list of [type, item, count?, meta?])
// / output ([item, count?]) / duration (ticks) / consumption (per tick).
// No "name" field for this machine, unlike Assembly Machine/Chemical Plant.
// ============================================================================

def ae2ArcWelderRecipes = '''
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 35], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:storage_cell_1k"],
   "duration": 100,
   "consumption": 2000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 36], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:storage_cell_4k"],
   "duration": 300,
   "consumption": 10000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 37], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:storage_cell_16k"],
   "duration": 400,
   "consumption": 500000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 38], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:storage_cell_64k"],
   "duration": 600,
   "consumption": 2500000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 32], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:spatial_storage_cell_2_cubed"],
   "duration": 100,
   "consumption": 2000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 33], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:spatial_storage_cell_16_cubed"],
   "duration": 300,
   "consumption": 10000
  },
  {
   "inputs": [["item", "appliedenergistics2:material", 1, 34], ["item", "appliedenergistics2:material", 1, 39]],
   "output": ["appliedenergistics2:spatial_storage_cell_128_cubed"],
   "duration": 400,
   "consumption": 500000
  },'''
def arcWelderFile = new File('config/hbmRecipes/hbmArcWelder.json')
mods.hbm.recipeOverrides.override('hbmArcWelder',
    arcWelderFile.text.replaceFirst(/"recipes"\s*:\s*\[/, '"recipes": [' + ae2ArcWelderRecipes))
