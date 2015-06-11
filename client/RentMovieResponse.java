package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;

public class RentMovieResponse implements Serializable {

    public int response_code;
    public long processingTime;

    public String toString() {

    	String s = "";

        switch(response_code) {
        	case -1:
            	s += "Não há mais exemplares disponíveis.\n";
            	break;
            case -2:
            	s += "Identificador inexistente no banco de dados.\n";
            	break;
            default:
            	s += "Reserva feita com sucesso. Ainda há "+ response_code + " exemplares disponíveis\n";
        }

    	s = s + "processingTime: "+processingTime+"\n";

		return s;
    }
}
