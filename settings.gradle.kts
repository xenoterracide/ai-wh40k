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
rootProject.name = "ai-wh40k"

rootDir.resolve("module").listFiles()?.forEach { file ->
  if (file.isDirectory && file?.list { _, name -> name == "build.gradle.kts" }?.isNotEmpty() == true) {
    val name = file.name;
    include(":$name")
    project(":$name").projectDir = file("module/$name")
  } else {
    throw Exception("Invalid module directory: $file")
  }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
