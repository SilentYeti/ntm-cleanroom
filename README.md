# NTM: Cleanroom

A curated Minecraft 1.12.2 (Forge 14.23.5.2860) modpack, managed with
[pakku](https://github.com/juraj-hrivnak/Pakku) and built/released via GitHub Actions.

## Repo layout

- `pakku.json` / `pakku-lock.json` — the pack definition (source of truth for
  every mod, version pin, and side/update rule). `mods/` itself is **not**
  committed; it's regenerated locally or in CI with `pakku fetch`.
- `config/`, `scripts/` — hand-authored overrides shipped as-is (declared in
  `pakku.json`'s `overrides` list).
- `.github/workflows/rebuild.yml` — builds the pack and publishes releases.

## Building a release

Push to `main` (e.g. after editing `pakku.json`/`pakku-lock.json` or the
`config`/`scripts` overrides) or trigger the **Rebuild modpack** workflow
manually from the Actions tab. Each run:

1. Installs [pakku](https://github.com/juraj-hrivnak/Pakku) and your
   CurseForge credentials.
2. Optionally runs `pakku update -a` first (manual dispatch only, via the
   `update_all` input) to bump every non-frozen project.
3. Runs `pakku fetch` + `pakku export` to build the CurseForge zip, the
   Modrinth `.mrpack`, and the serverpack zip.
4. Commits back any refreshed `pakku-lock.json`.
5. Publishes:
   - a rolling **`pack-latest`** prerelease (always overwritten — the
     "give me the newest build" link), and
   - a proper tagged release (`v<version from pakku.json>`), skipped if that
     tag already exists — bump the version in `pakku.json` to cut a new one.

## Building locally

```sh
pakku fetch    # download every project's jar into mods/
pakku export   # produce build/curseforge, build/modrinth, build/serverpack
```
