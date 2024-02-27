
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaxSummary implements Serializable
{

    @SerializedName("TaxCode")
    @Expose
    private String taxCode;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
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
    private final static long serialVersionUID = 3518212968757562635L;

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
