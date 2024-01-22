// SPDX-License-Identifier: Apache-2.0
// Copyright © 2023-2024 Caleb Cushing.
package com.xenoterracide.ai.wh40k.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class ApplicationTest {

  @Test
  void test(@Autowired WebTestClient client) {
    client.get().uri("/actuator/health").exchange().expectStatus().isOk();
  }
}
