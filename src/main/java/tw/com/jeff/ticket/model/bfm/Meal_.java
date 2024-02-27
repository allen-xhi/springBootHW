
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal_ implements Serializable
{

    @SerializedName("Code")
    @Expose
    private String code;
    private final static long serialVersionUID = -228615309068395624L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
