
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassengerFare implements Serializable
{

    @SerializedName("BaseFare")
    @Expose
    private BaseFare_ baseFare;
    @SerializedName("FareConstruction")
    @Expose
    private FareConstruction_ fareConstruction;
    @SerializedName("EquivFare")
    @Expose
    private EquivFare_ equivFare;
    @SerializedName("Taxes")
    @Expose
    private Taxes_ taxes;
    @SerializedName("TotalFare")
    @Expose
    private TotalFare_ totalFare;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions_ tPAExtensions;
    private final static long serialVersionUID = -6201794942971848811L;

    public BaseFare_ getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BaseFare_ baseFare) {
        this.baseFare = baseFare;
    }

    public FareConstruction_ getFareConstruction() {
        return fareConstruction;
    }

    public void setFareConstruction(FareConstruction_ fareConstruction) {
        this.fareConstruction = fareConstruction;
    }

    public EquivFare_ getEquivFare() {
        return equivFare;
    }

    public void setEquivFare(EquivFare_ equivFare) {
        this.equivFare = equivFare;
    }

    public Taxes_ getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes_ taxes) {
        this.taxes = taxes;
    }

    public TotalFare_ getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(TotalFare_ totalFare) {
        this.totalFare = totalFare;
    }

    public TPAExtensions_ getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions_ tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
