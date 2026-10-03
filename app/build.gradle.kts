plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sejour.puydufou"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sejour.puydufou"
        minSdk = 26
        targetSdk = 34
        // Le numéro de version augmente à chaque build GitHub : une nouvelle version s'installe par-dessus l'ancienne
        val run = (System.getenv("GITHUB_RUN_NUMBER") ?: "1").toInt()
        versionCode = run
        versionName = "1.$run"
    }

    // Clé de signature fixe (fichier debug.keystore du dépôt) : toutes les versions ont la même signature
    signingConfigs {
        getByName("debug") {
            storeFile = file("debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}
