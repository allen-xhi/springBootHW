
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taxes_ implements Serializable
{

    @SerializedName("Tax")
    @Expose
    private List<Tax_> tax = null;
    @SerializedName("TaxSummary")
    @Expose
    private List<TaxSummary> taxSummary = null;
    @SerializedName("TotalTax")
    @Expose
    private TotalTax totalTax;
    private final static long serialVersionUID = 3970741405674338464L;

    public List<Tax_> getTax() {
        return tax;
    }

    public void setTax(List<Tax_> tax) {
        this.tax = tax;
    }

    public List<TaxSummary> getTaxSummary() {
        return taxSummary;
    }

    public void setTaxSummary(List<TaxSummary> taxSummary) {
        this.taxSummary = taxSummary;
    }

    public TotalTax getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(TotalTax totalTax) {
        this.totalTax = totalTax;
    }

}
