 package client;

import compute.Request;
import model.RentalStore;
import java.io.Serializable;
import model.Movie;
import java.util.*;

public class MovieRequest implements Request<MovieResponse>, Serializable {

    private List<String> projection;
    private int id;

    public MovieRequest(int id, List<String> projection) {
    	this.id = id;
        this.projection = projection;
    }

    public MovieResponse execute(RentalStore store) {
        
        MovieResponse response = new MovieResponse();
        
        // start timing
        long t_start = System.nanoTime();

        response.movie = store.getMovie(this.id,this.projection);

        // stop timing
        long t_end = System.nanoTime();
        response.processingTime = t_end-t_start;
        return response;
    }
}
