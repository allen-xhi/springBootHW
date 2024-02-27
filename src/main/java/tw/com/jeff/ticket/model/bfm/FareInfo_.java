
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareInfo_ implements Serializable
{

    @SerializedName("FareReference")
    @Expose
    private String fareReference;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions____ tPAExtensions;
    private final static long serialVersionUID = -9002103795403803030L;

    public String getFareReference() {
        return fareReference;
    }

    public void setFareReference(String fareReference) {
        this.fareReference = fareReference;
    }

    public TPAExtensions____ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions____ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
