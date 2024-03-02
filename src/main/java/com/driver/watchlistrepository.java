package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class watchlistrepository {

private final HashMap<String,Movie>movies=new HashMap<>();
  private final HashMap<String,Director>directors=new HashMap<>();
   private final HashMap<String,String>moviesdirectorpair=new HashMap<>();

   public void addMovie(Movie m){
       movies.put(m.getName(),m);
   }
   public void addDirector(Director d){
       directors.put(d.getName(),d);
   }
   public void addMovieDirectorPair(){
       for(Movie val:movies.values()){
           String d=val.getDirector();
           if(!directors.isEmpty() && directors.containsKey(d)){
               moviesdirectorpair.put(val.getName(), d);
           }
       }
   }
   public Movie getMovieByName(String name){
      for(Movie m:movies.values()){
          if(m.getName().equals(name)){
              return m;
          }
      }
return null;
   }
   public Director getDirectorByName(String name){
       for(Director d:directors.values()){
//           System.out.println(d.getName()+ " "+ name);
           if(d.getName().equals(name)){
               return d;
           }

       }

       return null;
   }

   public List<Movie> getMoviesByDirectorName(String name){
       List<Movie>ans=new ArrayList<>();
       for(Movie m:movies.values()){
           if(m.getDirector().equals(name)){
               ans.add(m);
           }
       }
       return ans;
   }
   public List<Movie>findAllMovies(){
       List<Movie>ans=new ArrayList<>();
       for(Movie m: movies.values()){
           ans.add(m);
       }
       return ans;
   }
    public void deleteDirectorByName(String name) {
        Set<Movie> moviesToRemove = new HashSet<>();
        for (Movie m : movies.values()) {
            if (m.getDirector().equals(name)) {
                moviesToRemove.add(m);
            }
        }

        for (Movie m : moviesToRemove) {
            movies.remove(m.getName());
        }

        directors.remove(name);
    }

public void deleteAllDirectors(){
       directors.clear();
       movies.clear();
}
}
