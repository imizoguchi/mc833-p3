package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;

public class MovieResponse extends Response {

    public Movie movie;

    public String toString() {

    	String s = "";

        if(movie == null) {
            s += "Não foi encontrado nenhum filme.\n";
        } else {
        	s = s + this.movie.toString() + "\n";
        }

    	s = s + "processingTime: "+processingTime+"\n";

		return s;
    }
}
