
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions___ implements Serializable
{

    @SerializedName("SeatsRemaining")
    @Expose
    private SeatsRemaining seatsRemaining;
    @SerializedName("Cabin")
    @Expose
    private Cabin cabin;
    @SerializedName("Meal")
    @Expose
    private Meal meal;
    private final static long serialVersionUID = -4023370624533314953L;

    public SeatsRemaining getSeatsRemaining() {
        return seatsRemaining;
    }

    public void setSeatsRemaining(SeatsRemaining seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

}
