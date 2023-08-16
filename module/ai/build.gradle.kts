group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

plugins {
  id("our.java-library")
}


dependencies {
  implementation(platform(libs.spring.platform))
  implementation(libs.spring.boot.autoconfigure)
  implementation(libs.deeplearning4j.core)
  runtimeOnly(libs.nd4j.native)
  runtimeOnly(libs.spring.boot.starter.core)
  runtimeOnly(libs.spring.boot.starter.log4j2)
  testImplementation(libs.compile.testing)
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
    }
  }
}
