/*
Copyright © 2023 Caleb Cushing.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OFS ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
buildscript.dependencyLocking.lockAllConfigurations()
plugins {
  id("our.java-library")
}

dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.spring.boot.autoconfigure)
  testImplementation(libs.bundles.spring.test)
  runtimeOnly(libs.spring.boot.starter.core)
  runtimeOnly(libs.spring.boot.starter.log4j2)
  runtimeOnly(libs.spring.boot.starter.webflux)
  runtimeOnly(libs.spring.boot.starter.actuator)
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy(
        "org.springframework.boot:spring-boot-starter-log4j2",
        "Use Log4j2 instead of Logback"
      )
    }
  }
}


tasks.withType<JacocoCoverageVerification>().configureEach {
  dependsOn(project.tasks.withType<JacocoReport>())
  violationRules {
    rule {
      limit {
        minimum = 0.3.toBigDecimal()
      }
    }
  }
}
