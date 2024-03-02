package com.driver;

import org.eclipse.jetty.server.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class watchlistcontroller {



    @Autowired
    private watchlistservice service;

    @PostMapping("/add-movies")
    public ResponseEntity<String> addmovie(@RequestBody Movie m){
        service.addmovie(m);
return ResponseEntity.status(HttpStatus.CREATED).body("Movie added");
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> adddirector(@RequestBody Director d){
        service.adddirector(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Director added");
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> updatemoviedirectorpair(){
service.updatemoviedirectorpair();
  return ResponseEntity.status(HttpStatus.CREATED).body("Movie-Director pair added successfully");
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getmoviebyname(@PathVariable String name){
Movie m=service.getmoviebyname(name);
return ResponseEntity.ok(m);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getdirectorbyname(@PathVariable String name){
        Director d=service.getdirectorbyname(name);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getmoviebydirectorname(@PathVariable String director){
       List<Movie> m =service.getmoviebydirectorname(director);
return ResponseEntity.ok(m);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> getallmovies(){
List<Movie> movies=service.getallmovies();
return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deletedirectorbyname(@PathVariable String name){
service.deletedirectorbyname(name);
return ResponseEntity.status(HttpStatus.OK).body("Director deleted ");
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deletealldirectors(){
service.deletealldirectors();
        return ResponseEntity.status(HttpStatus.OK).body("All directors deleted ");
    }

}
