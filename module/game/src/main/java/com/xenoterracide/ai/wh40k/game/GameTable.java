// SPDX-License-Identifier: Apache-2.0
// Copyright © 2023-2024 Caleb Cushing.
package com.xenoterracide.ai.wh40k.game;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import tech.units.indriya.unit.Units;

public class GameTable implements GameSurface {

  private static final Unit<Length> MM = MetricPrefix.MILLI(Units.METRE);
  private final Quantity<Length> length; // usually 30" / 60" / 90"
  private final Quantity<Length> width; // usually 44"

  private final List<List<Object>> grid;

  protected GameTable(List<List<Object>> grid, Quantity<Length> length, Quantity<Length> width) {
    this.length = Objects.requireNonNull(length);
    this.width = Objects.requireNonNull(width);
    this.grid = Objects.requireNonNull(grid);
  }

  public static GameTable create(Quantity<Length> length, Quantity<Length> width) {
    var grid = Stream
      .generate(() -> Stream.generate(() -> null).limit(width.to(MM).getValue().intValue()).toList())
      .limit(length.to(MM).getValue().intValue())
      .toList();

    return new GameTable(grid, length, width);
  }

  public List<List<Object>> grid() {
    return this.grid;
  }

  @Override
  public Quantity<Length> length() {
    return this.length;
  }

  @Override
  public Quantity<Length> width() {
    return this.width;
  }
}
