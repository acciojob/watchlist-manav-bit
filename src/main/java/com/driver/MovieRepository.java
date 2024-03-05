package com.driver;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }


   public void saveMovie(Movie m){
       movieMap.put(m.getName(),m);
   }
   public void saveDirector(Director d){
       directorMap.put(d.getName(),d);
   }
   public void saveMovieDirectorPair(String movie,String director){

       if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
           // your code here

         //list of movies by given director
          List<String> movies=new ArrayList<>();
          movies.add(movie);
           directorMovieMapping.put(director,movies);//updated the director movie pair map

       }


   }
   public Movie findMovie(String name){
      for(Movie m:movieMap.values()){
          if(m.getName().equals(name)){
              return m;
          }
      }
return null;
   }
   public Director saveDirector(String name){
       for(Director d:directorMap.values()){
//           System.out.println(d.getName()+ " "+ name);
           if(d.getName().equals(name)){
               return d;
           }

       }

       return null;
   }

   public List<String> getMoviesByDirectorName(String name){
       List<String>movieslist=new ArrayList<>();
       for(String s:directorMovieMapping.keySet()){
           if(s.equals(name)){
               movieslist=directorMovieMapping.get(s);
           }
       }
       return movieslist;
   }
   public List<String>findAllMovies(){
       List<String>movieList=new ArrayList<>();
       for(String s: movieMap.keySet()){
          movieList.add(s);
       }
       return movieList;
   }
    public void deleteDirector(String name) {
        //delete director from director list
       for(String s:directorMap.keySet()){
           if(s.equals(name)){
               directorMap.remove(name);
           }
       }
       //delete movie of this director
        List<String> movieList=new ArrayList<>();//movie list of this director
       for(String s:directorMovieMapping.keySet()){
           if(s.equals(name)){
               movieList=directorMovieMapping.get(s);
               directorMovieMapping.remove(s);
           }
       }
       // remove movies from director movie list
       for(String s:movieList){
           movieMap.remove(s);
       }

    }

public void deleteAllDirectors(){

    for(String s:directorMap.keySet()){
        List<String> movielist=directorMovieMapping.get(s);
        for(String m:movielist){
            movieMap.remove(m);
        }
        directorMovieMapping.remove(s);
    }
    directorMap.clear();

}
}
