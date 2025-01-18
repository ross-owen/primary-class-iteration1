plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.myowencode.primaryclass"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.myowencode.primaryclass"
        minSdk = 25
        targetSdk = 35
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

    buildFeatures {
        viewBinding = true
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Navigation Component
//    implementation(libs.androidx.navigation.fragment.ktx)
//    implementation(libs.androidx.navigation.ui.ktx)

    // Room components
    implementation(libs.androidx.room.runtime)
//    kapt("androidx.room:room-compiler:2.2.5")
//    implementation(libs.androidx.room.ktx)
//    androidTestImplementation(libs.androidx.room.testing)

    // Lifecycle components
//    implementation(libs.lifecycle.extensions)
//    implementation(libs.androidx.lifecycle.common.java8)
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Kotlin components
//    implementation(libs.kotlin.stdlib.jdk7)
//    api(libs.kotlinx.coroutines.core)
//    api(libs.kotlinx.coroutines.android)

//    annotationProcessor(libs.androidx.room.room.compiler)
//
//    implementation(libs.androidx.runtime.livedata)

}