
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiversitySwapper implements Serializable
{

    @SerializedName("WeighedPriceAmount")
    @Expose
    private Float weighedPriceAmount;
    private final static long serialVersionUID = 5113830598670860903L;

    public Float getWeighedPriceAmount() {
        return weighedPriceAmount;
    }

    public void setWeighedPriceAmount(Float weighedPriceAmount) {
        this.weighedPriceAmount = weighedPriceAmount;
    }

}
