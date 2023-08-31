package com.xenoterracide.ai.wh40k.game;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

public interface Surface {
  Quantity<Length> length();
  Quantity<Length> width();
}
