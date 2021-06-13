object Dependencies {
    const val agp_version = "4.1.2"//7.1.0-alpha02
    const val android_tools_build_version = agp_version
    const val kotlin_version = "1.5.10"
    const val kotlinx_serialization_version = "1.2.0"//1.2.0
    const val kotlinx_serialization_runtime_version = "1.0-M1-1.4.0-rc"
    const val coroutines_common_version = "1.4.3"
    const val coroutines_version = "1.4.3-native-mt"
    const val ktor_version = "1.5.3"

    const val compose_version = "1.0.0-beta08"
    const val compose_activity_version = "1.3.0-beta01"
    const val compose_appcompat_version = "1.3.0"
    const val compose_constraintlayout_version = "1.0.0-alpha07"
    const val compose_navigation_version = "2.4.0-alpha02"
    const val compose_lifecycle_version = "1.0.0-alpha06"
    const val compose_accompanist_version = "0.11.1"

    const val compose_utils_chrisbanes_coil_version = "0.6.2"
    const val compose_utils_io_coil_version = "1.2.2"

    const val paging_compose_version = "1.0.0-alpha10"

    const val retrofit_version = "2.9.0"
    const val okhttp_version = "5.0.0-alpha.2"
    const val retrofit_kotlinx_serialization_converter_version = "0.8.0"

    const val okHttp = "com.squareup.okhttp3:okhttp:$okhttp_version"
    const val ktlint = "com.pinterest:ktlint:0.41.0"
    const val daggerHilt_version = "2.36"
    const val daggerHiltVersion = daggerHilt_version

    object Kotlin {
        const val version = kotlin_version
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${version}"
        const val jsonSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_serialization_version"
    }

    object Gradle {
        const val androidBuildPlugin = "com.android.tools.build:gradle:$android_tools_build_version"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$daggerHiltVersion"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
        const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Kotlin.version}"

        object VersionsPlugin {
            const val id = "com.github.ben-manes.versions"
            const val version = "0.39.0"
        }
    }

    object AndroidX {
        const val palette = "androidx.palette:palette:1.0.0"
        const val browser = "androidx.browser:browser:1.3.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-beta01"

        object Ktx {
            const val core = "androidx.core:core-ktx:1.6.0-beta02"
        }
    }

    object Compose {
        // Compose is combination of 7 Maven Group Ids within androidx.
        // Each Group contains a targeted subset of functionality, each with it's own set of release notes.
        const val version = compose_version
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val layout = "androidx.compose.foundation:foundation-layout:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiUtil = "androidx.compose.ui:ui-util:$version"
        const val material = "androidx.compose.material:material:$version"
        const val icons = "androidx.compose.material:material-icons-extended:$version"
        const val animation = "androidx.compose.animation:animation:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test:$version"
        const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:$version"
        const val paging = "androidx.paging:paging-compose:$paging_compose_version"
        const val activity = "androidx.activity:activity-compose:$compose_activity_version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$compose_lifecycle_version"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:$compose_constraintlayout_version"

        object Accompanist {
            private const val libraryName = "com.google.accompanist:accompanist"
            private const val version = compose_accompanist_version

            const val coil = "$libraryName-coil:$version"
            const val insets = "$libraryName-insets:$version"
            const val insetsUi = "$libraryName-insets-ui:$version"
            const val pager = "$libraryName-pager:$version"
        }
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:$daggerHiltVersion"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"
        const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val viewmodelCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }

    object Retrofit {
        private const val retrofitVersion = retrofit_version
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofit_kotlinx_serialization_converter_version"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val mockk = "io.mockk:mockk:1.11.0"
        const val striktAssertion = "io.strikt:strikt-core:0.30.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.2"
    }
}
