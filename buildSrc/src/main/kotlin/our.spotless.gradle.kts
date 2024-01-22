// SPDX-License-Identifier: MIT
// Copyright © 2023-2024 Caleb Cushing.
plugins {
  `java-base`
  id("com.diffplug.spotless")
}

val copyright = "// Copyright © \$YEAR Caleb Cushing.${System.lineSeparator()}"
val javaLicense = "// SPDX-License-Identifier: Apache-2.0${System.lineSeparator()}"
val gradleLicense = "// SPDX-License-Identifier: MIT${System.lineSeparator()}"

repositories {
  mavenCentral()
}

spotless {
  if (!providers.environmentVariable("CI").isPresent) {
    ratchetFrom("origin/main")
  }

  java {
    licenseHeader("$javaLicense$copyright")
    removeUnusedImports()
    formatAnnotations()
    cleanthat()
  }

  kotlinGradle {
    target("**/*.gradle.kts")
    targetExclude("**/build/**")
    ktlint()
    licenseHeader(gradleLicense + copyright, "(import|buildscript|plugins|root)")
  }
}
