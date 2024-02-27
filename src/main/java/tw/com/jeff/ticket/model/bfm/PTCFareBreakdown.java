
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PTCFareBreakdown implements Serializable
{

    @SerializedName("PrivateFareType")
    @Expose
    private String privateFareType;
    @SerializedName("PassengerTypeQuantity")
    @Expose
    private PassengerTypeQuantity passengerTypeQuantity;
    @SerializedName("FareBasisCodes")
    @Expose
    private FareBasisCodes fareBasisCodes;
    @SerializedName("PassengerFare")
    @Expose
    private PassengerFare passengerFare;
    @SerializedName("Endorsements")
    @Expose
    private Endorsements endorsements;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions__ tPAExtensions;
    @SerializedName("FareInfos")
    @Expose
    private FareInfos fareInfos;
    private final static long serialVersionUID = -4031012454403405706L;

    public String getPrivateFareType() {
        return privateFareType;
    }

    public void setPrivateFareType(String privateFareType) {
        this.privateFareType = privateFareType;
    }

    public PassengerTypeQuantity getPassengerTypeQuantity() {
        return passengerTypeQuantity;
    }

    public void setPassengerTypeQuantity(PassengerTypeQuantity passengerTypeQuantity) {
        this.passengerTypeQuantity = passengerTypeQuantity;
    }

    public FareBasisCodes getFareBasisCodes() {
        return fareBasisCodes;
    }

    public void setFareBasisCodes(FareBasisCodes fareBasisCodes) {
        this.fareBasisCodes = fareBasisCodes;
    }

    public PassengerFare getPassengerFare() {
        return passengerFare;
    }

    public void setPassengerFare(PassengerFare passengerFare) {
        this.passengerFare = passengerFare;
    }

    public Endorsements getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(Endorsements endorsements) {
        this.endorsements = endorsements;
    }

    public TPAExtensions__ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions__ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

    public FareInfos getFareInfos() {
        return fareInfos;
    }

    public void setFareInfos(FareInfos fareInfos) {
        this.fareInfos = fareInfos;
    }

}
