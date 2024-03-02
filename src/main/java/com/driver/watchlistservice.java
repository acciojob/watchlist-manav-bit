package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class watchlistservice {
   @Autowired
   private watchlistrepository repository;

public void addMovie(Movie m){
   repository.addMovie(m);

}
   public void addDirector(Director d){
   repository.addDirector(d);
   }
   public void addMovieDirectorPair(){
   repository.addMovieDirectorPair();
   }
public Movie getMovieByName(String name){
   return repository.getMovieByName(name);
}
  public Director getDirectorByName(String name) {
   return repository.getDirectorByName(name);
 }

 public List<Movie> getMoviesByDirectorName(String name){
   return repository.getMoviesByDirectorName(name);
 }
 public List<Movie>findAllMovies(){
    return repository.findAllMovies();
 }
public void deleteDirectorByName(String name){
    repository.deleteDirectorByName(name);
}
public void deleteAllDirectors(){
    repository.deleteAllDirectors();
}

}
