package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class watchlistservice {
   @Autowired
   private watchlistrepository repository;

public void addmovie(Movie m){
   repository.addmovie(m);

}
   public void adddirector(Director d){
   repository.adddirector(d);
   }
   public void updatemoviedirectorpair(){
   repository.updatemoviedirectorpair();
   }
public Movie getmoviebyname(String name){
   return repository.getmoviebyname(name);
}
  public Director getdirectorbyname(String name) {
   return repository.getdirectorbyname(name);
 }

 public List<Movie> getmoviebydirectorname(String name){
   return repository.getmoviebydirectorname(name);
 }
 public List<Movie>getallmovies(){
    return repository.getallmovies();
 }
public void deletedirectorbyname(String name){
    repository.deletedirectorbyname(name);
}
public void deletealldirectors(){
    repository.deletealldirectors();
}

}
