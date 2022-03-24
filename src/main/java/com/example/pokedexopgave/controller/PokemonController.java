package com.example.pokedexopgave.controller;

import com.example.pokedexopgave.repository.PokemonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonController {

  @GetMapping("/index")
  public String index(){
    PokemonRepository pokemonRepository = new PokemonRepository();
    return "index";
  }
}
