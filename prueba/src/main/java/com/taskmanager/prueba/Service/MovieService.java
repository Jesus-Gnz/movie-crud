package com.taskmanager.prueba.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanager.prueba.Model.Movie;

@Service
public class MovieService {
    private List<Movie> movies = new ArrayList<>();
    private Long idCounter = 1L;

    public Movie createMovie (Movie movie){
        movie.setId(idCounter);
        idCounter++;
        movies.add(movie);
        return movie;
    }
    public Movie getMovieById (Long id){
        for (Movie n : movies){
            if (n.getId().equals(id)) {
                return n;
            }
        }
        return null;
    }
    public List<Movie> getAllMovies(){
        return movies;
    }
    public boolean deleteMovieById (Long id){
        return movies.removeIf(n -> n.getId().equals(id));
    }
    
    public Movie updatMovieById (Long id, Movie movie){
        for(Movie n: movies){
            if (n.getId().equals(id)) {
                n.setName(movie.getName());;
                n.setMinutes(movie.getMinutes());
                n.setGenero(movie.getGenero());
                n.setDirector(movie.getDirector());
                n.setAnio(movie.getAnio());
                return n;
            }
        }
        return null;
    }
}
