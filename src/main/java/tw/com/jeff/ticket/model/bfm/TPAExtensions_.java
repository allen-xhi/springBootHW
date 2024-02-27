
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions_ implements Serializable
{

    @SerializedName("Messages")
    @Expose
    private Messages messages;
    @SerializedName("BaggageInformationList")
    @Expose
    private BaggageInformationList baggageInformationList;
    private final static long serialVersionUID = -1833083699951101885L;

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public BaggageInformationList getBaggageInformationList() {
        return baggageInformationList;
    }

    public void setBaggageInformationList(BaggageInformationList baggageInformationList) {
        this.baggageInformationList = baggageInformationList;
    }

}
