
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassengerTypeQuantity implements Serializable
{

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    private final static long serialVersionUID = -314354593554099976L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
