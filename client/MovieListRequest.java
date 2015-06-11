 package client;

import compute.Request;
import model.RentalStore;
import java.io.Serializable;
import java.util.*;

public class MovieListRequest implements Request<MovieListResponse>, Serializable {

    private static final long serialVersionUID = 227L;
    private List<String> projection;
    public MovieListRequest(List<String> projection) {
        this.projection = projection;
    }

    public MovieListResponse execute(RentalStore store) {
        MovieListResponse response = new MovieListResponse();
        response.processingTime = 10;
        return response;
    }
}
