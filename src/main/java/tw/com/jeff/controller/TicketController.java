package tw.com.jeff.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import tw.com.jeff.config.PaySuccessEmail;
import tw.com.jeff.ecpay.payment.integration.AllInOne;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutALL;
import tw.com.jeff.ecpay.payment.integration.domain.InvoiceObj;
import tw.com.jeff.ecpay.payment.integration.exception.EcpayException;
import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.FlightpriceBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.ticket.model.CabinBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.model.PassengerBean;
import tw.com.jeff.ticket.service.ticketservice;

@Controller
public class TicketController {
	@Autowired
	ticketservice ticketservice;
	@Autowired
	ServletContext context;
	//////////////////////////////////////3/26
	@Autowired
	sceneryService priceservice;
	/////////////////////////////////////////
	@RequestMapping("/showticketsearch")
	public String showticketsearch(Model model, @RequestParam("orgin") String orgin,
			@RequestParam("destination") String destination, @RequestParam("departdatepicker") String departdatepicker,
			@RequestParam("returndatepicker") String returndatepicker, @RequestParam("cabintype") String cabintype,
			@RequestParam("adult") Integer adult, @RequestParam("child") Integer child) {
		// 抓使用者提供參數
		HashMap<String, String> ticketsearch = new HashMap<>();

		String orgin1 = orgin.substring(0, 3);
		String destination1 = destination.substring(0, 3);
////////////////////////////////////////////////////////////3/26
		FlightpriceBean fpb = priceservice.selectFlightpriceByPlace(orgin, destination);
		Double addpercent = 1.0;
		int addprice =0;
		if(fpb != null) {
			addpercent = fpb.getAddpercent();
			addprice = fpb.getAddprice();
		}
		////////////////////////////////////////////////////
		ticketsearch.put("orgin", orgin1);
		ticketsearch.put("destination", destination1);
		ticketsearch.put("departdatepicker", departdatepicker);
		ticketsearch.put("returndatepicker", returndatepicker);
		ticketsearch.put("cabintype", cabintype);
		ticketsearch.put("adult", adult.toString());
		ticketsearch.put("child", child.toString());
		Integer totalSeats = adult + child;
		ticketsearch.put("totalSeats", totalSeats.toString());

		// 根據使用者資訊宣告產生查詢字串
		String requestBody = ticketservice.getRequestBody(ticketsearch);
		System.out.println("s");

		// 將查詢字串交給bfm以取得json格式回應資料
		JsonObject jsonbfmresponse = ticketservice.getBFM(requestBody);
		System.out.println("s");

		List<HashMap<String, String>> ticketsearchresults = null;
		if(jsonbfmresponse!=null) {	
		try {
			ticketsearchresults = ticketservice.getBFMJsonToMap(jsonbfmresponse);
			System.out.println("s");
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<CabinBean> cabins = ticketservice.getAllCabins();

		HashMap<String, HashMap<String, Object>> ticketresultsByAirline = ticketservice
				.getResultsByAirline(ticketsearchresults);

		model.addAttribute("ticketsearch", ticketsearch);
		model.addAttribute("ticketsearchresults", ticketsearchresults);
		model.addAttribute("cabins", cabins);
		model.addAttribute("ticketresultsByAirline", ticketresultsByAirline);
		//////////////////////////////////////////////
		model.addAttribute("addpercent",addpercent);
		model.addAttribute("addprice",addprice);
		///////////////////////////////////////////////3/26
		return "showticketsearch";
		}else {
			return "showticketsearchNull";
		}
	}

	@RequestMapping("/createOrder")
	public String creatOrder(Model model, HttpServletRequest request,
			@RequestParam("DepartureTimeGo") String DepartureTimeGo,
			@RequestParam("ArrivalTimeGo") String ArrivalTimeGo,
			@RequestParam("DepartureAirportLocationCodeGo") String DepartureAirportLocationCodeGo,
			@RequestParam("ArrivalAirportLocationCodeGo") String ArrivalAirportLocationCodeGo,
			@RequestParam("DepartureDateGo") String DepartureDateGo,
			@RequestParam("ArrivalDateGo") String ArrivalDateGo,
			@RequestParam("OperatingAirlineCodeGo") String OperatingAirlineCodeGo,
			@RequestParam("OperatingAirlineFlightNumberGo") String OperatingAirlineFlightNumberGo,
			@RequestParam("ElapsedTimeGo") String ElapsedTimeGo, @RequestParam("AirEquipTypeGo") String AirEquipTypeGo,
			@RequestParam("Cabin") Character Cabin, @RequestParam("DepartureTimeBack") String DepartureTimeBack,
			@RequestParam("ArrivalTimeBack") String ArrivalTimeBack,
			@RequestParam("DepartureAirportLocationCodeBack") String DepartureAirportLocationCodeBack,
			@RequestParam("ArrivalAirportLocationCodeBack") String ArrivalAirportLocationCodeBack,
			@RequestParam("DepartureDateBack") String DepartureDateBack,
			@RequestParam("ArrivalDateBack") String ArrivalDateBack,
			@RequestParam("OperatingAirlineCodeBack") String OperatingAirlineCodeBack,
			@RequestParam("OperatingAirlineFlightNumberBack") String OperatingAirlineFlightNumberBack,
			@RequestParam("AirEquipTypeBack") String AirEquipTypeBack,
			@RequestParam("ElapsedTimeBack") String ElapsedTimeBack, @RequestParam("FareAdult") String FareAdult,
			@RequestParam("QuantityAdult") Integer QuantityAdult, @RequestParam("FareChild") String FareChild,
			@RequestParam("QuantityChild") Integer QuantityChild, @RequestParam("TotalFare") String TotalFare,
			@RequestParam("EquivFareAdult") String EquivFareAdult, @RequestParam("TaxesAdult") String TaxesAdult,
			@RequestParam("EquivFareChild") String EquivFareChild, @RequestParam("TaxesChild") String TaxesChild,
			@RequestParam("BaggageAllowanceGo") String BaggageAllowanceGo,
			@RequestParam("BaggageAllowanceBack") String BaggageAllowanceBack) throws ParseException {
		FlightOrderBean newFlightOrder = new FlightOrderBean();
		newFlightOrder.setAdultCount(QuantityAdult);
		newFlightOrder.setAdultPrice(Integer.parseInt(FareAdult.replace(",", "")));
		newFlightOrder.setAdultEquipFare(Integer.parseInt(EquivFareAdult.replace(",", "")));
		newFlightOrder.setAdultTax(Integer.parseInt(TaxesAdult.replace(",", "")));
		MemberBean memberBean = (MemberBean)request.getSession().getAttribute("memberBean");
		newFlightOrder.setMemberId(memberBean.getId());
		if (!FareChild.equalsIgnoreCase("")) {
			newFlightOrder.setChildCount(QuantityChild);
			newFlightOrder.setChildPrice(Integer.parseInt(FareChild.replace(",", "")));
			newFlightOrder.setChildEquipFare(Integer.parseInt(EquivFareChild.replace(",", "")));
			newFlightOrder.setChildTax(Integer.parseInt(TaxesChild.replace(",", "")));
		} else {
			newFlightOrder.setChildCount(0);
			newFlightOrder.setChildPrice(0);
			newFlightOrder.setChildEquipFare(0);
			newFlightOrder.setChildTax(0);
		}
		newFlightOrder.setOrderDate(new java.util.Date());
		newFlightOrder.setOrderCode(ticketservice.getOrderCode());
		newFlightOrder.setCabin(Cabin);
		newFlightOrder.setOrderStatusID(0);

		if (TotalFare.length() == 5) {
			Integer orderTotalAmount = Integer.parseInt(TotalFare.substring(3).replace(",", ""));

			newFlightOrder.setOrderTotalAmount(orderTotalAmount);
		} else {
			Integer orderTotalAmount = Integer.parseInt(TotalFare.substring(2).replace(",", ""));
			newFlightOrder.setOrderTotalAmount(orderTotalAmount);
		}
		FlightOrderBean flightOrderBean = ticketservice.addFlightOrder(newFlightOrder);
		request.getSession().setAttribute("flightOrderBean", flightOrderBean);

		// 製作去程FlightOrderDetailBean，FK到了service再處理
		FlightOrderDetailBean newflightOrderDetailGo = new FlightOrderDetailBean();
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		newflightOrderDetailGo.setDepartureDate(dateFormat1.parse(DepartureDateGo.substring(0, 10)));
		DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
		newflightOrderDetailGo.setDepartureTime(dateFormat2.parse(DepartureTimeGo));
		newflightOrderDetailGo.setArrivalDate(dateFormat1.parse(ArrivalDateGo.substring(0, 10)));
		newflightOrderDetailGo.setArrivalTime(dateFormat2.parse(ArrivalTimeGo));
		newflightOrderDetailGo.setFlightNumber(OperatingAirlineFlightNumberGo);
		newflightOrderDetailGo.setTravelFlag(0);
		newflightOrderDetailGo.setFlightOrderID(flightOrderBean.getFlightOrderID());
		newflightOrderDetailGo.setAirlineid(OperatingAirlineCodeGo);
		newflightOrderDetailGo.setDeparturePlace(DepartureAirportLocationCodeGo);
		newflightOrderDetailGo.setArrivalPlace(ArrivalAirportLocationCodeGo);
		System.out.println("ArrivalAirportLocationCodeGo" + ArrivalAirportLocationCodeGo);
		newflightOrderDetailGo.setElapsedTime(ElapsedTimeGo);
		newflightOrderDetailGo.setEquipType(AirEquipTypeGo);
		FlightOrderDetailBean flightOrderDetailGo = ticketservice.addFlightOrderDetail(newflightOrderDetailGo);
		request.getSession().setAttribute("flightOrderDetailGo", flightOrderDetailGo);
		
		// 製作回程FlightOrderDetailBean，FK到了service再處理
		FlightOrderDetailBean newflightOrderDetailBack = new FlightOrderDetailBean();
		newflightOrderDetailBack.setDepartureDate(dateFormat1.parse(DepartureDateBack.substring(0, 10)));
		newflightOrderDetailBack.setDepartureTime(dateFormat2.parse(DepartureTimeBack));
		newflightOrderDetailBack.setArrivalDate(dateFormat1.parse(ArrivalDateBack.substring(0, 10)));
		newflightOrderDetailBack.setArrivalTime(dateFormat2.parse(ArrivalTimeBack));
		newflightOrderDetailBack.setFlightNumber(OperatingAirlineFlightNumberBack);
		newflightOrderDetailBack.setTravelFlag(1);
		newflightOrderDetailBack.setFlightOrderID(flightOrderBean.getFlightOrderID());
		newflightOrderDetailBack.setAirlineid(OperatingAirlineCodeBack);
		newflightOrderDetailBack.setDeparturePlace(DepartureAirportLocationCodeBack);
		newflightOrderDetailBack.setArrivalPlace(ArrivalAirportLocationCodeBack);
		newflightOrderDetailBack.setElapsedTime(ElapsedTimeBack);
		newflightOrderDetailBack.setEquipType(AirEquipTypeBack);
		FlightOrderDetailBean flightOrderDetailBack = ticketservice.addFlightOrderDetail(newflightOrderDetailBack);
		request.getSession().setAttribute("flightOrderDetailBack", flightOrderDetailBack);

		List<PassengerBean> passengers = ticketservice.addPassenger(flightOrderBean);
		request.getSession().setAttribute("passengers", passengers);
		
		
		request.getSession().setAttribute("BaggageAllowanceGo", BaggageAllowanceGo);
		
		request.getSession().setAttribute("BaggageAllowanceBack", BaggageAllowanceBack);

		return "passengerInfo";

	}
	@RequestMapping("/updatePassenger")
	public String updatePassenger(Model model, HttpServletRequest request) {
		FlightOrderBean flightOrderBean = (FlightOrderBean) request.getSession().getAttribute("flightOrderBean");

		// 更新FlightOrderBean的聯絡人相關欄位
		flightOrderBean.setContactorEmail(request.getParameter("contactorEmail"));
		flightOrderBean.setContactorFirstName(request.getParameter("chContactorFirstName"));
		flightOrderBean.setContactorLastName(request.getParameter("chContactorLastName"));
		flightOrderBean.setContactorTel(request.getParameter("contactorTel"));
		flightOrderBean = ticketservice.updateFlightOrderContactor(flightOrderBean);

		// 更新PassengerBean相關欄位
		@SuppressWarnings("unchecked")
		List<PassengerBean> passengers = (List<PassengerBean>) request.getSession().getAttribute("passengers");
		
		for (PassengerBean passenger : passengers) {
			Integer passengerID = passenger.getPassengerID();
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				passenger.setBornDate(dateFormat1.parse(request.getParameter("bornDate" + passengerID)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			passenger.setChFirstName(request.getParameter("chFirstName" + passengerID));
			passenger.setChLastName(request.getParameter("chLastName" + passengerID));
			passenger.setFirstName(request.getParameter("firstName" + passengerID));
			passenger.setLastName(request.getParameter("lastName" + passengerID));
			passenger.setGender(request.getParameter("gender" + passengerID).charAt(0));
			ticketservice.updatePassengerInfo(passenger);
			System.out.println(passenger);
		}

		System.out.println(flightOrderBean);
		
		
		return "forward:/aioCheckOutALL";
		
		
		}
	AllInOne all;
	
//	@RequestMapping(value = "/aioCheckOut/aioCheckOutALL", method = RequestMethod.GET)
//	public ModelAndView aioCheckOutALL(){
//		return new ModelAndView("views/aioCheckOutALL", "command", new AioCheckOutALL());
//	}
	
	@RequestMapping(value = "aioCheckOutALL", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutALL(AioCheckOutALL aio, HttpServletRequest request){
		
//		Integer flightOrderID = Integer.parseInt(request.getParameter("flightOrderID"));
		FlightOrderBean flightOrderBean=(FlightOrderBean) request.getSession().getAttribute("flightOrderBean");
		
		System.out.println("flightOrderBean:"+flightOrderBean);
//		FlightOrderBean flightOrderBean = ticketservice.getFlightOrderById(flightOrderID);
		
//		Integer flightOrderDetailID=Integer.parseInt(request.getParameter("flightOrderDetailID"));
//		FlightOrderDetailBean flightOrderDetailBean = ticketservice.getFlightOrderDetailById(flightOrderDetailID);
		
		FlightOrderDetailBean flightOrderDetailBean =(FlightOrderDetailBean) request.getSession().getAttribute("flightOrderDetailGo");
		System.out.println("flightOrderDetailBean:"+flightOrderDetailBean);
		String departurePlace=flightOrderDetailBean.getDeparturePlace();
		String arrivalPlace=flightOrderDetailBean.getArrivalPlace();
		String orderTotalAmount=flightOrderBean.getOrderTotalAmount().toString();
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
//		aio.setItemName("機票");
		aio.setItemName(departurePlace+"-"+arrivalPlace+"來回機票");
		aio.setTotalAmount(orderTotalAmount);
		aio.setTradeDesc("123456789");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		//付款成功後導回網頁
		aio.setOrderResultURL("http://localhost:8080/FinalProject/PayResult"
				+ "");
		
//		aio.setOrderResultURL("https://www.youtube.com/watch?v=9suDKut9x7I&index=2&list=RD9suDKut9x7I");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
	
	}
	@RequestMapping(value = "/PayResult")
	public String showPayResult(Model model, HttpServletRequest request) {
		FlightOrderBean flightOrderBean = (FlightOrderBean) request.getSession().getAttribute("flightOrderBean");
		Integer flightOrderID=flightOrderBean.getFlightOrderID();
//		flightOrderBean = ticketservice.getFlightOrderById(flightOrderBean.getFlightOrderID());
		// 更新付款狀態
	List<PassengerBean> Passengers=ticketservice.getPassengerByFlightOrderID(flightOrderID);
		flightOrderBean.setOrderStatusID(1);
//		OrderStatusBean orderStatusBean = ticketservice.getOrderStatusById(1);
//		flightOrderBean.setOrderStatusBean(orderStatusBean);
		flightOrderBean = ticketservice.updateFlightOrderStatus(flightOrderBean);
		request.getSession().setAttribute("Passengers", Passengers);
	 String	contactor=flightOrderBean.getContactorEmail();
	 System.out.println("contactor="+contactor);
	 PaySuccessEmail SendEmail = new PaySuccessEmail();
	 SendEmail.PaySendemail(contactor);
	 System.out.println("Email Success!");
		
		// 寄出信件
//		ticketservice.mailToContactor(PDFfilename, JPGfilename, flightOrderBean.getFlightOrderID());

//		request.getSession().removeAttribute("flightOrderBean");
//		request.getSession().removeAttribute("flightOrderDetailGo");
//		request.getSession().removeAttribute("flightOrderDetailBack");
//		request.getSession().removeAttribute("passengers");

		model.addAttribute("flightOrderBean", flightOrderBean);
		return "PayResultDetail";
	}

}
