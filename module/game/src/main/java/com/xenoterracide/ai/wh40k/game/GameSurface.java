// SPDX-License-Identifier: Apache-2.0
// Copyright © 2023-2024 Caleb Cushing.
package com.xenoterracide.ai.wh40k.game;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

public interface GameSurface {
  Quantity<Length> length();

  Quantity<Length> width();
}
