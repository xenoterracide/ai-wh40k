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
