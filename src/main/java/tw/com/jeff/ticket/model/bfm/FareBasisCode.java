
package tw.com.jeff.ticket.model.bfm;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FareBasisCode implements Serializable
{

    @SerializedName("PrivateFareType")
    @Expose
    private String privateFareType;
    @SerializedName("BookingCode")
    @Expose
    private String bookingCode;
    @SerializedName("AvailabilityBreak")
    @Expose
    private Boolean availabilityBreak;
    @SerializedName("DepartureAirportCode")
    @Expose
    private String departureAirportCode;
    @SerializedName("ArrivalAirportCode")
    @Expose
    private String arrivalAirportCode;
    @SerializedName("FareComponentBeginAirport")
    @Expose
    private String fareComponentBeginAirport;
    @SerializedName("FareComponentEndAirport")
    @Expose
    private String fareComponentEndAirport;
    @SerializedName("FareComponentDirectionality")
    @Expose
    private String fareComponentDirectionality;
    @SerializedName("FareComponentVendorCode")
    @Expose
    private String fareComponentVendorCode;
    @SerializedName("GovCarrier")
    @Expose
    private String govCarrier;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = -4087827909255656561L;

    public String getPrivateFareType() {
        return privateFareType;
    }

    public void setPrivateFareType(String privateFareType) {
        this.privateFareType = privateFareType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Boolean getAvailabilityBreak() {
        return availabilityBreak;
    }

    public void setAvailabilityBreak(Boolean availabilityBreak) {
        this.availabilityBreak = availabilityBreak;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getFareComponentBeginAirport() {
        return fareComponentBeginAirport;
    }

    public void setFareComponentBeginAirport(String fareComponentBeginAirport) {
        this.fareComponentBeginAirport = fareComponentBeginAirport;
    }

    public String getFareComponentEndAirport() {
        return fareComponentEndAirport;
    }

    public void setFareComponentEndAirport(String fareComponentEndAirport) {
        this.fareComponentEndAirport = fareComponentEndAirport;
    }

    public String getFareComponentDirectionality() {
        return fareComponentDirectionality;
    }

    public void setFareComponentDirectionality(String fareComponentDirectionality) {
        this.fareComponentDirectionality = fareComponentDirectionality;
    }

    public String getFareComponentVendorCode() {
        return fareComponentVendorCode;
    }

    public void setFareComponentVendorCode(String fareComponentVendorCode) {
        this.fareComponentVendorCode = fareComponentVendorCode;
    }

    public String getGovCarrier() {
        return govCarrier;
    }

    public void setGovCarrier(String govCarrier) {
        this.govCarrier = govCarrier;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
