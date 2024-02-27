package tw.com.jeff.ticket.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.ticket.dao.ticketdao;
import tw.com.jeff.ticket.model.AirlineBean;
import tw.com.jeff.ticket.model.AirportBean;
import tw.com.jeff.ticket.model.CabinBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.model.OrderStatusBean;
import tw.com.jeff.ticket.model.PassengerBean;

@Repository
public class ticketdaoImpl implements ticketdao {

	@Autowired
	SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AirportBean> getAllCities() {
		String hql = "from AirportBean";
		List<AirportBean> list = new ArrayList<>();
//		Session session = sessionfactory.openSession();
		Session session = sessionfactory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
//		session.close();
		return list;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<AirlineBean> getAllAirlines() {
		String hql = "from AirlineBean";
		List<AirlineBean> list = new ArrayList<>();
//		Session session = sessionfactory.openSession();
		Session session = sessionfactory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
//		session.close();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CabinBean> getAllCabins() {
		String hql = "from CabinBean";
		List<CabinBean> list = new ArrayList<>();
//		Session session = sessionfactory.openSession();
		Session session = sessionfactory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
//		session.close();
		return list;		
	}
	@Override
	public Integer addFlightOrder(FlightOrderBean newFlightOrder) {
		Session session=sessionfactory.getCurrentSession();
		
		return (Integer) session.save(newFlightOrder);
	}
	@Override
	public FlightOrderBean getFlightOrderByID(Integer flightOrderID) {
		Session session = sessionfactory.getCurrentSession();
		FlightOrderBean flightOrderBean = session.get(FlightOrderBean.class, flightOrderID);
		
		return flightOrderBean;
	}
	@Override
	public Integer addFlightOrderDetail(FlightOrderDetailBean newFlightOrderDetail) {
		Session session = sessionfactory.getCurrentSession();
		return (Integer) session.save(newFlightOrderDetail);
	}
	@Override
	public FlightOrderDetailBean getFlightOrderDetailByID(Integer flightOrderDetailID) {
		Session session = sessionfactory.getCurrentSession();
		FlightOrderDetailBean flightOrderDetailBean = session.get(FlightOrderDetailBean.class, flightOrderDetailID);
		return flightOrderDetailBean;
	}
	@Override
	public Integer addPassenger(PassengerBean newPassenger) {
		Session session = sessionfactory.getCurrentSession();
		return (Integer) session.save(newPassenger);
	}
	@Override	
	public List<PassengerBean> getPassengerByFlightOrderID(Integer flightOrderID) {
		String hql = "FROM PassengerBean WHERE flightOrderID = :flightOrderID";
		Session session = sessionfactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<PassengerBean> list =session.createQuery(hql).setParameter("flightOrderID", flightOrderID).getResultList();
		return list;
	}
	@Override
	public AirlineBean getAirLineByID(String airLineid) {
		Session session = sessionfactory.getCurrentSession();
		AirlineBean airlineBean = session.get(AirlineBean.class, airLineid);
		
		return airlineBean;
	}
	@Override
	public AirportBean getCityByID(String citiid) {
		Session session = sessionfactory.getCurrentSession();
		AirportBean airportBean = session.get(AirportBean.class, citiid);
		
		return airportBean;
	}
	@Override
	public void updateFlightOrderContactor(FlightOrderBean flightOrderBean) {
		String hql = "UPDATE FlightOrderBean SET contactorEmail = :contactorEmail"
				+ ", contactorFirstName = :contactorFirstName" + ", contactorLastName = :contactorLastName"
				+ ", contactorTel = :contactorTel " + "WHERE flightOrderID = :flightOrderID";
		Session session = sessionfactory.getCurrentSession();
		session.createQuery(hql).setParameter("contactorEmail", flightOrderBean.getContactorEmail())
				.setParameter("contactorFirstName", flightOrderBean.getContactorFirstName())
				.setParameter("contactorLastName", flightOrderBean.getContactorLastName())
				.setParameter("contactorTel", flightOrderBean.getContactorTel())
				.setParameter("flightOrderID", flightOrderBean.getFlightOrderID()).executeUpdate();
		
	}
	@Override
	public void updatePassengerInfo(PassengerBean passenger) {
		String hql = "UPDATE PassengerBean SET bornDate = :bornDate" + ", chFirstName = :chFirstName"
				+ ", chLastName = :chLastName" + ", firstName = :firstName " + ", lastName = :lastName "
				+ ", gender = :gender " + "WHERE passengerID = :passengerID";
		Session session = sessionfactory.getCurrentSession();
		session.createQuery(hql).setParameter("bornDate", passenger.getBornDate())
				.setParameter("chFirstName", passenger.getChFirstName())
				.setParameter("chLastName", passenger.getChLastName())
				.setParameter("firstName", passenger.getFirstName()).setParameter("lastName", passenger.getLastName())
				.setParameter("gender", passenger.getGender()).setParameter("passengerID", passenger.getPassengerID())
				.executeUpdate();
	}
	@Override
	public void updateFlightOrderStatus(FlightOrderBean flightOrderBean) {
		Session session = sessionfactory.getCurrentSession();
		session.update(flightOrderBean);	
	}
	@Override
	public OrderStatusBean getOrderStatusByID(Integer orderStatusID) {
		Session session = sessionfactory.getCurrentSession();
		OrderStatusBean orderStatusBean = session.get(OrderStatusBean.class, orderStatusID);
		return orderStatusBean;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightOrderDetailBean> getFlightOrderDetailsByMemberID(Integer memberId) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "FROM FlightOrderDetailBean WHERE flightOrderBean.memberId=:memberId";
		List<FlightOrderDetailBean> list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FlightOrderBean> getAllorder() {
		Session session = sessionfactory.getCurrentSession();
		String hql="From FlightOrderBean" ;
		List<FlightOrderBean> list = session.createQuery(hql).getResultList();
		return list;
	}
	
	
	
	

	


}
