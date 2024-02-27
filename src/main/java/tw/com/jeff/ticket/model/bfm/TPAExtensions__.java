
package tw.com.jeff.ticket.model.bfm;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions__ implements Serializable
{

    @SerializedName("FareCalcLine")
    @Expose
    private FareCalcLine fareCalcLine;
    private final static long serialVersionUID = -2842947863334161574L;

    public FareCalcLine getFareCalcLine() {
        return fareCalcLine;
    }

    public void setFareCalcLine(FareCalcLine fareCalcLine) {
        this.fareCalcLine = fareCalcLine;
    }

}
