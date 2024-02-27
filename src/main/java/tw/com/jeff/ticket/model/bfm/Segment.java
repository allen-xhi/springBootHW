
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Segment implements Serializable
{

    @SerializedName("Id")
    @Expose
    private Integer id;
    private final static long serialVersionUID = 5186206807819959095L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
