
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareBasisCodes implements Serializable
{

    @SerializedName("FareBasisCode")
    @Expose
    private List<FareBasisCode> fareBasisCode = null;
    private final static long serialVersionUID = -4877626305765515683L;

    public List<FareBasisCode> getFareBasisCode() {
        return fareBasisCode;
    }

    public void setFareBasisCode(List<FareBasisCode> fareBasisCode) {
        this.fareBasisCode = fareBasisCode;
    }

}
