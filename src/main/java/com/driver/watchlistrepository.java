package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class watchlistrepository {

private final HashMap<String,Movie>movies=new HashMap<>();
  private final HashMap<String,Director>directors=new HashMap<>();
   private final HashMap<String,String>moviesdirectorpair=new HashMap<>();

   public void addmovie(Movie m){
       movies.put(m.getName(),m);
   }
   public void adddirector(Director d){
       directors.put(d.getName(),d);
   }
   public void updatemoviedirectorpair(){
       for(Movie val:movies.values()){
           String d=val.getDirector();
           if(!directors.isEmpty() && directors.containsKey(d)){
               moviesdirectorpair.put(val.getName(), d);
           }
       }
   }
   public Movie getmoviebyname(String name){
      for(Movie m:movies.values()){
          if(m.getName().equals(name)){
              return m;
          }
      }
return null;
   }
   public Director getdirectorbyname(String name){
       for(Director d:directors.values()){
//           System.out.println(d.getName()+ " "+ name);
           if(d.getName().equals(name)){
               return d;
           }

       }

       return null;
   }

   public List<Movie> getmoviebydirectorname(String name){
       List<Movie>ans=new ArrayList<>();
       for(Movie m:movies.values()){
           if(m.getDirector().equals(name)){
               ans.add(m);
           }
       }
       return ans;
   }
   public List<Movie>getallmovies(){
       List<Movie>ans=new ArrayList<>();
       for(Movie m: movies.values()){
           ans.add(m);
       }
       return ans;
   }
public void deletedirectorbyname(String name){
       if(directors.containsKey(name)){
           directors.remove(name);
       }


}

public void deletealldirectors(){
       directors.clear();
}
}
