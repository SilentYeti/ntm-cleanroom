// ============================================================================
// Irradiation Channel - the one genuinely custom recipe in
// config/hbmRecipes/hbmIrradiation.json (found by diffing it against the
// disabled/default _hbmIrradiation.json - identical except for this entry):
// irradiating a Gravity Gun (gravitygun:gravitygun, meta 0) upgrades it into
// the meta:1 variant. Matches groovy/postInit/schizophrenia_misc.groovy,
// which strips meta:1's own crafting-table recipe - this is how you're meant
// to get it instead.
//
// hbmIrradiation.json itself is untouched; this doesn't disable/remove it.
// If both the JSON entry and this script end up active at once you'll get
// the recipe registered twice - harmless (duplicate recipes just collapse
// to the same result) but worth checking crafting.streamRecipes() or the
// in-game recipe viewer for after testing, and removing the JSON entry once
// this is confirmed working.
//
// NOT VERIFIED IN-GAME: the binding name below (mods.hbm.irradiationchannel)
// is my best read of the decompiled field name
// (HbmGroovyPropertyContainer.IRRADIATIONCHANNEL), not confirmed against a
// live GroovyScript session - hbm ships its own GroovyScript compat bundled
// in its jar, so it isn't listed on GroovyScript's own docs site. Run
// `/gs reload` and check logs/groovy.log for "no such property" if this
// doesn't resolve.
// ============================================================================

mods.hbm.irradiationchannel.addRecipe(
    item('gravitygun:gravitygun'),
    item('gravitygun:gravitygun', 1)
)
