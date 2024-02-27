
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TicketingInfo implements Serializable
{

    @SerializedName("TicketType")
    @Expose
    private String ticketType;
    @SerializedName("ValidInterline")
    @Expose
    private String validInterline;
    private final static long serialVersionUID = 6762236922421806615L;

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getValidInterline() {
        return validInterline;
    }

    public void setValidInterline(String validInterline) {
        this.validInterline = validInterline;
    }

}
