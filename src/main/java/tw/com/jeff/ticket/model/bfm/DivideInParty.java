
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DivideInParty implements Serializable
{

    @SerializedName("Indicator")
    @Expose
    private Boolean indicator;
    private final static long serialVersionUID = 5338958002253213407L;

    public Boolean getIndicator() {
        return indicator;
    }

    public void setIndicator(Boolean indicator) {
        this.indicator = indicator;
    }

}
