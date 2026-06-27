package com.taskmanager.prueba.Interfaz;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.prueba.Model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
