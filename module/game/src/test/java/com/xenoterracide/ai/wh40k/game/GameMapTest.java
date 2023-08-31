package com.xenoterracide.ai.wh40k.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import org.junit.jupiter.api.Test;
import systems.uom.common.Imperial;
import tech.units.indriya.quantity.Quantities;

class GameMapTest {

  @Test
  void gridSize() {
    var map = new GameMap(
      new Table(Quantities.getQuantity(6 * 12, Imperial.INCH), Quantities.getQuantity(6 * 12, Imperial.INCH)),
      Quantities.getQuantity(44, Imperial.INCH),
      Quantities.getQuantity(30, Imperial.INCH)
    );

    assertThat(map.grid()).hasSize(1117);
    assertThat(map.grid()).map(Collection::size).containsOnly(762);
  }
}
