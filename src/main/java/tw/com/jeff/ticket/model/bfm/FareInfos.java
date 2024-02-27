
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareInfos implements Serializable
{

    @SerializedName("FareInfo")
    @Expose
    private List<FareInfo> fareInfo = null;
    private final static long serialVersionUID = -692673363298390381L;

    public List<FareInfo> getFareInfo() {
        return fareInfo;
    }

    public void setFareInfo(List<FareInfo> fareInfo) {
        this.fareInfo = fareInfo;
    }

}
