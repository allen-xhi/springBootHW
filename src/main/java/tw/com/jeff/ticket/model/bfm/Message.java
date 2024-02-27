
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements Serializable
{

    @SerializedName("AirlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("FailCode")
    @Expose
    private Integer failCode;
    @SerializedName("Info")
    @Expose
    private String info;
    private final static long serialVersionUID = -2679100401859938211L;

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFailCode() {
        return failCode;
    }

    public void setFailCode(Integer failCode) {
        this.failCode = failCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
