// SPDX-License-Identifier: MIT
// Copyright © 2023-2024 Caleb Cushing.
rootProject.name = "buildSrc"

dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}
