
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax implements Serializable
{

    @SerializedName("TaxCode")
    @Expose
    private String taxCode;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("DecimalPlaces")
    @Expose
    private Integer decimalPlaces;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = 196108354930110691L;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
