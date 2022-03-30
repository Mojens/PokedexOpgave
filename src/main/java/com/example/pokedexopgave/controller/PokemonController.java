package com.example.pokedexopgave.controller;

import com.example.pokedexopgave.model.Pokemon;
import com.example.pokedexopgave.repository.PokemonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PokemonController {

  @GetMapping("/findall")
  public String findall(Model model) {
    PokemonRepository pokemonRepository = new PokemonRepository();
    model.addAttribute("pokemons", pokemonRepository.findAll());
    return "allepokemons";
  }

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/addPokemon")
  public String showAddPokemon() {
    return "addPokemon";
  }

  @PostMapping("/addPokemon")
  public String addPokemon(@RequestParam("name") String name,
                           @RequestParam("speed") int speed,
                           @RequestParam("special_defence") int special_defence,
                           @RequestParam("special_attack") int special_attack,
                           @RequestParam("defence") int defence,
                           @RequestParam("attack") int attack,
                           @RequestParam("hp") int hp,
                           @RequestParam("primary_type") String primary_type,
                           @RequestParam("secondary_type") String secondary_type) {
    PokemonRepository pokemonRepository = new PokemonRepository();
    Pokemon newPokemon = new Pokemon();
    newPokemon.setName(name);
    newPokemon.setSpeed(speed);
    newPokemon.setSpecial_defence(special_defence);
    newPokemon.setSpecial_attack(special_attack);
    newPokemon.setDefence(defence);
    newPokemon.setAttack(attack);
    newPokemon.setHp(hp);
    newPokemon.setPrimary_type(primary_type);
    newPokemon.setSecondary_type(secondary_type);

    pokemonRepository.addPokemon(newPokemon);
    return "redirect:/findall";
  }

  @GetMapping("/deletePokemon")
  public String showDeletePokemon(){
    return "deletePokemon";
  }

  @PostMapping("/deletePokemon")
  public String deletePokemon(@RequestParam("pokedex_number") int pokedex_number){
    PokemonRepository pokemonRepository = new PokemonRepository();
    pokemonRepository.deletePokemon(pokedex_number);

    return "redirect:/findall";
  }

  @GetMapping("/updatePokemon")
  public String showUpdatePokemon() {
    return "updatePokemon";
  }

  @PostMapping("/updatePokemon")
  public String updatePokemon(@RequestParam("speed") int pokedex_number,
                              @RequestParam("name") String name,
                           @RequestParam("speed") int speed,
                           @RequestParam("special_defence") int special_defence,
                           @RequestParam("special_attack") int special_attack,
                           @RequestParam("defence") int defence,
                           @RequestParam("attack") int attack,
                           @RequestParam("hp") int hp,
                           @RequestParam("primary_type") String primary_type,
                           @RequestParam("secondary_type") String secondary_type) {
    PokemonRepository pokemonRepository = new PokemonRepository();
    Pokemon newPokemon = new Pokemon();
    newPokemon.setName(name);
    newPokemon.setSpeed(speed);
    newPokemon.setSpecial_defence(special_defence);
    newPokemon.setSpecial_attack(special_attack);
    newPokemon.setDefence(defence);
    newPokemon.setAttack(attack);
    newPokemon.setHp(hp);
    newPokemon.setPrimary_type(primary_type);
    newPokemon.setSecondary_type(secondary_type);
    newPokemon.setPokedex_number(pokedex_number);

    pokemonRepository.updatePokemon(newPokemon);
    return "redirect:/findall";
  }
}
