// SPDX-License-Identifier: MIT
// Copyright © 2023-2024 Caleb Cushing.
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
  `java-test-fixtures`
  checkstyle
}

val libs = the<LibrariesForLibs>()

tasks.withType<Checkstyle>().configureEach {
  isShowViolations = true
  reports {
    html.required.set(false)
    xml.required.set(false)
  }
}

fun checkstyleConfig(filename: String): File {
  val path = ".config/checkstyle/$filename"
  val f = file(path)
  return if (f.exists()) f else rootProject.file(path)
}

tasks.named<Checkstyle>("checkstyleMain") {
  configFile = checkstyleConfig("main.xml")
}

tasks.named<Checkstyle>("checkstyleTestFixtures") {
  configFile = checkstyleConfig("main.xml")
}

tasks.named<Checkstyle>("checkstyleTest") {
  configFile = checkstyleConfig("test.xml")
}
