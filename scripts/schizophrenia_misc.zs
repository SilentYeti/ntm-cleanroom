// ============================================================================
// BetterQuesting / Storage Drawers / Gravity Gun recipe changes
// Ported from "Nuclear Tech- Integrated"'s recipe overhaul script.
// ============================================================================

// --- BetterQuesting reward items: disable crafting entirely (quest-reward only) ---
// The source pack removed these and never re-added a crafting recipe - they're
// meant to only be obtainable as quest rewards, not player-craftable.
recipes.remove(<betterquesting:extra_life>);
recipes.remove(<betterquesting:extra_life:1>);
recipes.remove(<betterquesting:extra_life:2>);
recipes.remove(<betterquesting:submit_station>);
// betterquesting:observation_station was removed in the source pack too, but
// that item id doesn't exist in BetterQuestingUnofficial 4.3.2 - skipped.

// --- Storage Drawers: gate behind NTM's wooden Mass Storage Unit ---
// CONFIDENCE NOTE: storagedrawers:basicdrawers is a single block with meta
// variants (0=fulldrawers1, 1=fulldrawers2, 2=fulldrawers4, 3=halfdrawers2,
// 4=halfdrawers4) reconstructed from declaration order in the mod's lang
// file - not verified in-game. Check with "/ct hand" if a recipe below
// doesn't look right.
recipes.remove(<storagedrawers:basicdrawers:0>); // Basic Drawer (1x1)
recipes.remove(<storagedrawers:basicdrawers:1>); // Basic Drawers 1x2
recipes.remove(<storagedrawers:basicdrawers:2>); // Basic Drawers 2x2
recipes.remove(<storagedrawers:basicdrawers:3>); // Half Drawers 1x2
recipes.remove(<storagedrawers:basicdrawers:4>); // Half Drawers 2x2
recipes.remove(<storagedrawers:compdrawers>);
recipes.remove(<storagedrawers:controller>);
recipes.remove(<storagedrawers:controllerslave>);

recipes.addShaped(<storagedrawers:basicdrawers:0>,
    [[<ore:plankWood>, <ore:plankWood>, <ore:plankWood>],
     [null, <hbm:mass_storage_wood>, null],
     [<ore:plankWood>, <ore:plankWood>, <ore:plankWood>]]);
recipes.addShaped(<storagedrawers:basicdrawers:1>,
    [[<ore:plankWood>, <hbm:mass_storage_wood>, <ore:plankWood>],
     [<ore:plankWood>, <ore:plankWood>, <ore:plankWood>],
     [<ore:plankWood>, <hbm:mass_storage_wood>, <ore:plankWood>]]);
recipes.addShaped(<storagedrawers:basicdrawers:2>,
    [[<hbm:mass_storage_wood>, <ore:plankWood>, <hbm:mass_storage_wood>],
     [<ore:plankWood>, <ore:plankWood>, <ore:plankWood>],
     [<hbm:mass_storage_wood>, <ore:plankWood>, <hbm:mass_storage_wood>]]);
recipes.addShaped(<storagedrawers:basicdrawers:3>,
    [[<ore:slabWood>, <hbm:mass_storage_wood>, <ore:slabWood>],
     [<ore:slabWood>, <ore:slabWood>, <ore:slabWood>],
     [<ore:slabWood>, <hbm:mass_storage_wood>, <ore:slabWood>]]);
recipes.addShaped(<storagedrawers:basicdrawers:4>,
    [[<hbm:mass_storage_wood>, <ore:slabWood>, <hbm:mass_storage_wood>],
     [<ore:slabWood>, <ore:slabWood>, <ore:slabWood>],
     [<hbm:mass_storage_wood>, <ore:slabWood>, <hbm:mass_storage_wood>]]);
recipes.addShaped(<storagedrawers:compdrawers>,
    [[<ore:craftingPiston>, <ore:drawerBasic>, <ore:craftingPiston>]]);
recipes.addShaped(<storagedrawers:controller>,
    [[null, <ore:plateSteel>, null],
     [<ore:plateSteel>, <ore:drawerBasic>, <ore:plateSteel>],
     [null, <ore:plateSteel>, null]]);
recipes.addShaped(<storagedrawers:controllerslave>,
    [[null, <ore:plateSteel>, null],
     [<ore:plateSteel>, <storagedrawers:trim>, <ore:plateSteel>],
     [null, <ore:plateSteel>, null]]);

// --- Gravity Gun ---
// Source pack used a different mod also named "GraviGun"; Schizophrenia has
// iChun's GravityGun instead (modid "gravitygun") - same concept (gate the
// gun behind NTM weapon-tier materials) applied to the actual installed mod.
recipes.remove(<gravitygun:gravitygun:0>);
recipes.addShaped(<gravitygun:gravitygun:0>,
    [[null, <ore:tinySchrabidium>, <hbm:circuit:8>],
     [<ore:barrelHeavyWeaponSteel>, <ore:receiverHeavyWeaponSteel>, <ore:stockAnyPlastic>],
     [null, <ore:gripAnyPlastic>, null]]);
recipes.remove(<gravitygun:gravitygun:1>);
