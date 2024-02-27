
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeatsRemaining_ implements Serializable
{

    @SerializedName("Number")
    @Expose
    private Integer number;
    @SerializedName("BelowMin")
    @Expose
    private Boolean belowMin;
    private final static long serialVersionUID = -2707301196370448402L;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getBelowMin() {
        return belowMin;
    }

    public void setBelowMin(Boolean belowMin) {
        this.belowMin = belowMin;
    }

}
