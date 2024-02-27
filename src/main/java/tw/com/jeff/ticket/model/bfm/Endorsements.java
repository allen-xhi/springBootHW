
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Endorsements implements Serializable
{

    @SerializedName("NonRefundableIndicator")
    @Expose
    private Boolean nonRefundableIndicator;
    private final static long serialVersionUID = 2506986834750499065L;

    public Boolean getNonRefundableIndicator() {
        return nonRefundableIndicator;
    }

    public void setNonRefundableIndicator(Boolean nonRefundableIndicator) {
        this.nonRefundableIndicator = nonRefundableIndicator;
    }

}
