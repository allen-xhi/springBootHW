
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OriginDestinationOptions implements Serializable
{

    @SerializedName("OriginDestinationOption")
    @Expose
    private List<OriginDestinationOption> originDestinationOption = null;
    private final static long serialVersionUID = 2707842062744393983L;

    public List<OriginDestinationOption> getOriginDestinationOption() {
        return originDestinationOption;
    }

    public void setOriginDestinationOption(List<OriginDestinationOption> originDestinationOption) {
        this.originDestinationOption = originDestinationOption;
    }

}
