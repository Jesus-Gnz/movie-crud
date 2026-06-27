package com.taskmanager.prueba.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.prueba.Interfaz.MovieRepository;
import com.taskmanager.prueba.Model.Movie;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie (Movie movie){
        return movieRepository.save(movie);
    }
    public Movie getMovieById (Long id){
        return movieRepository.findById(id).orElse(null);
    }
    public boolean deleteMovieById (Long id){
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Movie updatMovieById (Long id, Movie movie){
            Movie existingMovie = movieRepository.findById(id).orElse(null);
            if (existingMovie != null) {
                existingMovie.setName(movie.getName());
                existingMovie.setMinutes(movie.getMinutes());
                existingMovie.setAnio(movie.getAnio());
                existingMovie.setDirector(movie.getDirector());
                existingMovie.setGenero(movie.getGenero());
                return movieRepository.save(existingMovie);
            }
        return null;
    }
    public List <Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
