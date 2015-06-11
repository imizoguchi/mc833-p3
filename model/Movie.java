package model;

public class Movie {
    
    public int id;
    public String title;
    public String synopsis;
    public String release_date;
    public String genre;
    public int inStock;

    public String toString() {
    	String value = "id:\t"+id+"\n";
    	value = value + "title:\t"+title+"\n";
    	value = value + "inStock:\t"+inStock+"\n";
    	value = value + "Released:\t"+release_date+"\n";
    	value = value + "Genre:\t"+genre+"\n";
    	value = value + "Synopsis:\t"+synopsis+"\n";
    	return value;
    }
}
