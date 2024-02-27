
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareCalcLine implements Serializable
{

    @SerializedName("Info")
    @Expose
    private String info;
    private final static long serialVersionUID = -3548931247419971027L;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
