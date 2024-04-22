plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mobuloustask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mobuloustask"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")

    //sdp
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
    //circular image
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    //circleImage
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.6")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.6.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
}