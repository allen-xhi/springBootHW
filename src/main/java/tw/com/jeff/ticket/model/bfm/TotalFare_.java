
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalFare_ implements Serializable
{

    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    private final static long serialVersionUID = 2234506223565648902L;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}
