package com.taskmanager.prueba.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.prueba.Model.Movie;
import com.taskmanager.prueba.Service.MovieService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping ("/Movies")
public class MovieController {

    private final MovieService movieService;
    public MovieController (MovieService movieService){
        this.movieService = movieService;
    }
    @PostMapping
    public Movie creatMovieById (@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }
    @GetMapping("/{id}")
    public Movie getMovies(@PathVariable Long id){
        return movieService.getMovieById(id);
    }
    @GetMapping
    public List <Movie> getMovies(){
        return movieService.getAllMovies();
    }
    @PutMapping("/{id}")
    public Movie updatMovieById (@PathVariable Long id, @RequestBody Movie movie){
        return movieService.updatMovieById(id, movie);
    }
    @DeleteMapping("/{id}")
    public boolean deleteMovieById (@PathVariable Long id){
        return movieService.deleteMovieById(id);
    }
}
