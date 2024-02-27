package tw.com.jeff.ticket.dao;

import java.util.List;

import tw.com.jeff.ticket.model.AirlineBean;
import tw.com.jeff.ticket.model.AirportBean;
import tw.com.jeff.ticket.model.CabinBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.model.OrderStatusBean;
import tw.com.jeff.ticket.model.PassengerBean;

public interface ticketdao {

	

	List<AirportBean> getAllCities();

	List<AirlineBean> getAllAirlines();

	List<CabinBean> getAllCabins();
	
	Integer addFlightOrder(FlightOrderBean newFlightOrder);

	FlightOrderBean getFlightOrderByID(Integer flightOrderID);

	Integer addFlightOrderDetail(FlightOrderDetailBean newFlightOrderDetail);

	FlightOrderDetailBean getFlightOrderDetailByID(Integer flightOrderDetailID);

	List<FlightOrderDetailBean> getFlightOrderDetailsByMemberID(Integer memberID);
	
	Integer addPassenger(PassengerBean newPassenger);

	List<PassengerBean> getPassengerByFlightOrderID(Integer flightOrderID);

	AirlineBean getAirLineByID(String airLineID);

	AirportBean getCityByID(String departurePlace);

	void updateFlightOrderContactor(FlightOrderBean flightOrderBean);

	void updatePassengerInfo(PassengerBean passenger);

	void updateFlightOrderStatus(FlightOrderBean flightOrderBean);

	OrderStatusBean getOrderStatusByID(Integer orderStatusID);
	
	List<FlightOrderBean> getAllorder();

}