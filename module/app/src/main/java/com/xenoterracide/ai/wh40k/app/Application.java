// SPDX-License-Identifier: Apache-2.0
// Copyright © 2023-2024 Caleb Cushing.
package com.xenoterracide.ai.wh40k.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings({ "checkstyle:HideUtilityClassConstructor", "checkstyle:FinalClass" })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
