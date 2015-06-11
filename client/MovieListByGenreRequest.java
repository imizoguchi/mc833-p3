 package client;

import compute.Request;
import model.RentalStore;
import java.io.Serializable;
import model.Movie;
import java.util.*;

public class MovieListByGenreRequest implements Request<MovieListResponse>, Serializable {

    private String genre;
    private List<String> projection;

    public MovieListByGenreRequest(String genre, List<String> projection) {
        this.genre = genre;
        this.projection = projection;
    }

    public MovieListResponse execute(RentalStore store) {
        
        MovieListResponse response = new MovieListResponse();
        response.movieList = new ArrayList<Movie>();
        
        // start timing
        long t_start = System.nanoTime();

        for(Movie m : store.movieList) {
        	if(this.genre.equals(m.genre)) {
	            Movie movie = new Movie();
	            movie.id = m.id;
	            for(String value : this.projection) {
	                if(value.equals("title")) { 
	                    movie.title = m.title;
	                } else if(value.equals("synopsis")) {
	                    movie.synopsis = m.synopsis;
	                } else if(value.equals("release_date")) {
	                    movie.release_date = m.release_date;
	                } else if(value.equals("genre")) {
	                    movie.genre = m.genre;
	                } else if(value.equals("inStock")) {
	                    movie.inStock = m.inStock;
	                }
	            }

	            response.movieList.add(movie);
	        }
        }

        // stop timing
        long t_end = System.nanoTime();
        response.processingTime = t_end-t_start;
        return response;
    }
}
