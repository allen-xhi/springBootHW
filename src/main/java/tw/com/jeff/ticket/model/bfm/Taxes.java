
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taxes implements Serializable
{

    @SerializedName("Tax")
    @Expose
    private List<Tax> tax = null;
    private final static long serialVersionUID = 6604975358599940491L;

    public List<Tax> getTax() {
        return tax;
    }

    public void setTax(List<Tax> tax) {
        this.tax = tax;
    }

}
