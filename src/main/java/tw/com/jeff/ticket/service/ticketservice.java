package tw.com.jeff.ticket.service;

import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonObject;

import tw.com.jeff.ticket.model.CabinBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.model.OrderStatusBean;
import tw.com.jeff.ticket.model.PassengerBean;


public interface ticketservice {

	String getRequestBody(HashMap<String, String> ticketsearch);

	JsonObject getBFM(String requestBody);

	List<HashMap<String, String>> getBFMJsonToMap(JsonObject jsonbfm);

	List<CabinBean> getAllCabins();

	HashMap<String, HashMap<String, Object>> getResultsByAirline(List<HashMap<String, String>> ticketsearchresults);

	String getOrderCode();

	FlightOrderBean addFlightOrder(FlightOrderBean newFlightOrder);

	FlightOrderDetailBean addFlightOrderDetail(FlightOrderDetailBean newFlightOrderDetail);

	List<PassengerBean> addPassenger(FlightOrderBean flightOrderBean);

	FlightOrderBean updateFlightOrderContactor(FlightOrderBean flightOrderBean);

	void updatePassengerInfo(PassengerBean passenger);

	FlightOrderBean getFlightOrderById(Integer flightOrderID);

	FlightOrderDetailBean getFlightOrderDetailById(Integer flightOrderDetailID);

	OrderStatusBean getOrderStatusById(Integer orderStatusID);

	FlightOrderBean updateFlightOrderStatus(FlightOrderBean flightOrderBean);

	List<PassengerBean> getPassengerByFlightOrderID(Integer flightOrderID);

	List<FlightOrderDetailBean> getFlightOrderDetailsByMemberID(Integer memberID);
	
	List<FlightOrderBean> getAllorder();
	

}