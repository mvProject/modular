object Dependencies {

    //android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    private const val material = "com.google.android.material:material:${Versions.material}"

    //test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    //network
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"

    //preference
    private const val preferenceKtx = "androidx.preference:preference-ktx:${Versions.preferenceKtx}"

    //navigation
    private const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //lifecycle
    private const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    private const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // DI
    const val hilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"

    val appLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(activityKtx)
        add(material)
    }

    val logging = arrayListOf<String>().apply {
        add(timber)
    }

    val preference = arrayListOf<String>().apply {
        add(preferenceKtx)
    }

    val navigationKtx = arrayListOf<String>().apply {
        add(navigationFragmentKtx)
        add(navigationUiKtx)
    }

    val lifecycleKtx = arrayListOf<String>().apply {
        add(lifecycleLiveDataKtx)
        add(lifecycleViewModelKtx)
    }

    val network = arrayListOf<String>().apply {
        add(retrofit)
        add(gsonConverter)
        add(loggingInterceptor)
        add(gson)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}


