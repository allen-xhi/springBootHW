
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipment implements Serializable
{

    @SerializedName("AirEquipType")
    @Expose
    private String airEquipType;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = -5958801952405575951L;

    public String getAirEquipType() {
        return airEquipType;
    }

    public void setAirEquipType(String airEquipType) {
        this.airEquipType = airEquipType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
