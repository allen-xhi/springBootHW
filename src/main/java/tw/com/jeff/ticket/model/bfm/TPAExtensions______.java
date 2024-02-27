
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions______ implements Serializable
{

    @SerializedName("ValidatingCarrier")
    @Expose
    private ValidatingCarrier validatingCarrier;
    @SerializedName("DiversitySwapper")
    @Expose
    private DiversitySwapper diversitySwapper;
    private final static long serialVersionUID = 8871265974810119309L;

    public ValidatingCarrier getValidatingCarrier() {
        return validatingCarrier;
    }

    public void setValidatingCarrier(ValidatingCarrier validatingCarrier) {
        this.validatingCarrier = validatingCarrier;
    }

    public DiversitySwapper getDiversitySwapper() {
        return diversitySwapper;
    }

    public void setDiversitySwapper(DiversitySwapper diversitySwapper) {
        this.diversitySwapper = diversitySwapper;
    }

}
