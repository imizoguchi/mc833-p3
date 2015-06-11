package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;
import java.util.*;

public class MovieListResponse implements Serializable {

    public List<Movie> movieList;
    public int processingTime;
}
