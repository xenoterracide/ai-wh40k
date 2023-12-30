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
  our.javalibrary
}


dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.bundles.measure)
  runtimeOnly(libs.starter.core)
  runtimeOnly(libs.starter.log4j2)
  constraints {
    implementation(libs.javax.annotation) {
      version {
        strictly("1.3.4")
      }
      because("need the 1.0 api")
    }
  }
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy(
        "org.springframework.boot:spring-boot-starter-log4j2",
        "Use Log4j2 instead of Logback"
      )
    }
  }
}
