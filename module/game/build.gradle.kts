// SPDX-License-Identifier: MIT
// Copyright © 2023-2024 Caleb Cushing.
buildscript { dependencyLocking.lockAllConfigurations() }

plugins { our.javalibrary }

dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.bundles.measure)
  runtimeOnly(libs.starter.core)
  runtimeOnly(libs.starter.log4j2)
  constraints {
    implementation(libs.javax.annotation) {
      version { strictly("1.3.4") }
      because("need the 1.0 api")
    }
  }
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy(
        "org.springframework.boot:spring-boot-starter-log4j2",
        "Use Log4j2 instead of Logback",
      )
    }
  }
}
