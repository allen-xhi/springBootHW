
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cabin_ implements Serializable
{

    @SerializedName("Cabin")
    @Expose
    private String cabin;
    private final static long serialVersionUID = 4360450119797120485L;

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

}
