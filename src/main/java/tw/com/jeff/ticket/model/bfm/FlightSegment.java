
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightSegment implements Serializable
{

    @SerializedName("DepartureDateTime")
    @Expose
    private String departureDateTime;
    @SerializedName("ArrivalDateTime")
    @Expose
    private String arrivalDateTime;
    @SerializedName("StopQuantity")
    @Expose
    private Integer stopQuantity;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("ResBookDesigCode")
    @Expose
    private String resBookDesigCode;
    @SerializedName("ElapsedTime")
    @Expose
    private Integer elapsedTime;
    @SerializedName("DepartureAirport")
    @Expose
    private DepartureAirport departureAirport;
    @SerializedName("ArrivalAirport")
    @Expose
    private ArrivalAirport arrivalAirport;
    @SerializedName("OperatingAirline")
    @Expose
    private OperatingAirline operatingAirline;
    @SerializedName("Equipment")
    @Expose
    private List<Equipment> equipment = null;
    @SerializedName("MarketingAirline")
    @Expose
    private MarketingAirline marketingAirline;
    @SerializedName("MarriageGrp")
    @Expose
    private String marriageGrp;
    @SerializedName("DepartureTimeZone")
    @Expose
    private DepartureTimeZone departureTimeZone;
    @SerializedName("ArrivalTimeZone")
    @Expose
    private ArrivalTimeZone arrivalTimeZone;
    @SerializedName("TPA_Extensions")
    @Expose
    private TPAExtensions tPAExtensions;
    private final static long serialVersionUID = -2396789279184056891L;

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Integer getStopQuantity() {
        return stopQuantity;
    }

    public void setStopQuantity(Integer stopQuantity) {
        this.stopQuantity = stopQuantity;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getResBookDesigCode() {
        return resBookDesigCode;
    }

    public void setResBookDesigCode(String resBookDesigCode) {
        this.resBookDesigCode = resBookDesigCode;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public DepartureAirport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(DepartureAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public ArrivalAirport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(ArrivalAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public OperatingAirline getOperatingAirline() {
        return operatingAirline;
    }

    public void setOperatingAirline(OperatingAirline operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public MarketingAirline getMarketingAirline() {
        return marketingAirline;
    }

    public void setMarketingAirline(MarketingAirline marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public String getMarriageGrp() {
        return marriageGrp;
    }

    public void setMarriageGrp(String marriageGrp) {
        this.marriageGrp = marriageGrp;
    }

    public DepartureTimeZone getDepartureTimeZone() {
        return departureTimeZone;
    }

    public void setDepartureTimeZone(DepartureTimeZone departureTimeZone) {
        this.departureTimeZone = departureTimeZone;
    }

    public ArrivalTimeZone getArrivalTimeZone() {
        return arrivalTimeZone;
    }

    public void setArrivalTimeZone(ArrivalTimeZone arrivalTimeZone) {
        this.arrivalTimeZone = arrivalTimeZone;
    }

    public TPAExtensions getTPAExtensions() {
        return tPAExtensions;
    }

    public void setTPAExtensions(TPAExtensions tPAExtensions) {
        this.tPAExtensions = tPAExtensions;
    }

}
