# Mon Puy du Fou

Petite appli Android : liste des spectacles et programme du séjour (3-4 octobre 2026).
Un appui sur 🧭 ouvre l'itinéraire à pied dans Google Maps. ✓ marque un spectacle comme fait,
🗑 le retire du programme.

## Obtenir l'APK
1. Créer un dépôt GitHub nommé **mon-puy-du-fou** et y déposer **tout le contenu** de ce dossier
   (le dossier `.github` et le fichier `app/debug.keystore` compris).
2. Onglet **Actions** : le workflow « Build APK » se lance tout seul à chaque dépôt (ou bouton « Run workflow »).
3. Une fois terminé (environ 3-5 minutes), l'APK **Mon-Puy-du-Fou.apk** est dans l'onglet **Releases** du dépôt.
4. Sur le téléphone, ouvrir la page Releases dans Chrome, télécharger l'APK, l'ouvrir et autoriser
   l'installation depuis cette source si Android le demande.

## Mises à jour
Toutes les versions sont signées avec la même clé (`app/debug.keystore`) et leur numéro augmente à chaque build :
une nouvelle version s'installe par-dessus l'ancienne et garde les « fait » / « supprimé ».
(Si une version plus ancienne, compilée avant l'ajout de cette clé, est déjà installée, la désinstaller une fois.)

## Modifier le contenu
La page (spectacles, coordonnées, planning) est dans `app/src/main/assets/index.html` :
tableau `SH` (spectacles et coordonnées GPS `c:[lat,lon]`) et tableau `PLAN` (programme).
L'image de fond est `app/src/main/assets/fond.jpg`, l'icône est dans `app/src/main/res/drawable-nodpi/`.
Chaque modification déposée sur GitHub recompile l'APK.

## Notes
- Pas de Gradle wrapper : le workflow installe Gradle 8.9 lui-même. Pour compiler en local avec
  Android Studio, ouvrir le dossier, il proposera de configurer Gradle.
