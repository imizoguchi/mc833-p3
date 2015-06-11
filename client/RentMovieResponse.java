package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;

public class RentMovieResponse extends Response {

    public int response_code;

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
