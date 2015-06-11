package model;

import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import model.Movie;

public class RentalStore {

    public List<Movie> movieList;

    public void init(String filename) {
        this.movieList = new ArrayList<Movie>();
        JsonObject jsonObject = convertFileToJSON(filename);
        
        // For each movie
        for(JsonElement e : jsonObject.getAsJsonArray("movies")) {

            Movie m = new Movie();

            JsonObject o = e.getAsJsonObject();
            m.id = o.get("id").getAsInt();
            m.title = o.get("title").getAsString();
            m.release_date = o.get("release_dates").getAsJsonObject().get("theater").getAsString();
            m.synopsis = o.get("synopsis").getAsString();
            movieList.add(m);

            Random r = new Random();
            m.inStock = r.nextInt(5);
            switch(r.nextInt(5)) {
                case 0: m.genre = "Comedy"; break;
                case 1: m.genre = "Drama"; break;
                case 2: m.genre = "Action"; break;
                case 3: m.genre = "Romance"; break;
                case 4: m.genre = "Horror"; break;
            }
        }
    }
    public List<Movie> getMovies(List<String> projection) {
        return getMovies(null,projection);
    }

    public List<Movie> getMovies(String genre, List<String> projection) {

        List<Movie> movies = new ArrayList<Movie>();

        for(Movie m : movieList) {
            if(genre == null || genre.equals(m.genre)) {
                Movie movie = new Movie();
                movie.id = m.id;
                for(String value : projection) {
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
                movies.add(movie);
            }
        }

        return movies;
    }

    public Movie getMovie(int id, List<String> projection) {

        for(Movie m : movieList) {
            if(m.id == id) {
                Movie movie = new Movie();
                
                movie.id = m.id;

                for(String value : projection) {
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
                return movie;
            }
        }

        return null;
    }

    public int rentMovie(int id) {

        for(Movie m : movieList) {
            if(m.id == id) {
                if(m.inStock == 0) {
                    return -1;
                } else {
                    m.inStock--;
                    return m.inStock;
                }
            }
        }

        return -2;
    }

    public static JsonObject convertFileToJSON (String fileName) {
 
        // Read from File to String
        JsonObject jsonObject = new JsonObject();
        
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader(fileName));
            jsonObject = jsonElement.getAsJsonObject();
        } catch (IOException ioe){}   
        return jsonObject;
    }

}
