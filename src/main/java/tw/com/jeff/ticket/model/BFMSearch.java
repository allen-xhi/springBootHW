package tw.com.jeff.ticket.model;

public class BFMSearch {
	static String 出發時間;
	static String 出發地;
	static String 目的地;
	static String 艙等;
	static String 單程_來回設定方式;
	static String 旅客設定;
	static String 旅客設定2;	
	static int 人數;
	static String 回傳筆數;

	public static String getRequestBody() {

		StringBuffer bfmsearch = new StringBuffer();
		出發時間= "2019-05-10T11:00:00";
		出發地= "TPE";
		目的地= "HKG";
		艙等="Y";
		單程_來回設定方式= "Return";
		旅客設定="ADT";
		旅客設定2="CNN";
		人數=1;
		回傳筆數= "50ITINS";

		bfmsearch.append(
				"{\"OTA_AirLowFareSearchRQ\":{\"DirectFlightsOnly\":false,\"AvailableFlightsOnly\":true,\"Version\":\"4.3.0\",\"POS\":{\"Source\":[{\"PseudoCityCode\":\"A2U8\",\"RequestorID\":{\"Type\":\"1\",\"ID\":\"1\",\"CompanyName\":{\"Code\":\"TN\",\"content\":\"TN\"}}}]},\"OriginDestinationInformation\":[{\"RPH\":\"1\",\"DepartureDateTime\":"
				+ "\""
				+出發時間
				+"\",\"OriginLocation\":{\"LocationCode\":\""
				+出發地
				+"\"},\"DestinationLocation\":{\"LocationCode\":\""
				+目的地
				+"\"},\"TPA_Extensions\":{\"SegmentType\":{\"Code\":\"O\"}}},{\"RPH\":\"2\",\"DepartureDateTime\":\"2019-05-15T11:00:00\",\"OriginLocation\":{\"LocationCode\":\"HKG\"},\"DestinationLocation\":{\"LocationCode\":\"TPE\"},\"TPA_Extensions\":{\"SegmentType\":{\"Code\":\"O\"}}}],\"TravelPreferences\":{\"ValidInterlineTicket\":true,\"FlightTypePref\":{\"MaxConnections\":\"0\"},\"CabinPref\":[{\"Cabin\":\""
				+艙等
				+"\",\"PreferLevel\":\"Preferred\"}],\"TPA_Extensions\":{\"OnlineIndicator\":{\"Ind\":true},\"TripType\":{\"Value\":\""
				+單程_來回設定方式
				+"\"},\"ExcludeCallDirectCarriers\":{\"Enabled\":true}}},\"TravelerInfoSummary\":{\"AirTravelerAvail\":[{\"PassengerTypeQuantity\":[{\"Code\":\""
				+旅客設定
				+"\",\"Quantity\":1},{\"Code\":\""
				+旅客設定2
				+"\",\"Quantity\":"
				+人數
				+"}]}]},\"TPA_Extensions\":{\"IntelliSellTransaction\":{\"RequestType\":{\"Name\":\""
				+回傳筆數
				+"\"}}}}}");

		return bfmsearch.toString();

	}

}
