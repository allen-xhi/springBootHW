
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PTCFareBreakdowns implements Serializable
{

    @SerializedName("PTC_FareBreakdown")
    @Expose
    private List<PTCFareBreakdown> pTCFareBreakdown = null;
    private final static long serialVersionUID = 6706639357620163079L;

    public List<PTCFareBreakdown> getPTCFareBreakdown() {
        return pTCFareBreakdown;
    }

    public void setPTCFareBreakdown(List<PTCFareBreakdown> pTCFareBreakdown) {
        this.pTCFareBreakdown = pTCFareBreakdown;
    }

}
