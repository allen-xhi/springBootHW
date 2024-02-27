
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketingAirline implements Serializable
{

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = 6871042754309972833L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
