
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions_____ implements Serializable
{

    @SerializedName("DivideInParty")
    @Expose
    private DivideInParty divideInParty;
    private final static long serialVersionUID = -3752646333620651441L;

    public DivideInParty getDivideInParty() {
        return divideInParty;
    }

    public void setDivideInParty(DivideInParty divideInParty) {
        this.divideInParty = divideInParty;
    }

}
