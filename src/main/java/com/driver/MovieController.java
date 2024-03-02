package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {



    @Autowired
    private watchlistservice service;

    @PostMapping("/add-movies")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
        service.addMovie(m);
return ResponseEntity.status(HttpStatus.CREATED).body("Movie added");
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
        service.addDirector(d);
        return ResponseEntity.status(HttpStatus.CREATED).body("Director added");
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(){
service.addMovieDirectorPair();
  return ResponseEntity.status(HttpStatus.CREATED).body("Movie-Director pair added successfully");
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
Movie m=service.getMovieByName(name);
return ResponseEntity.ok(m);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director d=service.getDirectorByName(name);
        return ResponseEntity.ok(d);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String director){
       List<Movie> m =service.getMoviesByDirectorName(director);
return ResponseEntity.ok(m);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
List<Movie> movies=service.findAllMovies();
return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable String name){
service.deleteDirectorByName(name);
return ResponseEntity.status(HttpStatus.OK).body("Director deleted ");
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
service.deleteAllDirectors();
        return ResponseEntity.status(HttpStatus.OK).body("All directors deleted ");
    }

}
