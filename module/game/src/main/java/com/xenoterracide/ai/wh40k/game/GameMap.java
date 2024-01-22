// SPDX-License-Identifier: Apache-2.0
// Copyright © 2023-2024 Caleb Cushing.
package com.xenoterracide.ai.wh40k.game;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import tech.units.indriya.unit.Units;

public class GameMap implements GameSurface {

  private static final Unit<Length> MM = MetricPrefix.MILLI(Units.METRE);
  private final GameSurface table;
  private final Quantity<Length> length; // usually 30" / 60" / 90"
  private final Quantity<Length> width; // usually 44"

  private final List<List<?>> grid;

  public GameMap(GameSurface table, Quantity<Length> length, Quantity<Length> width) {
    this.length = Objects.requireNonNull(length.to(MM));
    this.width = Objects.requireNonNull(width.to(MM));
    this.table = Objects.requireNonNull(table);

    if (!(table.length().getValue().intValue() >= length.getValue().intValue())) {
      throw new IllegalArgumentException("table length must be less or equal to table width");
    }

    if (!(table.width().getValue().intValue() >= width.getValue().intValue())) {
      throw new IllegalArgumentException("table width must be less or equal to table width");
    }

    this.grid =
      Stream
        .generate(() -> Stream.generate(() -> null).limit(this.width.getValue().intValue()).collect(Collectors.toList())
        )
        .limit(this.length.getValue().intValue())
        .collect(Collectors.toList());
  }

  List<? extends List<?>> grid() {
    return grid.stream().map(Collections::unmodifiableList).toList();
  }

  public GameSurface table() {
    return table;
  }

  @Override
  public Quantity<Length> length() {
    return this.length;
  }

  @Override
  public Quantity<Length> width() {
    return this.width;
  }

  // CHECKSTYLE:OFF
  // mitigate finalizer attack
  @Override
  @SuppressWarnings({ "deprecation", "Finalize" })
  protected final void finalize() {}
  // CHECKSTYLE:ON
}
