
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaggageInformation implements Serializable
{

    @SerializedName("ProvisionType")
    @Expose
    private String provisionType;
    @SerializedName("AirlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("Segment")
    @Expose
    private List<Segment> segment = null;
    @SerializedName("Allowance")
    @Expose
    private List<Allowance> allowance = null;
    private final static long serialVersionUID = 5547778399514877415L;

    public String getProvisionType() {
        return provisionType;
    }

    public void setProvisionType(String provisionType) {
        this.provisionType = provisionType;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public List<Segment> getSegment() {
        return segment;
    }

    public void setSegment(List<Segment> segment) {
        this.segment = segment;
    }

    public List<Allowance> getAllowance() {
        return allowance;
    }

    public void setAllowance(List<Allowance> allowance) {
        this.allowance = allowance;
    }

}
