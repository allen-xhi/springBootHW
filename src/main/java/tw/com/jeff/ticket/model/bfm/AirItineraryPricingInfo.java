
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import tw.com.jeff.ticket.model.bfm.TPAExtensions_____;

public class AirItineraryPricingInfo implements Serializable
{

    @SerializedName("LastTicketDate")
    @Expose
    private String lastTicketDate;
    @SerializedName("PrivateFareType")
    @Expose
    private String privateFareType;
    @SerializedName("PricingSource")
    @Expose
    private String pricingSource;
    @SerializedName("PricingSubSource")
    @Expose
    private String pricingSubSource;
    @SerializedName("FareReturned")
    @Expose
    private Boolean fareReturned;
    @SerializedName("ItinTotalFare")
    @Expose
    private ItinTotalFare itinTotalFare;
    @SerializedName("PTC_FareBreakdowns")
    @Expose
    private PTCFareBreakdowns pTCFareBreakdowns;
    @SerializedName("FareInfos")
    @Expose
    private FareInfos_ fareInfos;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions_____ tPAExtensions;
    private final static long serialVersionUID = 2925523133042583169L;

    public String getLastTicketDate() {
        return lastTicketDate;
    }

    public void setLastTicketDate(String lastTicketDate) {
        this.lastTicketDate = lastTicketDate;
    }

    public String getPrivateFareType() {
        return privateFareType;
    }

    public void setPrivateFareType(String privateFareType) {
        this.privateFareType = privateFareType;
    }

    public String getPricingSource() {
        return pricingSource;
    }

    public void setPricingSource(String pricingSource) {
        this.pricingSource = pricingSource;
    }

    public String getPricingSubSource() {
        return pricingSubSource;
    }

    public void setPricingSubSource(String pricingSubSource) {
        this.pricingSubSource = pricingSubSource;
    }

    public Boolean getFareReturned() {
        return fareReturned;
    }

    public void setFareReturned(Boolean fareReturned) {
        this.fareReturned = fareReturned;
    }

    public ItinTotalFare getItinTotalFare() {
        return itinTotalFare;
    }

    public void setItinTotalFare(ItinTotalFare itinTotalFare) {
        this.itinTotalFare = itinTotalFare;
    }

    public PTCFareBreakdowns getPTCFareBreakdowns() {
        return pTCFareBreakdowns;
    }

    public void setPTCFareBreakdowns(PTCFareBreakdowns pTCFareBreakdowns) {
        this.pTCFareBreakdowns = pTCFareBreakdowns;
    }

    public FareInfos_ getFareInfos() {
        return fareInfos;
    }

    public void setFareInfos(FareInfos_ fareInfos) {
        this.fareInfos = fareInfos;
    }

    public TPAExtensions_____ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions_____ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
