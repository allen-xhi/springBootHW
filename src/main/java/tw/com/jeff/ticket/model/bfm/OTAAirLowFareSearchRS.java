
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OTAAirLowFareSearchRS implements Serializable
{

    @SerializedName("PricedItinCount")
    @Expose
    private Integer pricedItinCount;
    @SerializedName("BrandedOneWayItinCount")
    @Expose
    private Integer brandedOneWayItinCount;
    @SerializedName("SimpleOneWayItinCount")
    @Expose
    private Integer simpleOneWayItinCount;
    @SerializedName("DepartedItinCount")
    @Expose
    private Integer departedItinCount;
    @SerializedName("SoldOutItinCount")
    @Expose
    private Integer soldOutItinCount;
    @SerializedName("AvailableItinCount")
    @Expose
    private Integer availableItinCount;
    @SerializedName("Version")
    @Expose
    private String version;
    @SerializedName("Success")
    @Expose
    private Success success;
    @SerializedName("Warnings")
    @Expose
    private Warnings warnings;
    @SerializedName("PricedItineraries")
    @Expose
    private PricedItineraries pricedItineraries;
    private final static long serialVersionUID = 6534161235045567961L;

    public Integer getPricedItinCount() {
        return pricedItinCount;
    }

    public void setPricedItinCount(Integer pricedItinCount) {
        this.pricedItinCount = pricedItinCount;
    }

    public Integer getBrandedOneWayItinCount() {
        return brandedOneWayItinCount;
    }

    public void setBrandedOneWayItinCount(Integer brandedOneWayItinCount) {
        this.brandedOneWayItinCount = brandedOneWayItinCount;
    }

    public Integer getSimpleOneWayItinCount() {
        return simpleOneWayItinCount;
    }

    public void setSimpleOneWayItinCount(Integer simpleOneWayItinCount) {
        this.simpleOneWayItinCount = simpleOneWayItinCount;
    }

    public Integer getDepartedItinCount() {
        return departedItinCount;
    }

    public void setDepartedItinCount(Integer departedItinCount) {
        this.departedItinCount = departedItinCount;
    }

    public Integer getSoldOutItinCount() {
        return soldOutItinCount;
    }

    public void setSoldOutItinCount(Integer soldOutItinCount) {
        this.soldOutItinCount = soldOutItinCount;
    }

    public Integer getAvailableItinCount() {
        return availableItinCount;
    }

    public void setAvailableItinCount(Integer availableItinCount) {
        this.availableItinCount = availableItinCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public Warnings getWarnings() {
        return warnings;
    }

    public void setWarnings(Warnings warnings) {
        this.warnings = warnings;
    }

    public PricedItineraries getPricedItineraries() {
        return pricedItineraries;
    }

    public void setPricedItineraries(PricedItineraries pricedItineraries) {
        this.pricedItineraries = pricedItineraries;
    }

}
