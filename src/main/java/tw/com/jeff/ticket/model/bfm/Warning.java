
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Warning implements Serializable
{

    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("ShortText")
    @Expose
    private String shortText;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("MessageClass")
    @Expose
    private String messageClass;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = -4225072519373393632L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessageClass() {
        return messageClass;
    }

    public void setMessageClass(String messageClass) {
        this.messageClass = messageClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
