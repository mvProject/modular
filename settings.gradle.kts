// dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
// }
rootProject.name = "ModuleSkeleton"
include(
    ":app",
    ":base",
    ":loginmodule",
    ":firstappmodule",
    ":secondappmoodule",
    ":navigation"
)
