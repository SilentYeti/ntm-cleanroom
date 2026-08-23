// ============================================================================
// AE2 <-> NTM integration recipes
// Ported from scripts/schizophrenia_ae2.zs (CraftTweaker) to GroovyScript.
// See that file's header for the full damage-value research notes (every
// appliedenergistics2:material/part meta below was verified against both the
// source pack's and this pack's AE2 jar bytecode, not guessed).
//
// Reference (AE2UEL true damage values):
//   Material: CERTUS_QUARTZ_CRYSTAL=0, CERTUS_QUARTZ_CRYSTAL_CHARGED=1,
//     CERTUS_QUARTZ_DUST=2, NETHER_QUARTZ_DUST=3, FLOUR=4, SILICON=5,
//     MATTER_BALL=6, FLUIX_CRYSTAL=7, FLUIX_DUST=8, FLUIX_PEARL=9,
//     PURIFIED_CERTUS_QUARTZ_CRYSTAL=10, PURIFIED_NETHER_QUARTZ_CRYSTAL=11,
//     PURIFIED_FLUIX_CRYSTAL=12, CALCULATION_PROCESSOR_PRESS=13,
//     ENGINEERING_PROCESSOR_PRESS=14, LOGIC_PROCESSOR_PRESS=15,
//     CALCULATION_PROCESSOR_PRINT=16, ENGINEERING_PROCESSOR_PRINT=17,
//     LOGIC_PROCESSOR_PRINT=18, SILICON_PRESS=19, SILICON_PRINT=20,
//     NAME_PRESS=21, LOGIC_PROCESSOR=22, CALCULATION_PROCESSOR=23,
//     ENGINEERING_PROCESSOR=24, BASIC_CARD=25, CARD_REDSTONE=26,
//     CARD_CAPACITY=27, ADVANCED_CARD=28, CARD_FUZZY=29, CARD_SPEED=30,
//     CARD_INVERTER=31, CELL2_SPATIAL_PART=32, CELL16_SPATIAL_PART=33,
//     CELL128_SPATIAL_PART=34, CELL1K_PART=35, CELL4K_PART=36,
//     CELL16K_PART=37, CELL64K_PART=38, EMPTY_STORAGE_CELL=39,
//     WOODEN_GEAR=40, WIRELESS=41, WIRELESS_BOOSTER=42, FORMATION_CORE=43,
//     ANNIHILATION_CORE=44, SKY_DUST=45, ENDER_DUST=46, SINGULARITY=47,
//     QUANTUM_ENTANGLED_SINGULARITY=48, IRON_DUST=49, GOLD_DUST=51,
//     BLANK_PATTERN=52, CARD_CRAFTING=53
//   Part: CABLE_GLASS=0, CABLE_COVERED=20, CABLE_SMART=40,
//     CABLE_DENSE_SMART=60, TOGGLE_BUS=80, INVERTED_TOGGLE_BUS=100,
//     CABLE_ANCHOR=120, QUARTZ_FIBER=140, MONITOR=160,
//     SEMI_DARK_MONITOR=180, DARK_MONITOR=200, STORAGE_BUS=220,
//     IMPORT_BUS=240, EXPORT_BUS=260, LEVEL_EMITTER=280,
//     ANNIHILATION_PLANE=300, FORMATION_PLANE=320, PATTERN_TERMINAL=340,
//     CRAFTING_TERMINAL=360, TERMINAL=380, STORAGE_MONITOR=400,
//     CONVERSION_MONITOR=420, INTERFACE=440, P2P_TUNNEL_ME=460,
//     INTERFACE_TERMINAL=480
//
// part:16 is used throughout as a generic "cable" filler ingredient.
// ============================================================================

// --- Charger ---
crafting.removeByOutput(item('appliedenergistics2:charger'))
crafting.addShaped(item('appliedenergistics2:charger'),
    [[ore('plateSteel'), ore('crystalFluix'), ore('plateSteel')],
     [ore('ingotSteel'), null, null],
     [ore('plateSteel'), ore('crystalFluix'), ore('plateSteel')]])

// --- Energy Acceptor ---
crafting.removeByOutput(item('appliedenergistics2:energy_acceptor'))
crafting.addShaped(item('appliedenergistics2:energy_acceptor'),
    [[ore('plateSteel'), ore('crystalFluix'), ore('plateSteel')],
     [ore('crystalFluix'), item('hbm:glass_quartz'), ore('crystalFluix')],
     [ore('plateSteel'), ore('crystalFluix'), ore('plateSteel')]])

// --- Energy Cell ---
crafting.removeByOutput(item('appliedenergistics2:energy_cell'))
crafting.addShaped(item('appliedenergistics2:energy_cell'),
    [[ore('crystalChargedCertusQuartz'), ore('dustFluix'), ore('crystalChargedCertusQuartz')],
     [ore('dustFluix'), item('hbm:glass_quartz'), ore('dustFluix')],
     [ore('crystalChargedCertusQuartz'), ore('dustFluix'), ore('crystalChargedCertusQuartz')]])

// --- Cell Workbench (ingredient: CalcProcessor=23, matches source exactly) ---
crafting.removeByOutput(item('appliedenergistics2:cell_workbench'))
crafting.addShaped(item('appliedenergistics2:cell_workbench'),
    [[ore('plateTripleSteel'), item('appliedenergistics2:material', 23), ore('plateTripleSteel')],
     [ore('ingotSteel'), item('minecraft:chest'), ore('ingotSteel')],
     [ore('ingotSteel'), ore('ingotSteel'), ore('ingotSteel')]])

// --- Network Tool ---
crafting.removeByOutput(item('appliedenergistics2:network_tool'))
crafting.addShaped(item('appliedenergistics2:network_tool'),
    [[null, item('appliedenergistics2:part', 16), null],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:certus_quartz_wrench'), item('appliedenergistics2:part', 16)],
     [null, item('appliedenergistics2:part', 16), null]])

// --- Molecular Assembler (ingredient: LogicProcessor=22, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:molecular_assembler'))
crafting.addShaped(item('appliedenergistics2:molecular_assembler'),
    [[ore('plateTripleSteel'), item('hbm:glass_quartz'), ore('plateTripleSteel')],
     [item('appliedenergistics2:material', 22), item('hbm:machine_autocrafter'), item('appliedenergistics2:material', 22)],
     [ore('plateTripleSteel'), item('hbm:glass_quartz'), ore('plateTripleSteel')]])

// --- Crafting Unit (CalcProcessor=23 outer, LogicProcessor=22 center, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:crafting_unit'))
crafting.addShaped(item('appliedenergistics2:crafting_unit'),
    [[ore('plateTripleSteel'), item('appliedenergistics2:material', 23), ore('plateTripleSteel')],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:material', 22), item('appliedenergistics2:part', 16)],
     [ore('plateTripleSteel'), item('appliedenergistics2:material', 23), ore('plateTripleSteel')]])

// --- Crystal Growth Accelerator ---
crafting.removeByOutput(item('appliedenergistics2:quartz_growth_accelerator'))
crafting.addShaped(item('appliedenergistics2:quartz_growth_accelerator'),
    [[ore('plateTripleSteel'), item('appliedenergistics2:part', 16), ore('plateTripleSteel')],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:fluix_block'), item('appliedenergistics2:part', 16)],
     [ore('plateTripleSteel'), item('appliedenergistics2:part', 16), ore('plateTripleSteel')]])

// --- Matter Condenser ---
crafting.removeByOutput(item('appliedenergistics2:condenser'))
crafting.addShaped(item('appliedenergistics2:condenser'),
    [[ore('plateSextupleSteel'), item('hbm:glass_quartz'), ore('plateSextupleSteel')],
     [item('hbm:glass_quartz'), ore('dustFluix'), item('hbm:glass_quartz')],
     [ore('plateSextupleSteel'), item('hbm:glass_quartz'), ore('plateSextupleSteel')]])

// --- ME IO Port (ingredient: LogicProcessor=22, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:io_port'))
crafting.addShaped(item('appliedenergistics2:io_port'),
    [[item('hbm:glass_quartz'), item('hbm:glass_quartz'), item('hbm:glass_quartz')],
     [item('appliedenergistics2:drive'), item('appliedenergistics2:part', 16), item('appliedenergistics2:drive')],
     [ore('plateSextupleSteel'), item('appliedenergistics2:material', 22), ore('plateSextupleSteel')]])

// --- ME Interface (standalone block form, ingredient: LogicProcessor=22 x2, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:interface'))
crafting.remove('appliedenergistics2:network/blocks/interfaces_interface')
crafting.remove('appliedenergistics2:network/blocks/interfaces_interface_alt')
crafting.addShaped(item('appliedenergistics2:interface'),
    [[ore('ingotSteel'), ore('plateTripleSteel'), ore('ingotSteel')],
     [item('appliedenergistics2:material', 22), item('appliedenergistics2:part', 16), item('appliedenergistics2:material', 22)],
     [ore('ingotSteel'), ore('plateTripleSteel'), ore('ingotSteel')]])

// --- ME Chest (ingredient: Terminal part=380, CalcProcessor=23, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:chest'))
crafting.addShaped(item('appliedenergistics2:chest'),
    [[item('hbm:glass_quartz'), item('appliedenergistics2:part', 380), item('hbm:glass_quartz')],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:material', 23), item('appliedenergistics2:part', 16)],
     [ore('plateSextupleSteel'), ore('crystalPureFluix'), ore('plateSextupleSteel')]])

// --- Spatial IO Port (ingredient: EngProcessor=24, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:spatial_io_port'))
crafting.addShaped(item('appliedenergistics2:spatial_io_port'),
    [[item('hbm:glass_quartz'), item('hbm:glass_quartz'), item('hbm:glass_quartz')],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:io_port'), item('appliedenergistics2:part', 16)],
     [ore('plateSextupleSteel'), item('appliedenergistics2:material', 24), ore('plateSextupleSteel')]])

// --- Spatial Pylon ---
crafting.removeByOutput(item('appliedenergistics2:spatial_pylon'))
crafting.addShaped(item('appliedenergistics2:spatial_pylon'),
    [[item('hbm:glass_quartz'), item('appliedenergistics2:part', 16), item('hbm:glass_quartz')],
     [ore('dustFluix'), ore('crystalPureFluix'), ore('dustFluix')],
     [item('hbm:glass_quartz'), item('appliedenergistics2:part', 16), item('hbm:glass_quartz')]])

// --- ME Security Terminal (Security Station) ---
// Source used Cell16kPart=37 and EngProcessor=24.
crafting.removeByOutput(item('appliedenergistics2:security_station'))
crafting.addShaped(item('appliedenergistics2:security_station'),
    [[ore('plateSextupleSteel'), item('appliedenergistics2:chest'), ore('plateSextupleSteel')],
     [item('appliedenergistics2:part', 16), item('appliedenergistics2:material', 37), item('appliedenergistics2:part', 16)],
     [ore('plateSextupleSteel'), item('appliedenergistics2:material', 24), ore('plateSextupleSteel')]])

// --- ME Controller ---
crafting.removeByOutput(item('appliedenergistics2:controller'))
crafting.addShaped(item('appliedenergistics2:controller'),
    [[ore('plateSextupleSteel'), ore('crystalPureFluix'), ore('plateSextupleSteel')],
     [ore('crystalPureFluix'), item('hbm:circuit', 0), ore('crystalPureFluix')],
     [ore('plateSextupleSteel'), ore('crystalPureFluix'), ore('plateSextupleSteel')]])

// --- ME Drive (ingredient: EngProcessor=24 x2, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:drive'))
crafting.addShaped(item('appliedenergistics2:drive'),
    [[ore('plateTripleSteel'), item('appliedenergistics2:material', 24), ore('plateTripleSteel')],
     [item('appliedenergistics2:part', 16), null, item('appliedenergistics2:part', 16)],
     [ore('plateTripleSteel'), item('appliedenergistics2:material', 24), ore('plateTripleSteel')]])

// --- Quantum Ring (EngProcessor=24 outer x2, LogicProcessor=22 sides x2, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:quantum_ring'))
crafting.addShaped(item('appliedenergistics2:quantum_ring'),
    [[ore('plateTripleSteel'), item('appliedenergistics2:material', 24), ore('plateTripleSteel')],
     [item('appliedenergistics2:material', 22), item('appliedenergistics2:energy_cell'), item('appliedenergistics2:material', 22)],
     [ore('plateTripleSteel'), item('appliedenergistics2:material', 24), ore('plateTripleSteel')]])

// --- Quantum Link Chamber ---
crafting.removeByOutput(item('appliedenergistics2:quantum_link'))
crafting.addShaped(item('appliedenergistics2:quantum_link'),
    [[item('hbm:glass_quartz'), ore('pearlFluix'), item('hbm:glass_quartz')],
     [ore('pearlFluix'), item('hbm:circuit', 16), ore('pearlFluix')],
     [item('hbm:glass_quartz'), ore('pearlFluix'), item('hbm:glass_quartz')]])

// --- View Cell ---
crafting.removeByOutput(item('appliedenergistics2:view_cell'))
crafting.remove('appliedenergistics2:network/cells/view_cell')
crafting.remove('appliedenergistics2:network/cells/view_cell_storage')
crafting.addShaped(item('appliedenergistics2:view_cell'),
    [[item('hbm:glass_quartz'), ore('dustRedstone'), item('hbm:glass_quartz')],
     [ore('dustRedstone'), ore('crystalCertusQuartz'), ore('dustRedstone')],
     [ore('ingotSteel'), ore('ingotSteel'), ore('ingotSteel')]])

// --- Memory Card (ingredient: CalcProcessor=23, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:memory_card'))
crafting.addShaped(item('appliedenergistics2:memory_card'),
    [[item('appliedenergistics2:material', 23), ore('ingotSteel'), ore('ingotSteel')],
     [ore('ingotSteel'), ore('dustRedstone'), ore('ingotSteel')]])

// --- Biometric Card (ingredient: EngProcessor=24, matches source) ---
crafting.removeByOutput(item('appliedenergistics2:biometric_card'))
crafting.addShaped(item('appliedenergistics2:biometric_card'),
    [[item('appliedenergistics2:material', 24), ore('ingotSteel'), ore('ingotSteel')],
     [ore('ingotSteel'), ore('dustRedstone'), ore('ingotSteel')]])

// --- Color Applicator (ingredient: Cell1kPart=35, matches source exactly) ---
crafting.removeByOutput(item('appliedenergistics2:color_applicator'))
crafting.addShaped(item('appliedenergistics2:color_applicator'),
    [[null, ore('ingotSteel'), null],
     [ore('ingotSteel'), item('appliedenergistics2:material', 35), null],
     [null, null, item('appliedenergistics2:energy_cell')]])

// --- Acceleration Card (Card Speed = AdvCard + Fluix, matches source exactly) ---
crafting.removeByOutput(item('appliedenergistics2:material', 30))
crafting.addShapeless(item('appliedenergistics2:material', 30),
    [item('appliedenergistics2:material', 28), ore('crystalFluix')])

// --- Blank Pattern (x4) ---
crafting.removeByOutput(item('appliedenergistics2:material', 52))
crafting.addShaped(item('appliedenergistics2:material', 52) * 4,
    [[null, ore('ingotAnyHardPlastic'), null],
     [ore('ingotAnyHardPlastic'), item('hbm:circuit', 5), ore('ingotAnyHardPlastic')],
     [null, ore('ingotAnyHardPlastic'), null]])

// --- Sky Stone Block (x16, meteor removed - crafted directly) ---
// No removeByOutput here: AE2UEL doesn't register a default crafting-table
// recipe for this at all in this pack ("No recipes found for
// 1xtile.appliedenergistics2.sky_stone_block@0" at runtime) - CraftTweaker's
// recipes.remove() silently no-ops on a miss, GroovyScript just isn't quiet
// about it.
crafting.addShaped(item('appliedenergistics2:sky_stone_block') * 16,
    [[null, item('hbm:fragment_meteorite'), null],
     [item('hbm:fragment_meteorite'), ore('cobblestone'), item('hbm:fragment_meteorite')],
     [null, item('hbm:fragment_meteorite'), null]])

// --- Basic Card (material 25) ---
crafting.removeByOutput(item('appliedenergistics2:material', 25))
crafting.addShaped(item('appliedenergistics2:material', 25),
    [[ore('ingotGold'), ore('ingotSteel'), null],
     [ore('dustRedstone'), item('appliedenergistics2:material', 23), ore('ingotSteel')],
     [ore('ingotGold'), ore('ingotSteel'), null]])

// --- Redstone Card (material 26, from Basic Card) ---
crafting.removeByOutput(item('appliedenergistics2:material', 26))
crafting.addShaped(item('appliedenergistics2:material', 26),
    [[item('appliedenergistics2:material', 25), item('minecraft:redstone_torch')]])

// --- Advanced Card (material 28) ---
crafting.removeByOutput(item('appliedenergistics2:material', 28))
crafting.addShaped(item('appliedenergistics2:material', 28),
    [[ore('gemDiamond'), ore('ingotSteel'), null],
     [ore('dustRedstone'), item('appliedenergistics2:material', 23), ore('ingotSteel')],
     [ore('gemDiamond'), ore('ingotSteel'), null]])

// --- ME Storage Housing / Empty Storage Cell (material 39) ---
crafting.removeByOutput(item('appliedenergistics2:material', 39))
crafting.addShaped(item('appliedenergistics2:material', 39),
    [[item('hbm:glass_quartz'), item('hbm:glass_quartz'), item('hbm:glass_quartz')],
     [ore('dustRedstone'), null, ore('dustRedstone')],
     [ore('ingotSteel'), item('hbm:ingot_steel'), item('hbm:ingot_steel')]])

// --- Wireless Receiver (material 41, uses Quartz Fiber part=140) ---
crafting.removeByOutput(item('appliedenergistics2:material', 41))
crafting.addShaped(item('appliedenergistics2:material', 41),
    [[null, ore('pearlFluix'), null],
     [ore('ingotSteel'), item('appliedenergistics2:part', 140), ore('ingotSteel')],
     [null, ore('ingotSteel'), null]])

// --- Wireless Booster (material 42) ---
crafting.removeByOutput(item('appliedenergistics2:material', 42))
crafting.addShaped(item('appliedenergistics2:material', 42),
    [[ore('dustFluix'), ore('crystalCertusQuartz'), ore('dustEnder')],
     [ore('ingotSteel'), ore('ingotSteel'), ore('ingotSteel')]])

// --- ME Terminal (part 380, uses Logic Processor=22) ---
crafting.removeByOutput(item('appliedenergistics2:part', 380))
crafting.addShaped(item('appliedenergistics2:part', 380),
    [[item('appliedenergistics2:material', 22), ore('itemIlluminatedPanel'), item('appliedenergistics2:material', 22)]])

// --- ME Import Bus (part 240, uses Eng Processor=24) ---
crafting.removeByOutput(item('appliedenergistics2:part', 240))
crafting.addShaped(item('appliedenergistics2:part', 240),
    [[null, item('appliedenergistics2:material', 24), null],
     [ore('ingotSteel'), item('minecraft:piston'), ore('ingotSteel')]])

// --- ME Export Bus (part 260, uses Logic Processor=22) ---
crafting.removeByOutput(item('appliedenergistics2:part', 260))
crafting.addShaped(item('appliedenergistics2:part', 260),
    [[ore('ingotSteel'), item('appliedenergistics2:material', 22), ore('ingotSteel')],
     [null, item('minecraft:piston'), null]])

// --- P2P Tunnel - ME (part 460, uses Eng Processor=24) ---
crafting.removeByOutput(item('appliedenergistics2:part', 460))
crafting.addShaped(item('appliedenergistics2:part', 460),
    [[null, ore('ingotSteel'), null],
     [ore('ingotSteel'), item('appliedenergistics2:material', 24), ore('ingotSteel')],
     [ore('crystalFluix'), ore('crystalFluix'), ore('crystalFluix')]])

// --- Illuminated Panel (Semi Dark Monitor, part 180, x3) ---
crafting.removeByOutput(item('appliedenergistics2:part', 180))
crafting.remove('appliedenergistics2:network/parts/panels_semi_dark_monitor')
crafting.remove('appliedenergistics2:network/parts/panels_semi_dark_monitor_alt')
crafting.addShaped(item('appliedenergistics2:part', 180) * 3,
    [[null, ore('dustGlowstone'), item('hbm:glass_quartz')],
     [ore('ingotSteel'), ore('dustRedstone'), item('hbm:glass_quartz')],
     [null, ore('dustGlowstone'), item('hbm:glass_quartz')]])

// --- ME Annihilation Plane (part 300, uses Logic Processor=22) ---
crafting.removeByOutput(item('appliedenergistics2:part', 300))
crafting.remove('appliedenergistics2:network/parts/planes_annihilation_alt')
crafting.remove('appliedenergistics2:network/parts/planes_annihilation_alt2')
crafting.addShaped(item('appliedenergistics2:part', 300),
    [[ore('crystalFluix'), ore('crystalFluix'), ore('crystalFluix')],
     [ore('plateTripleSteel'), item('appliedenergistics2:material', 22), ore('plateTripleSteel')]])

// --- ME Formation Plane (part 320, uses Eng Processor=24) ---
crafting.removeByOutput(item('appliedenergistics2:part', 320))
crafting.remove('appliedenergistics2:network/parts/planes_formation')
crafting.remove('appliedenergistics2:network/parts/planes_formation_alt')
crafting.addShaped(item('appliedenergistics2:part', 320),
    [[ore('crystalFluix'), ore('crystalFluix'), ore('crystalFluix')],
     [ore('plateTripleSteel'), item('appliedenergistics2:material', 24), ore('plateTripleSteel')]])

// --- ME Conversion Monitor (part 420, uses Storage Monitor=400, Eng/Logic Processor) ---
crafting.removeByOutput(item('appliedenergistics2:part', 420))
crafting.addShaped(item('appliedenergistics2:part', 420),
    [[item('appliedenergistics2:material', 24), item('appliedenergistics2:part', 400), item('appliedenergistics2:material', 22)]])

// ============================================================================
// Machine-exclusive items: the source pack removed the vanilla crafting-
// table recipe for these entirely and moved them to NTM machines (Assembly
// Machine for the intermediate "Part" components, Arc Welder for the
// finished cells). The actual machine recipes live in
// config/hbmRecipes/hbmAssemblyMachine.json and hbmArcWelder.json (left as
// raw JSON - see the GroovyScript conversion writeup for why those two
// weren't ported to script form). This section only strips AE2UEL's default
// vanilla recipe so they can't be crafted the "normal" AE2 way anymore.
//
// AE2UEL registers storage/spatial cells (and their Part components) using
// custom recipe types with condition blocks, and each item has TWO separate
// vanilla recipes (a "full" shaped one, and a "_storage" shapeless shortcut
// that just combines the Part + Empty Storage Cell directly) - both survive
// output-based removal, so both the item-based and exact-name-based removes
// are kept below, same as the CraftTweaker original.
// ============================================================================
crafting.removeByOutput(item('appliedenergistics2:material', 35)) // Cell1kPart
crafting.removeByOutput(item('appliedenergistics2:material', 36)) // Cell4kPart
crafting.removeByOutput(item('appliedenergistics2:material', 37)) // Cell16kPart
crafting.removeByOutput(item('appliedenergistics2:material', 38)) // Cell64kPart
crafting.removeByOutput(item('appliedenergistics2:material', 32)) // Cell2SpatialPart
crafting.removeByOutput(item('appliedenergistics2:material', 33)) // Cell16SpatialPart
crafting.removeByOutput(item('appliedenergistics2:material', 34)) // Cell128SpatialPart
crafting.removeByOutput(item('appliedenergistics2:storage_cell_1k'))
crafting.removeByOutput(item('appliedenergistics2:storage_cell_4k'))
crafting.removeByOutput(item('appliedenergistics2:storage_cell_16k'))
crafting.removeByOutput(item('appliedenergistics2:storage_cell_64k'))
crafting.removeByOutput(item('appliedenergistics2:spatial_storage_cell_2_cubed'))
crafting.removeByOutput(item('appliedenergistics2:spatial_storage_cell_16_cubed'))
crafting.removeByOutput(item('appliedenergistics2:spatial_storage_cell_128_cubed'))

crafting.remove('appliedenergistics2:network/cells/storage_cell_1k')
crafting.remove('appliedenergistics2:network/cells/storage_cell_1k_storage')
crafting.remove('appliedenergistics2:network/cells/storage_cell_4k')
crafting.remove('appliedenergistics2:network/cells/storage_cell_4k_storage')
crafting.remove('appliedenergistics2:network/cells/storage_cell_16k')
crafting.remove('appliedenergistics2:network/cells/storage_cell_16k_storage')
crafting.remove('appliedenergistics2:network/cells/storage_cell_64k')
crafting.remove('appliedenergistics2:network/cells/storage_cell_64k_storage')
crafting.remove('appliedenergistics2:network/cells/storage_components_cell_1k_part')
crafting.remove('appliedenergistics2:network/cells/storage_components_cell_4k_part')
crafting.remove('appliedenergistics2:network/cells/storage_components_cell_16k_part')
crafting.remove('appliedenergistics2:network/cells/storage_components_cell_64k_part')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_2_cubed')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_2_cubed_storage')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_16_cubed')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_16_cubed_storage')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_128_cubed')
crafting.remove('appliedenergistics2:network/cells/spatial_storage_cell_128_cubed_storage')
crafting.remove('appliedenergistics2:network/cells/spatial_components')
crafting.remove('appliedenergistics2:network/cells/spatial_components_0')
crafting.remove('appliedenergistics2:network/cells/spatial_components_1')

// ============================================================================
// Intentionally NOT ported - no equivalent item exists in AE2UEL v0.56.7:
//   - Extended storage cell tiers (256k/1024k/4096k/16384k, Extreme/Advanced
//     Storage Cell, Singularity/Advanced Crafting Storage) - GTNH-only tiers.
//   - Overflow Void Card (material 68), Pattern Capacity Card as a distinct
//     item (material 54, GTNH-only) - AE2UEL reuses Capacity Card (27) for
//     both purposes, so its default recipe was left untouched rather than
//     overridden (it's still needed for storage cells).
//   - Void Storage Cell (ItemVoidStorageCell) - removed from mainline AE2
//     since 1.7.10, not present in AE2UEL.
//   - Pattern Repeater (part 473), Storage Reshuffle block, and the
//     unnamed ItemMultiPart:36 output - GTNH-specific parts with no
//     matching enum constant in either the old or new decompiled tables.
// ============================================================================

// ============================================================================
// Remove the AE2 Inscriber recipes for the Logic/Calculation/Engineering
// Processor chain (Press -> Print -> Processor) and the Silicon Press/Print
// steps - the Press+Soldering chain above replaces this entire pipeline, so
// leaving both active would let players bypass the NTM-gated path entirely.
//
// The Inscriber does NOT use the vanilla recipe registry - GroovyScript
// exposes a dedicated binding for it (mods.appliedenergistics2.inscriber),
// confirmed against CleanroomMC's GroovyScript docs.
// ============================================================================
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 19)) // Silicon Press
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 20)) // Silicon Print
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 13)) // Calculation Processor Press
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 16)) // Calculation Processor Print
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 23)) // Calculation Processor
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 14)) // Engineering Processor Press
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 17)) // Engineering Processor Print
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 24)) // Engineering Processor
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 15)) // Logic Processor Press
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 18)) // Logic Processor Print
mods.appliedenergistics2.inscriber.removeByOutput(item('appliedenergistics2:material', 22)) // Logic Processor
// NOT touched: card_magnet / card_quantum_link inscriber recipes - these are
// AE2UEL-only cards with no NTM-side replacement, no overlap to remove.
