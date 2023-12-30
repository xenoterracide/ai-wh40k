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
  runtimeOnly(platform(libs.spring.platform))
  runtimeOnly(libs.starter.core)
  runtimeOnly(libs.starter.log4j2)
  runtimeOnly(libs.starter.webflux)
  runtimeOnly(libs.starter.actuator)


  api(platform(libs.spring.platform))
  api(libs.spring.boot.autoconfigure)

  implementation(platform(libs.spring.platform))
  implementation(libs.spring.boot.autoconfigure)
  implementation(libs.spring.boot.core)
  implementation(libs.spring.context)

  testImplementation(platform(libs.spring.platform))
  testImplementation(libs.bundles.spring.test)
  testImplementation(libs.junit.api)
  testImplementation(libs.spring.beans)

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
