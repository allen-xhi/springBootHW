
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETicket implements Serializable
{

    @SerializedName("Ind")
    @Expose
    private Boolean ind;
    private final static long serialVersionUID = -5160574055679320096L;

    public Boolean getInd() {
        return ind;
    }

    public void setInd(Boolean ind) {
        this.ind = ind;
    }

}
