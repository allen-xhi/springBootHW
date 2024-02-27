
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArrivalTimeZone implements Serializable
{

    @SerializedName("GMTOffset")
    @Expose
    private Float gMTOffset;
    private final static long serialVersionUID = 6708265854424238088L;

    public Float getGMTOffset() {
        return gMTOffset;
    }

    public void setGMTOffset(Float gMTOffset) {
        this.gMTOffset = gMTOffset;
    }

}
