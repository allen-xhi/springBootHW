
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Messages implements Serializable
{

    @SerializedName("Message")
    @Expose
    private List<Message> message = null;
    private final static long serialVersionUID = 2389618611356707828L;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

}
