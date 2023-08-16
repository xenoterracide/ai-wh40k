group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

buildscript {
  dependencyLocking {
    lockAllConfigurations()
  }
}

plugins {
  id("our.java-library")
  id("org.bytedeco.gradle-javacpp-platform").version("1.+")
}

dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.spring.boot.autoconfigure)
  runtimeOnly(libs.spring.boot.starter.core)
  runtimeOnly(libs.spring.boot.starter.log4j2)
  testImplementation(libs.compile.testing)
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
    }
  }
}
