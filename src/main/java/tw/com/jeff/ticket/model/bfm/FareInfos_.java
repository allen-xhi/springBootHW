
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareInfos_ implements Serializable
{

    @SerializedName("FareInfo")
    @Expose
    private List<FareInfo_> fareInfo = null;
    private final static long serialVersionUID = 2415231721055052034L;

    public List<FareInfo_> getFareInfo() {
        return fareInfo;
    }

    public void setFareInfo(List<FareInfo_> fareInfo) {
        this.fareInfo = fareInfo;
    }

}
