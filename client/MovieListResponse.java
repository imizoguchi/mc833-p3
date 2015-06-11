package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;
import java.util.*;

public class MovieListResponse extends Response {

    public List<Movie> movieList;

    public MovieListResponse() {
    	this.movieList = new ArrayList<Movie>();
    }

    public String toString() {

    	String s = "";

        if(movieList == null || movieList.isEmpty()) {
            s += "Não foi encontrado nenhum filme.\n";
        }
    	for(Movie m : movieList) {
    		s = s + m.toString() + "\n";
    	}

    	s = s + "processingTime: "+processingTime+"\n";

		return s;
    }
}
