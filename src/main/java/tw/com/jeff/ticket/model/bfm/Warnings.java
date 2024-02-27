
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Warnings implements Serializable
{

    @SerializedName("Warning")
    @Expose
    private List<Warning> warning = null;
    private final static long serialVersionUID = -8309085724744899623L;

    public List<Warning> getWarning() {
        return warning;
    }

    public void setWarning(List<Warning> warning) {
        this.warning = warning;
    }

}
