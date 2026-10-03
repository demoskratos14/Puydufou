# Puy du Fou · Mon séjour

Petite appli Android : liste des spectacles et programme du séjour (3-4 octobre 2026).
Un appui sur 🧭 ouvre l'itinéraire à pied dans Google Maps. ✓ marque un spectacle comme fait,
🗑 le retire du programme.

## Obtenir l'APK
1. Créer un dépôt GitHub et y déposer **tout le contenu** de ce dossier (le dossier `.github` compris).
2. Onglet **Actions** : le workflow « Build APK » se lance tout seul à chaque dépôt (ou bouton « Run workflow »).
3. Une fois terminé (environ 3-5 minutes), l'APK est dans l'onglet **Releases** du dépôt (fichier `app-debug.apk`),
   et aussi dans les « Artifacts » de l'exécution.
4. Sur le téléphone, ouvrir la page Releases dans Chrome, télécharger l'APK, l'ouvrir et autoriser
   l'installation depuis cette source si Android le demande.

## Modifier le contenu
Toute la page (spectacles, coordonnées, planning) est dans `app/src/main/assets/index.html` :
tableau `SH` (spectacles et coordonnées GPS `c:[lat,lon]`) et tableau `PLAN` (programme).
Chaque modification déposée sur GitHub recompile l'APK.

## Notes
- APK signé en mode « debug » : suffisant pour un usage personnel.
- Pas de Gradle wrapper : le workflow installe Gradle 8.9 lui-même. Pour compiler en local avec
  Android Studio, ouvrir le dossier, il proposera de configurer Gradle.
