package client;

import compute.Request;
import model.Movie;
import java.io.Serializable;

public class Response implements Serializable {

    public long processingTime;
    public long totalTime;
}
