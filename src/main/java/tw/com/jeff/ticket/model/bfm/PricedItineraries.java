
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricedItineraries implements Serializable
{

    @SerializedName("PricedItinerary")
    @Expose
    private List<PricedItinerary> pricedItinerary = null;
    private final static long serialVersionUID = 7326658055778632750L;

    public List<PricedItinerary> getPricedItinerary() {
        return pricedItinerary;
    }

    public void setPricedItinerary(List<PricedItinerary> pricedItinerary) {
        this.pricedItinerary = pricedItinerary;
    }

}
