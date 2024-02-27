
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirItinerary implements Serializable
{

    @SerializedName("DirectionInd")
    @Expose
    private String directionInd;
    @SerializedName("OriginDestinationOptions")
    @Expose
    private OriginDestinationOptions originDestinationOptions;
    private final static long serialVersionUID = 2625841088570790140L;

    public String getDirectionInd() {
        return directionInd;
    }

    public void setDirectionInd(String directionInd) {
        this.directionInd = directionInd;
    }

    public OriginDestinationOptions getOriginDestinationOptions() {
        return originDestinationOptions;
    }

    public void setOriginDestinationOptions(OriginDestinationOptions originDestinationOptions) {
        this.originDestinationOptions = originDestinationOptions;
    }

}
