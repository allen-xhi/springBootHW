
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TPAExtensions____ implements Serializable
{

    @SerializedName("SeatsRemaining")
    @Expose
    private SeatsRemaining_ seatsRemaining;
    @SerializedName("Cabin")
    @Expose
    private Cabin_ cabin;
    @SerializedName("Meal")
    @Expose
    private Meal_ meal;
    private final static long serialVersionUID = -3881749410716567283L;

    public SeatsRemaining_ getSeatsRemaining() {
        return seatsRemaining;
    }

    public void setSeatsRemaining(SeatsRemaining_ seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }

    public Cabin_ getCabin() {
        return cabin;
    }

    public void setCabin(Cabin_ cabin) {
        this.cabin = cabin;
    }

    public Meal_ getMeal() {
        return meal;
    }

    public void setMeal(Meal_ meal) {
        this.meal = meal;
    }

}
