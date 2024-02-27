
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Allowance implements Serializable
{

    @SerializedName("Weight")
    @Expose
    private Integer weight;
    @SerializedName("Unit")
    @Expose
    private String unit;
    @SerializedName("Pieces")
	@Expose
	private Integer pieces;
    private final static long serialVersionUID = 903532439956539326L;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

	public Integer getPieces() {
		
		return pieces;
	}
	public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

}
