plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.example.jetpackcomposecourse"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.jetpackcomposecourse"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    implementation("androidx.compose.material:material-icons-extended-android:1.7.8")

    //for navigation component
    //implementation("com.compose.compose-animated-navigationbar:bottombar:1.01") // Or the correct coordinates for your chosen library

// Check for the latest STABLE version of Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7") // Example: Replace with actual latest stable

// Serialization for navigation component (check for latest compatible version)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")


// Bottom Navigation Bar in Android (if using the third-party library and typo is fixed)
    //implementation("com.compose.compose-animated-navigationbar:bottombar:1.01")

    implementation("androidx.compose.material3:material3:1.2.0")
// or newer
    //implementation("com.compose.compose-animated-navigationbar:bottombar:1.01")
   //implementation("androidx.compose.material3:material3")
       // implementation("libs.androidx.compose.material3") // Or "androidx.compose.material3:material3:VERSION"
        // ... other dependencies
    //implementation("com.github.User:Repo:Tag")

    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.compose.material3:material3:1.2.0")
}