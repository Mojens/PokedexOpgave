package com.example.pokedexopgave.model;

public class Pokemon {

  private int pokedex_number;
  private String name;
  private int speed;
  private int special_defence;
  private int special_attack;
  private int defence;
  private int attack;
  private int hp;
  private String primary_type;
  private String secondary_type;

  public Pokemon(int pokedex_number, String name, int speed, int special_defence, int special_attack, int defence, int attack, int hp, String primary_type, String secondary_type) {
    this.pokedex_number = pokedex_number;
    this.name = name;
    this.speed = speed;
    this.special_defence = special_defence;
    this.special_attack = special_attack;
    this.defence = defence;
    this.attack = attack;
    this.hp = hp;
    this.primary_type = primary_type;
    this.secondary_type = secondary_type;
  }

  @Override
  public String toString() {
    return "Pokemon{" +
        "pokedex_number=" + pokedex_number +
        ", name='" + name + '\'' +
        ", speed=" + speed +
        ", special_defence=" + special_defence +
        ", special_attack=" + special_attack +
        ", defence=" + defence +
        ", attack=" + attack +
        ", hp=" + hp +
        ", primary_type='" + primary_type + '\'' +
        ", secondary_type='" + secondary_type + '\'' +
        '}';
  }
}
