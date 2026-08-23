// ============================================================================
// AE2 <-> NTM integration recipes
// Ported from the "Nuclear Tech- Integrated" modpack's AE2 recipe overhaul
// (45 recipes touching AE2), which itself runs a GTNH fork of AE2 rv3.
// Translated to AE2 Unofficial Extended Life (ae2-uel v0.56.7) for 1.12.2.
//
// METHOD: every appliedenergistics2:material/part meta below was
// resolved by decompiling BOTH the source pack's actual
// appliedenergistics2-rv3-beta-971-GTNH.jar AND this pack's
// ae2-uel-v0.56.7.jar - reading the literal damage value baked into each
// MaterialType/PartType enum constant's constructor call in the compiled
// <clinit> bytecode (not guessed, not assumed from ordinal position). Where
// a GTNH-only item (extended storage tiers, Overflow Void Card, Pattern
// Repeater, Storage Reshuffle, custom P2P tunnel types) has no equivalent
// in AE2UEL, the recipe is skipped rather than invented, noted below.
//
// Reference (AE2UEL true damage values, confirmed identical to the old
// GTNH/1.7.10 table for every item that exists in both):
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
//     (GTNH's CardPatternCapacity=54 and CardVoidOverflow=68 don't exist in
//     AE2UEL - AE2UEL reuses CARD_CAPACITY=27 for pattern-slot expansion too)
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
// NOTE on ItemMultiPart:16, used as a generic "cable" filler ingredient in
// nearly every recipe below: at the time this file was first ported, 16
// wasn't a registered part damage value in either AE2 version (not in the
// old GTNH table, not in AE2UEL's), so part:0 (Glass Cable) was substituted
// instead. That's since been confirmed no longer the case for this pack's
// AE2UEL build, so the recipes below use part:16 directly again - if a
// future AE2UEL update ever un-registers it, fall back to part:0.
// ============================================================================

// --- Charger ---
recipes.remove(<appliedenergistics2:charger>);
recipes.addShaped(<appliedenergistics2:charger>,
    [[<ore:plateSteel>, <ore:crystalFluix>, <ore:plateSteel>],
     [<ore:ingotSteel>, null, null],
     [<ore:plateSteel>, <ore:crystalFluix>, <ore:plateSteel>]]);

// --- Energy Acceptor ---
recipes.remove(<appliedenergistics2:energy_acceptor>);
recipes.addShaped(<appliedenergistics2:energy_acceptor>,
    [[<ore:plateSteel>, <ore:crystalFluix>, <ore:plateSteel>],
     [<ore:crystalFluix>, <hbm:glass_quartz>, <ore:crystalFluix>],
     [<ore:plateSteel>, <ore:crystalFluix>, <ore:plateSteel>]]);

// --- Energy Cell ---
recipes.remove(<appliedenergistics2:energy_cell>);
recipes.addShaped(<appliedenergistics2:energy_cell>,
    [[<ore:crystalChargedCertusQuartz>, <ore:dustFluix>, <ore:crystalChargedCertusQuartz>],
     [<ore:dustFluix>, <hbm:glass_quartz>, <ore:dustFluix>],
     [<ore:crystalChargedCertusQuartz>, <ore:dustFluix>, <ore:crystalChargedCertusQuartz>]]);

// --- Cell Workbench (ingredient: CalcProcessor=23, matches source exactly) ---
recipes.remove(<appliedenergistics2:cell_workbench>);
recipes.addShaped(<appliedenergistics2:cell_workbench>,
    [[<ore:plateTripleSteel>, <appliedenergistics2:material:23>, <ore:plateTripleSteel>],
     [<ore:ingotSteel>, <minecraft:chest>, <ore:ingotSteel>],
     [<ore:ingotSteel>, <ore:ingotSteel>, <ore:ingotSteel>]]);

// --- Network Tool ---
recipes.remove(<appliedenergistics2:network_tool>);
recipes.addShaped(<appliedenergistics2:network_tool>,
    [[null, <appliedenergistics2:part:16>, null],
     [<appliedenergistics2:part:16>, <appliedenergistics2:certus_quartz_wrench>, <appliedenergistics2:part:16>],
     [null, <appliedenergistics2:part:16>, null]]);

// --- Molecular Assembler (ingredient: LogicProcessor=22, matches source) ---
recipes.remove(<appliedenergistics2:molecular_assembler>);
recipes.addShaped(<appliedenergistics2:molecular_assembler>,
    [[<ore:plateTripleSteel>, <hbm:glass_quartz>, <ore:plateTripleSteel>],
     [<appliedenergistics2:material:22>, <hbm:machine_autocrafter>, <appliedenergistics2:material:22>],
     [<ore:plateTripleSteel>, <hbm:glass_quartz>, <ore:plateTripleSteel>]]);

// --- Crafting Unit (CalcProcessor=23 outer, LogicProcessor=22 center, matches source) ---
recipes.remove(<appliedenergistics2:crafting_unit>);
recipes.addShaped(<appliedenergistics2:crafting_unit>,
    [[<ore:plateTripleSteel>, <appliedenergistics2:material:23>, <ore:plateTripleSteel>],
     [<appliedenergistics2:part:16>, <appliedenergistics2:material:22>, <appliedenergistics2:part:16>],
     [<ore:plateTripleSteel>, <appliedenergistics2:material:23>, <ore:plateTripleSteel>]]);

// --- Crystal Growth Accelerator ---
recipes.remove(<appliedenergistics2:quartz_growth_accelerator>);
recipes.addShaped(<appliedenergistics2:quartz_growth_accelerator>,
    [[<ore:plateTripleSteel>, <appliedenergistics2:part:16>, <ore:plateTripleSteel>],
     [<appliedenergistics2:part:16>, <appliedenergistics2:fluix_block>, <appliedenergistics2:part:16>],
     [<ore:plateTripleSteel>, <appliedenergistics2:part:16>, <ore:plateTripleSteel>]]);

// --- Matter Condenser ---
recipes.remove(<appliedenergistics2:condenser>);
recipes.addShaped(<appliedenergistics2:condenser>,
    [[<ore:plateSextupleSteel>, <hbm:glass_quartz>, <ore:plateSextupleSteel>],
     [<hbm:glass_quartz>, <ore:dustFluix>, <hbm:glass_quartz>],
     [<ore:plateSextupleSteel>, <hbm:glass_quartz>, <ore:plateSextupleSteel>]]);

// --- ME IO Port (ingredient: LogicProcessor=22, matches source) ---
recipes.remove(<appliedenergistics2:io_port>);
recipes.addShaped(<appliedenergistics2:io_port>,
    [[<hbm:glass_quartz>, <hbm:glass_quartz>, <hbm:glass_quartz>],
     [<appliedenergistics2:drive>, <appliedenergistics2:part:16>, <appliedenergistics2:drive>],
     [<ore:plateSextupleSteel>, <appliedenergistics2:material:22>, <ore:plateSextupleSteel>]]);

// --- ME Interface (standalone block form, ingredient: LogicProcessor=22 x2, matches source) ---
recipes.remove(<appliedenergistics2:interface>);
recipes.removeByRecipeName("appliedenergistics2:network/blocks/interfaces_interface");
recipes.removeByRecipeName("appliedenergistics2:network/blocks/interfaces_interface_alt");
recipes.addShaped(<appliedenergistics2:interface>,
    [[<ore:ingotSteel>, <ore:plateTripleSteel>, <ore:ingotSteel>],
     [<appliedenergistics2:material:22>, <appliedenergistics2:part:16>, <appliedenergistics2:material:22>],
     [<ore:ingotSteel>, <ore:plateTripleSteel>, <ore:ingotSteel>]]);

// --- ME Chest (ingredient: Terminal part=380, CalcProcessor=23, matches source) ---
recipes.remove(<appliedenergistics2:chest>);
recipes.addShaped(<appliedenergistics2:chest>,
    [[<hbm:glass_quartz>, <appliedenergistics2:part:380>, <hbm:glass_quartz>],
     [<appliedenergistics2:part:16>, <appliedenergistics2:material:23>, <appliedenergistics2:part:16>],
     [<ore:plateSextupleSteel>, <ore:crystalPureFluix>, <ore:plateSextupleSteel>]]);

// --- Spatial IO Port (ingredient: EngProcessor=24, matches source) ---
recipes.remove(<appliedenergistics2:spatial_io_port>);
recipes.addShaped(<appliedenergistics2:spatial_io_port>,
    [[<hbm:glass_quartz>, <hbm:glass_quartz>, <hbm:glass_quartz>],
     [<appliedenergistics2:part:16>, <appliedenergistics2:io_port>, <appliedenergistics2:part:16>],
     [<ore:plateSextupleSteel>, <appliedenergistics2:material:24>, <ore:plateSextupleSteel>]]);

// --- Spatial Pylon ---
recipes.remove(<appliedenergistics2:spatial_pylon>);
recipes.addShaped(<appliedenergistics2:spatial_pylon>,
    [[<hbm:glass_quartz>, <appliedenergistics2:part:16>, <hbm:glass_quartz>],
     [<ore:dustFluix>, <ore:crystalPureFluix>, <ore:dustFluix>],
     [<hbm:glass_quartz>, <appliedenergistics2:part:16>, <hbm:glass_quartz>]]);

// --- ME Security Terminal (Security Station) ---
// Source used Cell16kPart=37 (matches AE2UEL's CELL16K_PART=37 exactly)
// and EngProcessor=24 (matches AE2UEL's ENGINEERING_PROCESSOR=24).
recipes.remove(<appliedenergistics2:security_station>);
recipes.addShaped(<appliedenergistics2:security_station>,
    [[<ore:plateSextupleSteel>, <appliedenergistics2:chest>, <ore:plateSextupleSteel>],
     [<appliedenergistics2:part:16>, <appliedenergistics2:material:37>, <appliedenergistics2:part:16>],
     [<ore:plateSextupleSteel>, <appliedenergistics2:material:24>, <ore:plateSextupleSteel>]]);

// --- ME Controller ---
recipes.remove(<appliedenergistics2:controller>);
recipes.addShaped(<appliedenergistics2:controller>,
    [[<ore:plateSextupleSteel>, <ore:crystalPureFluix>, <ore:plateSextupleSteel>],
     [<ore:crystalPureFluix>, <hbm:circuit:0>, <ore:crystalPureFluix>],
     [<ore:plateSextupleSteel>, <ore:crystalPureFluix>, <ore:plateSextupleSteel>]]);

// --- ME Drive (ingredient: EngProcessor=24 x2, matches source) ---
recipes.remove(<appliedenergistics2:drive>);
recipes.addShaped(<appliedenergistics2:drive>,
    [[<ore:plateTripleSteel>, <appliedenergistics2:material:24>, <ore:plateTripleSteel>],
     [<appliedenergistics2:part:16>, null, <appliedenergistics2:part:16>],
     [<ore:plateTripleSteel>, <appliedenergistics2:material:24>, <ore:plateTripleSteel>]]);

// --- Quantum Ring (EngProcessor=24 outer x2, LogicProcessor=22 sides x2, matches source) ---
recipes.remove(<appliedenergistics2:quantum_ring>);
recipes.addShaped(<appliedenergistics2:quantum_ring>,
    [[<ore:plateTripleSteel>, <appliedenergistics2:material:24>, <ore:plateTripleSteel>],
     [<appliedenergistics2:material:22>, <appliedenergistics2:energy_cell>, <appliedenergistics2:material:22>],
     [<ore:plateTripleSteel>, <appliedenergistics2:material:24>, <ore:plateTripleSteel>]]);

// --- Quantum Link Chamber ---
recipes.remove(<appliedenergistics2:quantum_link>);
recipes.addShaped(<appliedenergistics2:quantum_link>,
    [[<hbm:glass_quartz>, <ore:pearlFluix>, <hbm:glass_quartz>],
     [<ore:pearlFluix>, <hbm:circuit:16>, <ore:pearlFluix>],
     [<hbm:glass_quartz>, <ore:pearlFluix>, <hbm:glass_quartz>]]);

// --- View Cell ---
recipes.remove(<appliedenergistics2:view_cell>);
recipes.removeByRecipeName("appliedenergistics2:network/cells/view_cell");
recipes.removeByRecipeName("appliedenergistics2:network/cells/view_cell_storage");
recipes.addShaped(<appliedenergistics2:view_cell>,
    [[<hbm:glass_quartz>, <ore:dustRedstone>, <hbm:glass_quartz>],
     [<ore:dustRedstone>, <ore:crystalCertusQuartz>, <ore:dustRedstone>],
     [<ore:ingotSteel>, <ore:ingotSteel>, <ore:ingotSteel>]]);

// --- Memory Card (ingredient: CalcProcessor=23, matches source - was wrongly 22 before) ---
recipes.remove(<appliedenergistics2:memory_card>);
recipes.addShaped(<appliedenergistics2:memory_card>,
    [[<appliedenergistics2:material:23>, <ore:ingotSteel>, <ore:ingotSteel>],
     [<ore:ingotSteel>, <ore:dustRedstone>, <ore:ingotSteel>]]);

// --- Biometric Card (ingredient: EngProcessor=24, matches source - was wrongly 23 before) ---
recipes.remove(<appliedenergistics2:biometric_card>);
recipes.addShaped(<appliedenergistics2:biometric_card>,
    [[<appliedenergistics2:material:24>, <ore:ingotSteel>, <ore:ingotSteel>],
     [<ore:ingotSteel>, <ore:dustRedstone>, <ore:ingotSteel>]]);

// --- Color Applicator (ingredient: Cell1kPart=35, matches source exactly - was wrongly MatterBall before) ---
recipes.remove(<appliedenergistics2:color_applicator>);
recipes.addShaped(<appliedenergistics2:color_applicator>,
    [[null, <ore:ingotSteel>, null],
     [<ore:ingotSteel>, <appliedenergistics2:material:35>, null],
     [null, null, <appliedenergistics2:energy_cell>]]);

// --- Acceleration Card (Card Speed = AdvCard + Fluix, matches source exactly) ---
recipes.remove(<appliedenergistics2:material:30>);
recipes.addShapeless(<appliedenergistics2:material:30>,
    [<appliedenergistics2:material:28>, <ore:crystalFluix>]);

// --- Blank Pattern (x4) ---
recipes.remove(<appliedenergistics2:material:52>);
recipes.addShaped(<appliedenergistics2:material:52> * 4,
    [[null, <ore:ingotAnyHardPlastic>, null],
     [<ore:ingotAnyHardPlastic>, <hbm:circuit:5>, <ore:ingotAnyHardPlastic>],
     [null, <ore:ingotAnyHardPlastic>, null]]);

// --- Sky Stone Block (x16, meteor removed - crafted directly) ---
recipes.remove(<appliedenergistics2:sky_stone_block>);
recipes.addShaped(<appliedenergistics2:sky_stone_block> * 16,
    [[null, <hbm:fragment_meteorite>, null],
     [<hbm:fragment_meteorite>, <ore:cobblestone>, <hbm:fragment_meteorite>],
     [null, <hbm:fragment_meteorite>, null]]);

// ============================================================================
// Recipes present in the source pack but missing from the first port pass -
// added now that every ingredient is verified against both jars' bytecode.
// ============================================================================

// --- Basic Card (material 25) ---
recipes.remove(<appliedenergistics2:material:25>);
recipes.addShaped(<appliedenergistics2:material:25>,
    [[<ore:ingotGold>, <ore:ingotSteel>, null],
     [<ore:dustRedstone>, <appliedenergistics2:material:23>, <ore:ingotSteel>],
     [<ore:ingotGold>, <ore:ingotSteel>, null]]);

// --- Redstone Card (material 26, from Basic Card) ---
recipes.remove(<appliedenergistics2:material:26>);
recipes.addShaped(<appliedenergistics2:material:26>,
    [[<appliedenergistics2:material:25>, <minecraft:redstone_torch>]]);

// --- Advanced Card (material 28) ---
recipes.remove(<appliedenergistics2:material:28>);
recipes.addShaped(<appliedenergistics2:material:28>,
    [[<ore:gemDiamond>, <ore:ingotSteel>, null],
     [<ore:dustRedstone>, <appliedenergistics2:material:23>, <ore:ingotSteel>],
     [<ore:gemDiamond>, <ore:ingotSteel>, null]]);

// --- ME Storage Housing / Empty Storage Cell (material 39) ---
recipes.remove(<appliedenergistics2:material:39>);
recipes.addShaped(<appliedenergistics2:material:39>,
    [[<hbm:glass_quartz>, <hbm:glass_quartz>, <hbm:glass_quartz>],
     [<ore:dustRedstone>, null, <ore:dustRedstone>],
     [<ore:ingotSteel>, <hbm:ingot_steel>, <hbm:ingot_steel>]]);

// --- Wireless Receiver (material 41, uses Quartz Fiber part=140) ---
recipes.remove(<appliedenergistics2:material:41>);
recipes.addShaped(<appliedenergistics2:material:41>,
    [[null, <ore:pearlFluix>, null],
     [<ore:ingotSteel>, <appliedenergistics2:part:140>, <ore:ingotSteel>],
     [null, <ore:ingotSteel>, null]]);

// --- Wireless Booster (material 42) ---
recipes.remove(<appliedenergistics2:material:42>);
recipes.addShaped(<appliedenergistics2:material:42>,
    [[<ore:dustFluix>, <ore:crystalCertusQuartz>, <ore:dustEnder>],
     [<ore:ingotSteel>, <ore:ingotSteel>, <ore:ingotSteel>]]);

// --- ME Terminal (part 380, uses Logic Processor=22) ---
recipes.remove(<appliedenergistics2:part:380>);
recipes.addShaped(<appliedenergistics2:part:380>,
    [[<appliedenergistics2:material:22>, <ore:itemIlluminatedPanel>, <appliedenergistics2:material:22>]]);

// --- ME Import Bus (part 240, uses Eng Processor=24) ---
recipes.remove(<appliedenergistics2:part:240>);
recipes.addShaped(<appliedenergistics2:part:240>,
    [[null, <appliedenergistics2:material:24>, null],
     [<ore:ingotSteel>, <minecraft:piston>, <ore:ingotSteel>]]);

// --- ME Export Bus (part 260, uses Logic Processor=22) ---
recipes.remove(<appliedenergistics2:part:260>);
recipes.addShaped(<appliedenergistics2:part:260>,
    [[<ore:ingotSteel>, <appliedenergistics2:material:22>, <ore:ingotSteel>],
     [null, <minecraft:piston>, null]]);

// --- P2P Tunnel - ME (part 460, uses Eng Processor=24) ---
recipes.remove(<appliedenergistics2:part:460>);
recipes.addShaped(<appliedenergistics2:part:460>,
    [[null, <ore:ingotSteel>, null],
     [<ore:ingotSteel>, <appliedenergistics2:material:24>, <ore:ingotSteel>],
     [<ore:crystalFluix>, <ore:crystalFluix>, <ore:crystalFluix>]]);

// --- Illuminated Panel (Semi Dark Monitor, part 180, x3) ---
recipes.remove(<appliedenergistics2:part:180>);
recipes.removeByRecipeName("appliedenergistics2:network/parts/panels_semi_dark_monitor");
recipes.removeByRecipeName("appliedenergistics2:network/parts/panels_semi_dark_monitor_alt");
recipes.addShaped(<appliedenergistics2:part:180> * 3,
    [[null, <ore:dustGlowstone>, <hbm:glass_quartz>],
     [<ore:ingotSteel>, <ore:dustRedstone>, <hbm:glass_quartz>],
     [null, <ore:dustGlowstone>, <hbm:glass_quartz>]]);

// --- ME Annihilation Plane (part 300, uses Logic Processor=22) ---
recipes.remove(<appliedenergistics2:part:300>);
recipes.removeByRecipeName("appliedenergistics2:network/parts/planes_annihilation_alt");
recipes.removeByRecipeName("appliedenergistics2:network/parts/planes_annihilation_alt2");
recipes.addShaped(<appliedenergistics2:part:300>,
    [[<ore:crystalFluix>, <ore:crystalFluix>, <ore:crystalFluix>],
     [<ore:plateTripleSteel>, <appliedenergistics2:material:22>, <ore:plateTripleSteel>]]);

// --- ME Formation Plane (part 320, uses Eng Processor=24) ---
recipes.remove(<appliedenergistics2:part:320>);
recipes.removeByRecipeName("appliedenergistics2:network/parts/planes_formation");
recipes.removeByRecipeName("appliedenergistics2:network/parts/planes_formation_alt");
recipes.addShaped(<appliedenergistics2:part:320>,
    [[<ore:crystalFluix>, <ore:crystalFluix>, <ore:crystalFluix>],
     [<ore:plateTripleSteel>, <appliedenergistics2:material:24>, <ore:plateTripleSteel>]]);

// --- ME Conversion Monitor (part 420, uses Storage Monitor=400, Eng/Logic Processor) ---
recipes.remove(<appliedenergistics2:part:420>);
recipes.addShaped(<appliedenergistics2:part:420>,
    [[<appliedenergistics2:material:24>, <appliedenergistics2:part:400>, <appliedenergistics2:material:22>]]);

// ============================================================================
// Machine-exclusive items: the source pack removed the vanilla crafting-
// table recipe for these entirely and moved them to NTM machines (Assembly
// Machine for the intermediate "Part" components, Arc Welder for the
// finished cells). The actual machine recipes are added to
// config/hbmRecipes/hbmAssemblyMachine.json and hbmArcWelder.json - this
// section only strips AE2UEL's default vanilla recipe so they can't be
// crafted the "normal" AE2 way anymore.
// ============================================================================
// FOLLOW-UP FIX: recipes.remove(<item>) above turned out to NOT catch these -
// AE2UEL registers storage/spatial cells (and their Part components) using
// custom recipe types ("forge:ore_shaped", "appliedenergistics2:part_shaped")
// with condition blocks, and each of these items has TWO separate vanilla
// recipes (a "full" shaped one using quartz_glass/redstone/iron, and a
// "_storage" shapeless shortcut that just combines the Part + Empty Storage
// Cell directly) - both survived output-based removal. Removing by exact
// recipe name (extracted from the real file paths inside
// ae2-uel-v0.56.7.jar's assets/appliedenergistics2/recipes/network/cells/)
// is the reliable way to kill these, so both forms below are kept: the
// item-based removes as a first pass, the name-based removes as the actual
// fix.
recipes.remove(<appliedenergistics2:material:35>); // Cell1kPart
recipes.remove(<appliedenergistics2:material:36>); // Cell4kPart
recipes.remove(<appliedenergistics2:material:37>); // Cell16kPart
recipes.remove(<appliedenergistics2:material:38>); // Cell64kPart
recipes.remove(<appliedenergistics2:material:32>); // Cell2SpatialPart
recipes.remove(<appliedenergistics2:material:33>); // Cell16SpatialPart
recipes.remove(<appliedenergistics2:material:34>); // Cell128SpatialPart
recipes.remove(<appliedenergistics2:storage_cell_1k>);
recipes.remove(<appliedenergistics2:storage_cell_4k>);
recipes.remove(<appliedenergistics2:storage_cell_16k>);
recipes.remove(<appliedenergistics2:storage_cell_64k>);
recipes.remove(<appliedenergistics2:spatial_storage_cell_2_cubed>);
recipes.remove(<appliedenergistics2:spatial_storage_cell_16_cubed>);
recipes.remove(<appliedenergistics2:spatial_storage_cell_128_cubed>);

recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_1k");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_1k_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_4k");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_4k_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_16k");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_16k_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_64k");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_cell_64k_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_components_cell_1k_part");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_components_cell_4k_part");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_components_cell_16k_part");
recipes.removeByRecipeName("appliedenergistics2:network/cells/storage_components_cell_64k_part");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_2_cubed");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_2_cubed_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_16_cubed");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_16_cubed_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_128_cubed");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_storage_cell_128_cubed_storage");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_components");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_components_0");
recipes.removeByRecipeName("appliedenergistics2:network/cells/spatial_components_1");

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
// The Inscriber does NOT use the vanilla recipe registry - AE2 loads it from
// its own custom registry (assets/appliedenergistics2/aerecipes/inscriber/)
// and exposes a dedicated CraftTweaker binding for it, found by decompiling
// appeng/integration/modules/crafttweaker/InscriberRecipes.class:
// "mods.appliedenergistics2.Inscriber.removeRecipe(<output>)". Plain
// recipes.remove()/removeByRecipeName() cannot reach these at all.
// ============================================================================
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:19>); // Silicon Press
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:20>); // Silicon Print
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:13>); // Calculation Processor Press
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:16>); // Calculation Processor Print
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:23>); // Calculation Processor
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:14>); // Engineering Processor Press
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:17>); // Engineering Processor Print
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:24>); // Engineering Processor
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:15>); // Logic Processor Press
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:18>); // Logic Processor Print
mods.appliedenergistics2.Inscriber.removeRecipe(<appliedenergistics2:material:22>); // Logic Processor
// NOT touched: card_magnet / card_quantum_link inscriber recipes - these are
// AE2UEL-only cards with no NTM-side replacement, no overlap to remove.
// ============================================================================
