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

public class Miniature {

  private final String name;
  private final int wounds;
  private final int toughness;
  private final int save;
  private final int invulnerableSave;
  private final int movement;

  public Miniature(String name, int wounds, int toughness, int save, int invulnerableSave, int movement) {
    this.name = name;
    this.wounds = wounds;
    this.toughness = toughness;
    this.save = save;
    this.invulnerableSave = invulnerableSave;
    this.movement = movement;
  }
}
