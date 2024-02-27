
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions implements Serializable
{

    @SerializedName("eTicket")
    @Expose
    private ETicket eTicket;
    @SerializedName("Mileage")
    @Expose
    private Mileage mileage;
    private final static long serialVersionUID = -3423220539411555631L;

    public ETicket getETicket() {
        return eTicket;
    }

    public void setETicket(ETicket eTicket) {
        this.eTicket = eTicket;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public void setMileage(Mileage mileage) {
        this.mileage = mileage;
    }

}
