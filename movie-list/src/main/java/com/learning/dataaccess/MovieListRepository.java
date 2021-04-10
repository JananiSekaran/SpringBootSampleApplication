package com.learning.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.movies.model.Movie;

@Repository
public interface MovieListRepository extends JpaRepository<Movie, Long>{
	
	public List<Movie> findMovieByActor(String name);

}
