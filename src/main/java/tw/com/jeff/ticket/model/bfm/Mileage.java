
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mileage implements Serializable
{

    @SerializedName("Amount")
    @Expose
    private Integer amount;
    private final static long serialVersionUID = 5100911644449001585L;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
