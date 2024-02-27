package tw.com.jeff.ticket.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.com.jeff.ticket.dao.ticketdao;
import tw.com.jeff.ticket.model.AirlineBean;
import tw.com.jeff.ticket.model.AirportBean;
import tw.com.jeff.ticket.model.CabinBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.model.OrderStatusBean;
import tw.com.jeff.ticket.model.PassengerBean;
import tw.com.jeff.ticket.model.Token;
import tw.com.jeff.ticket.model.bfm.AirItinerary;
import tw.com.jeff.ticket.model.bfm.AirItineraryPricingInfo;
import tw.com.jeff.ticket.model.bfm.BaggageInformation;
import tw.com.jeff.ticket.model.bfm.FlightSegment;
import tw.com.jeff.ticket.model.bfm.ItinTotalFare;
import tw.com.jeff.ticket.model.bfm.OTAAirLowFareSearchRS;
import tw.com.jeff.ticket.model.bfm.OriginDestinationOption;
import tw.com.jeff.ticket.model.bfm.OriginDestinationOptions;
import tw.com.jeff.ticket.model.bfm.PTCFareBreakdown;
import tw.com.jeff.ticket.model.bfm.PTCFareBreakdowns;
import tw.com.jeff.ticket.model.bfm.PassengerFare;
import tw.com.jeff.ticket.model.bfm.PricedItineraries;
import tw.com.jeff.ticket.model.bfm.PricedItinerary;
import tw.com.jeff.ticket.service.ticketservice;

@Service
@Transactional
public class ticketserviceImpl implements ticketservice {
	@Autowired
	private ticketdao ticketdao;

	private static Token token;

	@Override
	public String getRequestBody(HashMap<String, String> ticketsearch) {
		StringBuffer bfmsearch = new StringBuffer();
		bfmsearch.append(
				"{\"OTA_AirLowFareSearchRQ\":{\"ResponseType\":\"OTA\",\"ResponseVersion\":\"3.4.0\",\"Target\":\"Production\",\"Version\":\"3.4.0\",\"POS\":{\"Source\":[{\"PseudoCityCode\":\"A2U8\",\"RequestorID\":{\"Type\":\"1\",\"ID\":\"1\",\"CompanyName\":{\"Code\":\"TN\"}}}]},\"OriginDestinationInformation\":[{\"RPH\":\"1\",\"DepartureDateTime\":\""
						+ ticketsearch.get("departdatepicker") + "T00:00:00\",\"OriginLocation\":{\"LocationCode\":\""
						+ ticketsearch.get("orgin") + "\"},\"DestinationLocation\":{\"LocationCode\":\""
						+ ticketsearch.get("destination")
						+ "\"},\"TPA_Extensions\":{\"SegmentType\":{\"Code\":\"O\"}}},{\"RPH\":\"2\",\"DepartureDateTime\":\""
						+ ticketsearch.get("returndatepicker") + "T00:00:00\",\"OriginLocation\":{\"LocationCode\":\""
						+ ticketsearch.get("destination") + "\"},\"DestinationLocation\":{\"LocationCode\":\""
						+ ticketsearch.get("orgin")
						+ "\"},\"TPA_Extensions\":{\"SegmentType\":{\"Code\":\"O\"}}}],\"TravelPreferences\":{\"ValidInterlineTicket\":true,\"FlightTypePref\":{\"MaxConnections\":\"0\"},\"CabinPref\":[{\"Cabin\":\""
						+ ticketsearch.get("cabintype")
						+ "\",\"PreferLevel\":\"Preferred\"}],\"TPA_Extensions\":{\"ExcludeVendorPref\":[{\"Code\":\"3K\"},{\"Code\":\"5J\"},{\"Code\":\"6E\"},{\"Code\":\"7C\"},{\"Code\":\"8L\"},{\"Code\":\"9C\"},{\"Code\":\"9W\"},{\"Code\":\"AB\"},{\"Code\":\"AK\"},{\"Code\":\"BL\"},{\"Code\":\"BT\"},{\"Code\":\"BX\"},{\"Code\":\"D7\"},{\"Code\":\"DD\"},{\"Code\":\"DG\"},{\"Code\":\"F9\"},{\"Code\":\"FD\"},{\"Code\":\"FY\"},{\"Code\":\"GK\"},{\"Code\":\"GS\"},{\"Code\":\"HO\"},{\"Code\":\"I5\"},{\"Code\":\"IT\"},{\"Code\":\"JQ\"},{\"Code\":\"JW\"},{\"Code\":\"LJ\"},{\"Code\":\"MJ\"},{\"Code\":\"MM\"},{\"Code\":\"NK\"},{\"Code\":\"QZ\"},{\"Code\":\"TR\"},{\"Code\":\"TW\"},{\"Code\":\"UO\"},{\"Code\":\"VA\"},{\"Code\":\"VJ\"},{\"Code\":\"XJ\"},{\"Code\":\"XT\"},{\"Code\":\"XW\"},{\"Code\":\"Z2\"},{\"Code\":\"ZE\"}],\"TripType\":{\"Value\":\"Return\"},\"LongConnectTime\":{\"Min\":780,\"Max\":1200,\"Enable\":true},\"ExcludeCallDirectCarriers\":{\"Enabled\":true}}},\"TravelerInfoSummary\":{\"SeatsRequested\":["
						+ ticketsearch.get("totalSeats")
						+ "],\"AirTravelerAvail\":[{\"PassengerTypeQuantity\":[{\"Code\":\"ADT\",\"Quantity\":"
						+ ticketsearch.get("adult") + "}"
						+ ((ticketsearch.get("child").equalsIgnoreCase("0")) ? ""
								: ",{\"Code\":\"CNN\",\"Quantity\":" + ticketsearch.get("child") + "}")
						+ "]}]},\"TPA_Extensions\":{\"IntelliSellTransaction\":{\"RequestType\":{\"Name\":\"50ITINS\"}}}}}");
		return bfmsearch.toString();

	}

	@Override
	public JsonObject getBFM(String requestBody) {
		String ClientID = "V1:987632:A2U8:AA";// "V1:d6ztddyuw791ocj6:DEVCENTER:EXT";
		String Password = "SDY2KUL";// "rDd0nE8G";

		JsonObject jsonObject = null;
		try {
			String Base_ClientID = Base64.getEncoder().encodeToString(ClientID.getBytes("utf-8"));
			String Base_Password = Base64.getEncoder().encodeToString(Password.getBytes("utf-8"));
			String Base_Compose = Base64.getEncoder()
					.encodeToString((Base_ClientID + ":" + Base_Password).getBytes("utf-8"));

			URL url1 = new URL("https://api.sabre.com/v2/auth/token");
			StringBuffer tokenresponse = new StringBuffer();

			HttpURLConnection hreq1 = (HttpURLConnection) url1.openConnection();
			hreq1.setRequestMethod("POST");
			hreq1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			hreq1.setRequestProperty("Authorization", "Basic " + Base_Compose);
			hreq1.setDoOutput(true);

			OutputStream os = hreq1.getOutputStream();
			os.write("grant_type=client_credentials".getBytes("utf-8"));
			os.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(hreq1.getInputStream()));
			String inputLine1;

			while ((inputLine1 = in.readLine()) != null) {
				tokenresponse.append(inputLine1);
			}
			in.close();

			Gson gson = new Gson();
			token = gson.fromJson(tokenresponse.toString(), Token.class);

			URL url2 = new URL("https://api.sabre.com/v4.3.0/shop/flights?mode=live");
			HttpURLConnection hreq2 = (HttpURLConnection) url2.openConnection();
			hreq2.setRequestMethod("POST");
			hreq2.setRequestProperty("Content-Type", "application/json");
			hreq2.setRequestProperty("Accept-Encoding", "gzip");
			hreq2.setRequestProperty("Authorization", "Bearer " + token.getAccessToken());
			hreq2.setDoOutput(true);

			OutputStream os2 = hreq2.getOutputStream();
			os2.write(requestBody.getBytes("utf-8"));
			os2.close();

			GZIPInputStream zipBFMinformation = null;
			zipBFMinformation = new GZIPInputStream(hreq2.getInputStream());
			InputStreamReader resBFM = new InputStreamReader(zipBFMinformation, "UTF-8");

			JsonParser jsonParser = new JsonParser();
			jsonObject = (JsonObject) jsonParser.parse(resBFM);
			resBFM.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public List<HashMap<String, String>> getBFMJsonToMap(JsonObject jsonbfm) {
		List<HashMap<String, String>> ticketsearchresults = new ArrayList<HashMap<String, String>>();

		List<AirportBean> allcities = ticketdao.getAllCities();
		List<AirlineBean> airlines = ticketdao.getAllAirlines();
		List<CabinBean> cabins = ticketdao.getAllCabins();

		Gson gson = new Gson();
		OTAAirLowFareSearchRS oTAAirLowFareSearchRS = gson.fromJson(jsonbfm.get("OTA_AirLowFareSearchRS"),
				OTAAirLowFareSearchRS.class);
		PricedItineraries pricedItineraries = oTAAirLowFareSearchRS.getPricedItineraries();
		List<PricedItinerary> pricedItineraryList = pricedItineraries.getPricedItinerary();

		for (int i = 0; i < pricedItineraryList.size(); i++) {
			PricedItinerary pricedItinerary = pricedItineraryList.get(i);

			HashMap<String, String> ticketsearchresult = new HashMap<>();

			AirItinerary airItinerary = pricedItinerary.getAirItinerary();
			OriginDestinationOptions originDestinationOptions = airItinerary.getOriginDestinationOptions();
			List<OriginDestinationOption> originDestinationOptionList = originDestinationOptions
					.getOriginDestinationOption();

			// 去程資料
			OriginDestinationOption originDestinationOptionGo = originDestinationOptionList.get(0);
			// 去程總飛行時間 ElapsedTimeGo
			Integer ElapsedTimeGoHour = (originDestinationOptionGo.getElapsedTime() / 60);
			String ElapsedTimeGoHour1 = ElapsedTimeGoHour.toString();
			Integer ElapsedTimeGoMin = (originDestinationOptionGo.getElapsedTime() % 60);
			String ElapsedTimeGoMin1 = ElapsedTimeGoMin.toString();
			String ElapsedTimeGo = ElapsedTimeGoHour1 + "時" + ElapsedTimeGoMin1 + "分";
			ticketsearchresult.put("ElapsedTimeGo", ElapsedTimeGo);

			List<FlightSegment> flightSegmentListGo = originDestinationOptionGo.getFlightSegment();

			FlightSegment flightSegmentGo = flightSegmentListGo.get(0);
			// 去程出發日期時間
			String DepartureDateTimeGo = flightSegmentGo.getDepartureDateTime();
			// 去程出發日期
			String DepartureDateGo = DepartureDateTimeGo.substring(0, 10);
			ticketsearchresult.put("DepartureDateGo", DepartureDateGo);
			// 去程出發時間
			String DepartureTimeGo = DepartureDateTimeGo.substring(11, 16);
			ticketsearchresult.put("DepartureTimeGo", DepartureTimeGo);
			// 去程起飛機場
			String DepartureAirportLocationCodeGo = flightSegmentGo.getDepartureAirport().getLocationCode();
			String DepartureAirportLocationNameGo = DepartureAirportLocationCodeGo;
			for (AirportBean cb : allcities) {
				if (cb.getCityid().equalsIgnoreCase(DepartureAirportLocationCodeGo)) {
					DepartureAirportLocationNameGo = cb.getCityname();
				}
			}
			ticketsearchresult.put("DepartureAirportLocationCodeGo", DepartureAirportLocationCodeGo);
			ticketsearchresult.put("DepartureAirportLocationNameGo", DepartureAirportLocationNameGo);
			// 去程起飛航廈
			String DepartureTerminalIDGo = flightSegmentGo.getDepartureAirport().getTerminalID();
			ticketsearchresult.put("DepartureTerminalIDGo", DepartureTerminalIDGo);
			// 去程航空公司
			String OperatingAirlineCodeGo = flightSegmentGo.getOperatingAirline().getCode();
			String OperatingAirlineNameGo = OperatingAirlineCodeGo;
			for (AirlineBean alb : airlines) {
				if (alb.getAirlineid().equalsIgnoreCase(OperatingAirlineCodeGo)) {
					OperatingAirlineNameGo = alb.getAirlinename();
				}
			}
			ticketsearchresult.put("OperatingAirlineCodeGo", OperatingAirlineCodeGo);
			ticketsearchresult.put("OperatingAirlineNameGo", OperatingAirlineNameGo);

			// 去程抵達日期時間
			String ArrivalDateTimeGo = flightSegmentGo.getArrivalDateTime();
			// 去程抵達日期
			String ArrivalDateGo = ArrivalDateTimeGo.substring(0, 10);
			ticketsearchresult.put("ArrivalDateGo", ArrivalDateGo);
			// 去程抵達時間
			String ArrivalTimeGo = ArrivalDateTimeGo.substring(11, 16);
			ticketsearchresult.put("ArrivalTimeGo", ArrivalTimeGo);
			// 去程降落機場
			String ArrivalAirportLocationCodeGo = flightSegmentGo.getArrivalAirport().getLocationCode();
			String ArrivalAirportLocationNameGo = ArrivalAirportLocationCodeGo;
			for (AirportBean apb : allcities) {
				if (apb.getCityid().equalsIgnoreCase(ArrivalAirportLocationCodeGo)) {
					ArrivalAirportLocationNameGo = apb.getCityname();
				}
			}
			ticketsearchresult.put("ArrivalAirportLocationCodeGo", ArrivalAirportLocationCodeGo);
			ticketsearchresult.put("ArrivalAirportLocationNameGo", ArrivalAirportLocationNameGo);
			// 去程降落航廈
			String TerminalIGo = flightSegmentGo.getArrivalAirport().getTerminalID();
			ticketsearchresult.put("TerminalIGo", TerminalIGo);
			// 去程班機編號
			String OperatingAirlineFlightNumberGo = flightSegmentGo.getOperatingAirline().getFlightNumber();
			ticketsearchresult.put("OperatingAirlineFlightNumberGo", OperatingAirlineFlightNumberGo);
			// 去程班機型號
			String AirEquipTypeGo = flightSegmentGo.getEquipment().get(0).getAirEquipType();
			ticketsearchresult.put("AirEquipTypeGo", AirEquipTypeGo);

			// 回程資料
			OriginDestinationOption originDestinationOptionBack = originDestinationOptionList.get(1);

			// 回程總飛行時間 elapsedTimeBack
			Integer ElapsedTimeBackHour = (originDestinationOptionBack.getElapsedTime() / 60);
			String ElapsedTimeBackHour1 = ElapsedTimeBackHour.toString();
			Integer ElapsedTimeBackMin = (originDestinationOptionBack.getElapsedTime() % 60);
			String ElapsedTimeBackMin1 = ElapsedTimeBackMin.toString();
			String ElapsedTimeBack = ElapsedTimeBackHour1 + "時" + ElapsedTimeBackMin1 + "分";
			ticketsearchresult.put("ElapsedTimeBack", ElapsedTimeBack);

			List<FlightSegment> flightSegmentListBack = originDestinationOptionBack.getFlightSegment();
			FlightSegment flightSegmentBack = flightSegmentListBack.get(0);

			// 回程起飛時間日期
			String DepartureDateTimeBack = flightSegmentBack.getDepartureDateTime();
			// 回程起飛日期
			String DepartureDateBack = DepartureDateTimeBack.substring(0, 10);
			ticketsearchresult.put("DepartureDateBack", DepartureDateBack);
			// 回程起飛時間
			String DepartureTimeBack = DepartureDateTimeBack.substring(11, 16);
			ticketsearchresult.put("DepartureTimeBack", DepartureTimeBack);
			// 回程起飛機場(要從資料庫抓機場名稱)
			String DepartureAirportLocationCodeBack = flightSegmentBack.getDepartureAirport().getLocationCode();
			String DepartureAirportLocationNameBack = DepartureAirportLocationCodeBack;
			for (AirportBean cb : allcities) {
				if (cb.getCityid().equalsIgnoreCase(DepartureAirportLocationCodeBack)) {
					DepartureAirportLocationNameBack = cb.getCityname();
				}
			}
			ticketsearchresult.put("DepartureAirportLocationCodeBack", DepartureAirportLocationCodeBack);
			ticketsearchresult.put("DepartureAirportLocationNameBack", DepartureAirportLocationNameBack);
			// 回程起飛航廈
			String DepartureTerminalIDBack = flightSegmentBack.getArrivalAirport().getTerminalID();
			ticketsearchresult.put("DepartureTerminalIDBack", DepartureTerminalIDBack);
			// 回程降落時間日期
			String ArrivalDateTimeBack = flightSegmentBack.getArrivalDateTime();
			// 回程降落日期
			String ArrivalDateBack = ArrivalDateTimeBack.substring(0, 10);
			ticketsearchresult.put("ArrivalDateBack", ArrivalDateBack);
			// 回程降落時間
			String ArrivalTimeBack = ArrivalDateTimeBack.substring(11, 16);
			ticketsearchresult.put("ArrivalTimeBack", ArrivalTimeBack);

			// 回程降落機場
			String ArrivalAirportLocationCodeBack = flightSegmentBack.getArrivalAirport().getLocationCode();
			String ArrivalAirportLocationNameBack = ArrivalAirportLocationCodeBack;
			for (AirportBean cb : allcities) {
				if (cb.getCityid().equalsIgnoreCase(ArrivalAirportLocationCodeBack)) {
					ArrivalAirportLocationNameBack = cb.getCityname();
				}
			}
			ticketsearchresult.put("ArrivalAirportLocationCodeBack", ArrivalAirportLocationCodeBack);
			ticketsearchresult.put("ArrivalAirportLocationNameBack", ArrivalAirportLocationNameBack);
			// 回程降落航廈
			String ArrivalTerminalIDBack = flightSegmentBack.getArrivalAirport().getTerminalID();
			ticketsearchresult.put("ArrivalTerminalIDBack", ArrivalTerminalIDBack);
			// 回程航空公司
			String OperatingAirlineCodeBack = flightSegmentBack.getOperatingAirline().getCode();
			String OperatingAirlineNameBack = OperatingAirlineCodeBack;
			for (AirlineBean alb : airlines) {
				if (alb.getAirlineid().equalsIgnoreCase(OperatingAirlineCodeBack)) {
					OperatingAirlineNameBack = alb.getAirlinename();
				}
			}
			ticketsearchresult.put("OperatingAirlineCodeBack", OperatingAirlineCodeBack);
			ticketsearchresult.put("OperatingAirlineNameBack", OperatingAirlineNameBack);
			// 回程班機號碼
			String OperatingAirlineFlightNumberBack = flightSegmentBack.getOperatingAirline().getFlightNumber();
			ticketsearchresult.put("OperatingAirlineFlightNumberBack", OperatingAirlineFlightNumberBack);
			// 回程型號班機
			String AirEquipTypeBack = flightSegmentBack.getEquipment().get(0).getAirEquipType();
			ticketsearchresult.put("AirEquipTypeBack", AirEquipTypeBack);

//			---------------------------------------------------------------

			DecimalFormat decimalFormat = new DecimalFormat("#,###");

			List<AirItineraryPricingInfo> airItineraryPricingInfoList = pricedItinerary.getAirItineraryPricingInfo();
			AirItineraryPricingInfo airItineraryPricingInfo = airItineraryPricingInfoList.get(0);

			// 開票期限
			String LastTicketDate = airItineraryPricingInfo.getLastTicketDate();
			ticketsearchresult.put("LastTicketDate", LastTicketDate);

			ItinTotalFare itinTotalFare = airItineraryPricingInfo.getItinTotalFare();
			// 機票總金額
			Integer TotalEquivFare1 = itinTotalFare.getEquivFare().getAmount();
			String TotalEquivFare = decimalFormat.format((double) TotalEquivFare1);
			ticketsearchresult.put("TotalEquivFare", TotalEquivFare);
			// 機票總金額幣別
			String TotalEquivFareCurrencyCode = itinTotalFare.getEquivFare().getCurrencyCode();
			ticketsearchresult.put("TotalEquivFareCurrencyCode", TotalEquivFareCurrencyCode);
			// 稅負總金額
			Integer TotalTaxes1 = itinTotalFare.getTaxes().getTax().get(0).getAmount();
			String TotalTaxes = decimalFormat.format((double) TotalTaxes1);
			ticketsearchresult.put("TotalTaxes", TotalTaxes);
			// 稅負總金額幣別
			String TotalTaxesCurrencyCode = itinTotalFare.getTaxes().getTax().get(0).getCurrencyCode();
			ticketsearchresult.put("TotalTaxesCurrencyCode", TotalTaxesCurrencyCode);
			// 總金額
			Integer TotalFare1 = itinTotalFare.getTotalFare().getAmount();
			String TotalFare = decimalFormat.format((double) TotalFare1);
			ticketsearchresult.put("TotalFare", TotalFare);
			// 總金額幣別
			String TotalFareCurrencyCode = itinTotalFare.getTotalFare().getCurrencyCode();
			ticketsearchresult.put("TotalFareCurrencyCode", TotalFareCurrencyCode);
//			-----------------------------------------------------------------------
			PTCFareBreakdowns pTCFareBreakdowns = airItineraryPricingInfo.getPTCFareBreakdowns();
			List<PTCFareBreakdown> pTCFareBreakdownList = pTCFareBreakdowns.getPTCFareBreakdown();
			// 乘客種類數，2表示有兒童
			Integer NumberOfPassengerType = pTCFareBreakdownList.size();
			ticketsearchresult.put("NumberOfPassengerType", NumberOfPassengerType.toString());

			PTCFareBreakdown pTCFareBreakdownAdult = pTCFareBreakdownList.get(0);
			// 成人人數
			Integer QuantityAdult = pTCFareBreakdownAdult.getPassengerTypeQuantity().getQuantity();
			ticketsearchresult.put("QuantityAdult", QuantityAdult.toString());
			PassengerFare passengerFareAdult = pTCFareBreakdownAdult.getPassengerFare();
			// 成人機票金額
			Integer EquivFareAdult1 = passengerFareAdult.getEquivFare().getAmount();
			String EquivFareAdult = decimalFormat.format((double) EquivFareAdult1);
			ticketsearchresult.put("EquivFareAdult", EquivFareAdult);
			// 成人機票金額幣別
			String EquivFareCurrencyCodeAdult = passengerFareAdult.getEquivFare().getCurrencyCode();
			ticketsearchresult.put("EquivFareCurrencyCodeAdult", EquivFareCurrencyCodeAdult);
			// 成人稅負金額
			Integer TaxesAdult1 = passengerFareAdult.getTaxes().getTotalTax().getAmount();
			String TaxesAdult = decimalFormat.format((double) TaxesAdult1);
			ticketsearchresult.put("TaxesAdult", TaxesAdult);
			// 成人稅負金額幣別
			String TaxesCurrencyCodeAdult = passengerFareAdult.getTaxes().getTotalTax().getCurrencyCode();
			ticketsearchresult.put("taxesCurrencyCodeAdult", TaxesCurrencyCodeAdult);
			// 成人總金額
			Integer FareAdult1 = passengerFareAdult.getTotalFare().getAmount();
			String FareAdult = decimalFormat.format((double) FareAdult1);
			ticketsearchresult.put("FareAdult", FareAdult);
			// 成人總金額幣別
			String FareCurrencyCodeAdult = passengerFareAdult.getTotalFare().getCurrencyCode();
			ticketsearchresult.put("FareCurrencyCodeAdult", FareCurrencyCodeAdult);
			// 成人總金額*人數
			Integer FareAdult1xQ1 = FareAdult1 * QuantityAdult;
			String FareAdult1xQ = decimalFormat.format((double) FareAdult1xQ1);
			ticketsearchresult.put("FareAdult1xQ", FareAdult1xQ);
//			-------------------------------------------------------------------

			// 艙等
			String CabinCode = pTCFareBreakdownAdult.getFareInfos().getFareInfo().get(0).getTPAExtensions().getCabin()
					.getCabin();
			String Cabin = CabinCode;
			for (CabinBean tcb : cabins) {
				if (tcb.getCabinid().toString().equalsIgnoreCase(CabinCode)) {
					Cabin = tcb.getCabinname();
				}
			}
			ticketsearchresult.put("Cabin", Cabin);
			ticketsearchresult.put("CabinCode", CabinCode);
//			-----------------------------------------------------------------------------
			List<BaggageInformation> baggageInformationList = passengerFareAdult.getTPAExtensions()
					.getBaggageInformationList().getBaggageInformation();
			// 去程行李托運重量
			Integer BaggageAllowanceWeightGo = baggageInformationList.get(0).getAllowance().get(0).getWeight();
			// 去程行李托運件數
			Integer BaggageAllowanceCountGo = baggageInformationList.get(0).getAllowance().get(0).getPieces();
			// 去程行李托運重量單位
			String BaggageAllowanceUnitGo = baggageInformationList.get(0).getAllowance().get(0).getUnit();
			// 去程行李托運
			String BaggageAllowanceGo = null;
			if (BaggageAllowanceWeightGo != null) {
				BaggageAllowanceGo = BaggageAllowanceWeightGo + " " + BaggageAllowanceUnitGo + " / 每人";
			} else if (BaggageAllowanceCountGo != null) {
				BaggageAllowanceGo = BaggageAllowanceCountGo + " " + "件 / 每人";
			} else {
				BaggageAllowanceGo = "請洽航空公司";
			}
			ticketsearchresult.put("BaggageAllowanceGo", BaggageAllowanceGo);
			// 回程行李托運重量
			Integer BaggageAllowanceWeightBack = baggageInformationList.get(1).getAllowance().get(0).getWeight();
			// 回程行李托運重量
			Integer BaggageAllowanceCountBack = baggageInformationList.get(1).getAllowance().get(0).getPieces();
			// 回程行李托運重量單位
			String BaggageAllowanceUnitBack = baggageInformationList.get(1).getAllowance().get(0).getUnit();
			String BaggageAllowanceBack = null;
			if (BaggageAllowanceWeightBack != null) {
				BaggageAllowanceBack = BaggageAllowanceWeightBack + " " + BaggageAllowanceUnitBack + " / 每人";
			} else if (BaggageAllowanceCountBack != null) {
				BaggageAllowanceBack = BaggageAllowanceCountBack + " " + "件 / 每人";
			} else {
				BaggageAllowanceBack = "請洽航空公司";
			}
			ticketsearchresult.put("BaggageAllowanceBack", BaggageAllowanceBack);
			PTCFareBreakdown pTCFareBreakdownChild = null;
			Integer QuantityChild = null;
			PassengerFare PassengerFareChild = null;
			String EquivFareChild = null;
			String EquivFareCurrencyCodeChild = null;
			String TaxesChild = null;
			String TaxesCurrencyCodeChild = null;
			String FareChild = null;
			String FareCurrencyCodeChild = null;
			if (NumberOfPassengerType == 2) {
				pTCFareBreakdownChild = pTCFareBreakdownList.get(1);
				// 兒童人數
				QuantityChild = pTCFareBreakdownChild.getPassengerTypeQuantity().getQuantity();
				ticketsearchresult.put("QuantityChild", QuantityChild.toString());
				PassengerFareChild = pTCFareBreakdownChild.getPassengerFare();
				// 兒童機票金額
				Integer EquivFareChild1 = PassengerFareChild.getEquivFare().getAmount();
				EquivFareChild = decimalFormat.format((double) EquivFareChild1);
				ticketsearchresult.put("EquivFareChild", EquivFareChild);
				// 兒童機票金額幣別
				EquivFareCurrencyCodeChild = PassengerFareChild.getEquivFare().getCurrencyCode();
				ticketsearchresult.put("EquivFareCurrencyCodeChild", EquivFareCurrencyCodeChild);
				// 兒童稅負金額
				Integer TaxesChild1 = PassengerFareChild.getTaxes().getTotalTax().getAmount();
				TaxesChild = decimalFormat.format((double) TaxesChild1);
				ticketsearchresult.put("TaxesChild", TaxesChild);
				// 兒童稅負金額幣別
				TaxesCurrencyCodeChild = PassengerFareChild.getTaxes().getTotalTax().getCurrencyCode();
				ticketsearchresult.put("TaxesCurrencyCodeChild", TaxesCurrencyCodeChild);
				// 兒童總金額
				Integer FareChild1 = PassengerFareChild.getTotalFare().getAmount();
				FareChild = decimalFormat.format((double) FareChild1);
				ticketsearchresult.put("FareChild", FareChild);
				// 兒童總金額幣別
				FareCurrencyCodeChild = PassengerFareChild.getTotalFare().getCurrencyCode();
				ticketsearchresult.put("FareCurrencyCodeChild", FareCurrencyCodeChild);
				// 兒童總金額*人數
				Integer FareChild1xQ1 = FareChild1 * QuantityChild;
				String FareChild1xQ = decimalFormat.format((double) FareChild1xQ1);
				ticketsearchresult.put("FareChild1xQ", FareChild1xQ);
			}
			System.out.println(i + 1);
			ticketsearchresults.add(ticketsearchresult);
		}
		System.out.println("s");
		return ticketsearchresults;
	}

	@Override
	public List<CabinBean> getAllCabins() {

		return ticketdao.getAllCabins();
	}

	@Override
	public HashMap<String, HashMap<String, Object>> getResultsByAirline(
			List<HashMap<String, String>> ticketsearchresults) {
		HashMap<String, HashMap<String, Object>> ticketresultsByAirline = new HashMap<String, HashMap<String, Object>>();
		for (int i = 0; i < ticketsearchresults.size(); i++) {
			HashMap<String, String> thisTest = ticketsearchresults.get(i);
			String OperatingAirlineNameGo = thisTest.get("OperatingAirlineNameGo");
			String OperatingAirlineCodeGo = thisTest.get("OperatingAirlineCodeGo");
			String EquivFareAdult = thisTest.get("EquivFareAdult");
			Integer EquivFareAdultInt = Integer.parseInt(EquivFareAdult.replace(",", ""));
			HashMap<String, Object> thisTestObject = new HashMap<String, Object>();
			thisTestObject.put("OperatingAirlineNameGo", OperatingAirlineNameGo);
			thisTestObject.put("OperatingAirlineCodeGo", OperatingAirlineCodeGo);
			thisTestObject.put("EquivFareAdultInt", EquivFareAdultInt);
			thisTestObject.put("times", 1);
			thisTestObject.put("EquivFareAdult", EquivFareAdult);

			if (ticketresultsByAirline.get(OperatingAirlineCodeGo) != null) {
				HashMap<String, Object> ticketresultByAirline = ticketresultsByAirline.get(OperatingAirlineCodeGo);
				ticketresultByAirline.put("times", (Integer) ticketresultByAirline.get("times") + 1);
				if ((Integer) ticketresultByAirline.get("EquivFareAdultInt") > (Integer) thisTestObject
						.get("EquivFareAdultInt")) {
					ticketresultByAirline.put("EquivFareAdultInt", (Integer) thisTestObject.get("EquivFareAdultInt"));
					ticketresultByAirline.put("EquivFareAdult", thisTestObject.get("EquivFareAdult"));
				}
				ticketresultsByAirline.put(OperatingAirlineCodeGo, ticketresultByAirline);
			} else {
				ticketresultsByAirline.put(OperatingAirlineCodeGo, thisTestObject);
			}

		}
		return ticketresultsByAirline;
	}

	@Override
	public String getOrderCode() {
		char[] orderCodeChar = new char[6];
		for (int i = 0; i < 6; i++) {
			orderCodeChar[i] = (char) (Math.random() * 26 + 65);
		}
		return new String(orderCodeChar);
	}

	@Override
	public FlightOrderBean addFlightOrder(FlightOrderBean newFlightOrder) {
		Integer flightOrderID = ticketdao.addFlightOrder(newFlightOrder);
		return ticketdao.getFlightOrderByID(flightOrderID);
	}

	@Override
	public FlightOrderDetailBean addFlightOrderDetail(FlightOrderDetailBean newFlightOrderDetail) {
		newFlightOrderDetail.setAirlineBean(ticketdao.getAirLineByID(newFlightOrderDetail.getAirlineid()));
		newFlightOrderDetail.setDeparturePlaceBean(ticketdao.getCityByID(newFlightOrderDetail.getDeparturePlace()));
		newFlightOrderDetail.setArrivalPlaceBean(ticketdao.getCityByID(newFlightOrderDetail.getArrivalPlace()));
		newFlightOrderDetail.setFlightOrderBean(ticketdao.getFlightOrderByID(newFlightOrderDetail.getFlightOrderID()));
		Integer flightOrderDetailID = ticketdao.addFlightOrderDetail(newFlightOrderDetail);
		return ticketdao.getFlightOrderDetailByID(flightOrderDetailID);
	}

	@Override
	public List<PassengerBean> addPassenger(FlightOrderBean flightOrderBean) {
		Integer adultCount = flightOrderBean.getAdultCount();
		Integer childCount = flightOrderBean.getChildCount();
		for (int i = 1; i <= adultCount; i++) {
			PassengerBean newPassengerA = new PassengerBean();
			newPassengerA.setPassengerType('A');
			newPassengerA.setFlightOrderID(flightOrderBean.getFlightOrderID());
			ticketdao.addPassenger(newPassengerA);
		}
		if (childCount != 0) {
			for (int i = 1; i <= childCount; i++) {
				PassengerBean newPassengerC = new PassengerBean();
				newPassengerC.setPassengerType('C');
				newPassengerC.setFlightOrderID(flightOrderBean.getFlightOrderID());
				ticketdao.addPassenger(newPassengerC);
			}
		}

		return ticketdao.getPassengerByFlightOrderID(flightOrderBean.getFlightOrderID());
	}

	@Override
	public FlightOrderBean updateFlightOrderContactor(FlightOrderBean flightOrderBean) {
		ticketdao.updateFlightOrderContactor(flightOrderBean);
		return ticketdao.getFlightOrderByID(flightOrderBean.getFlightOrderID());
	}

	@Override
	public void updatePassengerInfo(PassengerBean passenger) {
		passenger.setFlightOrderBean(ticketdao.getFlightOrderByID(passenger.getFlightOrderID()));
		ticketdao.updatePassengerInfo(passenger);
	}

	@Override
	public FlightOrderBean getFlightOrderById(Integer flightOrderID) {
		return ticketdao.getFlightOrderByID(flightOrderID);		
	}

	@Override
	public FlightOrderDetailBean getFlightOrderDetailById(Integer flightOrderDetailID) {
		return ticketdao.getFlightOrderDetailByID(flightOrderDetailID);
		
	}

	@Override
	public OrderStatusBean getOrderStatusById(Integer orderStatusID) {
		return ticketdao.getOrderStatusByID(orderStatusID);
	}

	@Override
	public FlightOrderBean updateFlightOrderStatus(FlightOrderBean flightOrderBean) {
		ticketdao.updateFlightOrderStatus(flightOrderBean);
		return ticketdao.getFlightOrderByID(flightOrderBean.getFlightOrderID());
	}

	@Override
	public List<PassengerBean> getPassengerByFlightOrderID(Integer flightOrderID) {
		
		return ticketdao.getPassengerByFlightOrderID(flightOrderID);
	}

	@Override
	public List<FlightOrderDetailBean> getFlightOrderDetailsByMemberID(Integer MemberID) {
		// TODO Auto-generated method stub
		return ticketdao.getFlightOrderDetailsByMemberID(MemberID);
	}
	@Override
	public List<FlightOrderBean> getAllorder() {
		
		return ticketdao.getAllorder();
	}
	
	

}
