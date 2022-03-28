package com.example.pokedexopgave.repository;
import com.example.pokedexopgave.model.Pokemon;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class PokemonRepository {
  private static String DB_URL = "jdbc:mysql://localhost:3306/Pokedex"; //efter3306 skriver hvad det er for en tabel
  private static String UID = "root";
  private static String PWD = "";

  public static Connection getConnection(){
    Connection connection = null;
    try{
      connection = DriverManager.getConnection(DB_URL, UID, PWD);
      return connection;
    }catch (SQLException e){
      System.out.println("Virker ikke");
      e.printStackTrace();
    }
    return connection;
  }

  public static void getOffConnection(){
    try {
      getConnection().close();
    } catch (SQLException e) {
      System.out.println("Kunne ikke lukke for serveren");
      e.printStackTrace();
    }
  }

  public PokemonRepository(){
    getConnection();
  }

  public List<Pokemon> findAll(){
    //Laver tom arraylist
    ArrayList<Pokemon> pokedex = new ArrayList<>();

    try {
      //Forbinder
      getConnection();
      System.out.println("Forbundet til DB");
      Statement statement = getConnection().createStatement();
      final String SQL_QUERY = "SELECT * FROM pokemon";
      ResultSet resultSet = statement.executeQuery(SQL_QUERY);

      // Læser fra tabel
      while(resultSet.next()){
        //Giver informationerne fra tabel til attributer
        int pokedex_number = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int speed = resultSet.getInt(3);
        int special_defence = resultSet.getInt(4);
        int special_attack = resultSet.getInt(5);
        int defence = resultSet.getInt(6);
        int attack = resultSet.getInt(7);
        int hp = resultSet.getInt(8);
        String primary_type = resultSet.getString(9);
        String secondary_type = resultSet.getString(10);
        //Tilføjer dem til min constructor, for at lave pokemon objekter samt tilføjer dem til min arraylist
        pokedex.add(new Pokemon(pokedex_number, name,
            speed, special_defence, special_attack,
            defence, attack, hp, primary_type, secondary_type));

      }
      statement.close();
      getOffConnection();

    } catch (SQLException e) {
      System.out.println("Virker ikke");
      e.printStackTrace();
    }
    // Returner listen med alle pokemons
    return pokedex;
  }

  public void addPokemon(Pokemon pokemon){
  getConnection();
  try{
    //prep statement
    PreparedStatement preparedStatement = getConnection().prepareStatement(
        "INSERT INTO pokemon(name, speed, special_defence, special_attack, defence, attack, hp, primary_type, secondary_type) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    //set attributer
    preparedStatement.setString(1, pokemon.getName());
    preparedStatement.setInt(2,pokemon.getSpeed());
    preparedStatement.setInt(3,pokemon.getSpecial_defence());
    preparedStatement.setInt(4,pokemon.getSpecial_attack());
    preparedStatement.setInt(5,pokemon.getDefence());
    preparedStatement.setInt(6,pokemon.getAttack());
    preparedStatement.setInt(7,pokemon.getHp());
    preparedStatement.setString(8,pokemon.getPrimary_type());
    preparedStatement.setString(9,pokemon.getSecondary_type());
    //execute statement
    preparedStatement.executeUpdate();
  }
  catch(SQLException e){
    System.out.println("Could not create");
    e.printStackTrace();
  }
  }
}
