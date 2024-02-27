
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EquivFare implements Serializable
{

    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("DecimalPlaces")
    @Expose
    private Integer decimalPlaces;
    private final static long serialVersionUID = 6853615806647260882L;

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

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

}
