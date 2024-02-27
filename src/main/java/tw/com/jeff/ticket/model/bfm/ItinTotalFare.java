
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItinTotalFare implements Serializable
{

    @SerializedName("BaseFare")
    @Expose
    private BaseFare baseFare;
    @SerializedName("FareConstruction")
    @Expose
    private FareConstruction fareConstruction;
    @SerializedName("EquivFare")
    @Expose
    private EquivFare equivFare;
    @SerializedName("Taxes")
    @Expose
    private Taxes taxes;
    @SerializedName("TotalFare")
    @Expose
    private TotalFare totalFare;
    private final static long serialVersionUID = -2855836215880402679L;

    public BaseFare getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BaseFare baseFare) {
        this.baseFare = baseFare;
    }

    public FareConstruction getFareConstruction() {
        return fareConstruction;
    }

    public void setFareConstruction(FareConstruction fareConstruction) {
        this.fareConstruction = fareConstruction;
    }

    public EquivFare getEquivFare() {
        return equivFare;
    }

    public void setEquivFare(EquivFare equivFare) {
        this.equivFare = equivFare;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    public TotalFare getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(TotalFare totalFare) {
        this.totalFare = totalFare;
    }

}
