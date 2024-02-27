
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareInfo implements Serializable
{

    @SerializedName("FareReference")
    @Expose
    private String fareReference;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions___ tPAExtensions;
    private final static long serialVersionUID = 574064631166506921L;

    public String getFareReference() {
        return fareReference;
    }

    public void setFareReference(String fareReference) {
        this.fareReference = fareReference;
    }

    public TPAExtensions___ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions___ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
