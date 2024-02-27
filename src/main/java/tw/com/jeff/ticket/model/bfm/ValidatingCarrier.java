
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidatingCarrier implements Serializable
{

    @SerializedName("Code")
    @Expose
    private String code;
    private final static long serialVersionUID = -8313411791737818907L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
