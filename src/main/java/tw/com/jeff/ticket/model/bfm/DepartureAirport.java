
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartureAirport implements Serializable
{

    @SerializedName("LocationCode")
    @Expose
    private String locationCode;
    @SerializedName("TerminalID")
    @Expose
    private String terminalID;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = 6623330165450183697L;

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
