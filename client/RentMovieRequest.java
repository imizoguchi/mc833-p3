 package client;

import compute.Request;
import model.RentalStore;
import java.io.Serializable;
import model.Movie;
import java.util.*;

public class RentMovieRequest implements Request<RentMovieResponse>, Serializable {

    private int id;

    public RentMovieRequest(int id) {
    	this.id = id;
    }

    public RentMovieResponse execute(RentalStore store) {
        
        RentMovieResponse response = new RentMovieResponse();
        
        // start timing
        long t_start = System.nanoTime();

    	response.response_code = store.rentMovie(this.id);

        // stop timing
        long t_end = System.nanoTime();
        response.processingTime = t_end-t_start;
        return response;
    }
}
