
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationOption implements Serializable
{

    @SerializedName("ElapsedTime")
    @Expose
    private Integer elapsedTime;
    @SerializedName("FlightSegment")
    @Expose
    private List<FlightSegment> flightSegment = null;
    private final static long serialVersionUID = -9096846361070860356L;

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public List<FlightSegment> getFlightSegment() {
        return flightSegment;
    }

    public void setFlightSegment(List<FlightSegment> flightSegment) {
        this.flightSegment = flightSegment;
    }

}
