
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaggageInformationList implements Serializable
{

    @SerializedName("BaggageInformation")
    @Expose
    private List<BaggageInformation> baggageInformation = null;
    private final static long serialVersionUID = 523108738757637335L;

    public List<BaggageInformation> getBaggageInformation() {
        return baggageInformation;
    }

    public void setBaggageInformation(List<BaggageInformation> baggageInformation) {
        this.baggageInformation = baggageInformation;
    }

}
