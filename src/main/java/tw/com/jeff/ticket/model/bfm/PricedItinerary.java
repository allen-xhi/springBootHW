
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PricedItinerary implements Serializable
{

    @SerializedName("SequenceNumber")
    @Expose
    private Integer sequenceNumber;
    @SerializedName("AirItinerary")
    @Expose
    private AirItinerary airItinerary;
    @SerializedName("AirItineraryPricingInfo")
    @Expose
    private List<AirItineraryPricingInfo> airItineraryPricingInfo = null;
    @SerializedName("TicketingInfo")
    @Expose
    private TicketingInfo ticketingInfo;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions______ tPAExtensions;
    private final static long serialVersionUID = 9124916744967234410L;

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public AirItinerary getAirItinerary() {
        return airItinerary;
    }

    public void setAirItinerary(AirItinerary airItinerary) {
        this.airItinerary = airItinerary;
    }

    public List<AirItineraryPricingInfo> getAirItineraryPricingInfo() {
        return airItineraryPricingInfo;
    }

    public void setAirItineraryPricingInfo(List<AirItineraryPricingInfo> airItineraryPricingInfo) {
        this.airItineraryPricingInfo = airItineraryPricingInfo;
    }

    public TicketingInfo getTicketingInfo() {
        return ticketingInfo;
    }

    public void setTicketingInfo(TicketingInfo ticketingInfo) {
        this.ticketingInfo = ticketingInfo;
    }

    public TPAExtensions______ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions______ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
