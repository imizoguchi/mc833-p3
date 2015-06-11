package model;

import java.io.Serializable;

public class Movie implements Serializable {
    
    public int id;
    public String title;
    public String synopsis;
    public String release_date;
    public String genre;
    public Integer inStock;

    public String toString() {
    	String value = "id:\t"+id+"\n";
        if(title != null) value = value + "title:\t"+title+"\n";
    	if(inStock != null) value = value + "inStock:\t"+inStock+"\n";
    	if(release_date != null) value = value + "Released:\t"+release_date+"\n";
    	if(genre != null) value = value + "Genre:\t"+genre+"\n";
    	if(synopsis != null) value = value + "Synopsis:\t"+synopsis+"\n";
    	return value;
    }
}
