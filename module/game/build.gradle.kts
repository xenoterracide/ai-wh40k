group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

plugins {
    id("our.java-library")
}


dependencies {
    implementation(platform(libs.spring.platform))
    implementation(libs.bundles.measure)
    runtimeOnly(libs.spring.boot.starter.core)
    runtimeOnly(libs.spring.boot.starter.log4j2)
    constraints {
        compileOnly(libs.javax.annotation) {
            because("need the 1.0 api")
        }
    }
    modules {
        module("org.springframework.boot:spring-boot-starter-logging") {
            replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
        }
    }
}
