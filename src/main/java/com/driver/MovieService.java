package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
   @Autowired
   private MovieRepository repository;

public void addMovie(Movie m){
   repository.saveMovie(m);

}
   public void addDirector(Director d){
   repository.saveDirector(d);
   }
   public void addMovieDirectorPair(String movie, String director){
   repository.saveMovieDirectorPair(movie, director);
   }
public Movie findMovie(String name){
   return repository.findMovie(name);
}
  public Director findDirector(String name) {
   return repository.saveDirector(name);
 }

 public List<String> findMoviesFromDirector(String name){
   return repository.getMoviesByDirectorName(name);
 }
 public List<String>findAllMovies(){
    return repository.findAllMovies();
 }
public void deleteDirector(String name){
    repository.deleteDirector(name);
}
public void deleteAllDirectors(){
    repository.deleteAllDirectors();
}

}
