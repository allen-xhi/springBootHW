
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartureTimeZone implements Serializable
{

    @SerializedName("GMTOffset")
    @Expose
    private Float gMTOffset;
    private final static long serialVersionUID = 8978780303990078738L;

    public Float getGMTOffset() {
        return gMTOffset;
    }

    public void setGMTOffset(Float gMTOffset) {
        this.gMTOffset = gMTOffset;
    }

}
