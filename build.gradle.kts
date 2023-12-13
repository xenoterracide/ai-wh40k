tasks.dependencies {
  dependsOn(subprojects.map { "${it.path}:dependencies" })
}
