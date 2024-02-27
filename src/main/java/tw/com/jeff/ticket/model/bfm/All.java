
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class All implements Serializable
{

    @SerializedName("OTA_AirLowFareSearchRS")
    @Expose
    private OTAAirLowFareSearchRS oTAAirLowFareSearchRS;
    private final static long serialVersionUID = -9099315109152117852L;

    public OTAAirLowFareSearchRS getOTAAirLowFareSearchRS() {
        return oTAAirLowFareSearchRS;
    }

    public void setOTAAirLowFareSearchRS(OTAAirLowFareSearchRS oTAAirLowFareSearchRS) {
        this.oTAAirLowFareSearchRS = oTAAirLowFareSearchRS;
    }

}
