
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OperatingAirline implements Serializable
{

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = 4120835006449330846L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
