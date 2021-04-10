package com.learning.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.dataaccess.MovieListRepository;
import com.learning.movies.model.Movie;

@Controller
@RequestMapping("/")
@EnableJpaRepositories("com.learning.dataaccess")
public class MoviesController {
	
	 @Autowired
	 MovieListRepository movieListRepository;
	
	@RequestMapping(method = RequestMethod.GET,value="/movies/{actor}")
	public String getMovieByActor(@PathVariable("actor") String name, Model model)
	{
			
		List<Movie>	movieList=movieListRepository.findMovieByActor(name);
		model.addAttribute("movies",movieList);
		
		return "movielist";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/movies",consumes = "application/json")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie)
	{
		movieListRepository.save(movie);
		return ResponseEntity.ok().build();
	}

}
