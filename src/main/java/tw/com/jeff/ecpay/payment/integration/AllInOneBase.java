package tw.com.jeff.ecpay.payment.integration;

import org.w3c.dom.Document;

import tw.com.jeff.ecpay.payment.integration.ecpayOperator.EcpayFunction;

public class AllInOneBase {
	protected static String operatingMode;
	protected static String mercProfile;
	protected static String isProjectContractor;
	protected static String HashKey;
	protected static String HashIV;
	protected static String MerchantID;
	protected static String PlatformID;
	protected static String aioCheckOutUrl;
	protected static String doActionUrl;
	protected static String queryCreditTradeUrl;
	protected static String queryTradeInfoUrl;
	protected static String captureUrl;
	protected static String queryTradeUrl;
	protected static String tradeNoAioUrl;
	protected static String fundingReconDetailUrl;
	protected static Document verifyDoc;
	protected static String[] ignorePayment;
	public AllInOneBase(){
		Document doc;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//			String configPath = URLDecoder.decode(classLoader.getResource("/payment_conf.xml").getPath(), "UTF-8");
//			doc = EcpayFunction.xmlParser(configPath);

//		doc = EcpayFunction.xmlParser("https://payment-stage.ecPay.com.tw/Cashier/AioCheckOut/V2");
//		doc.getDocumentElement().normalize();
		//OperatingMode
//		Element ele = (Element)doc.getElementsByTagName("OperatingMode").item(0);
//		operatingMode = ele.getTextContent();
		operatingMode="TEST";
		//MercProfile
//		ele = (Element)doc.getElementsByTagName("MercProfile").item(0);
//		mercProfile = ele.getTextContent();
		mercProfile="Stage_Account";
		//IsProjectContractor
//		ele = (Element)doc.getElementsByTagName("IsProjectContractor").item(0);
//		isProjectContractor = ele.getTextContent();
		isProjectContractor="N";
		//MID, HashKey, HashIV, PlatformID
//		NodeList nodeList = doc.getElementsByTagName("MInfo");
//		for(int i = 0; i < nodeList.getLength(); i++){
//			ele = (Element)nodeList.item(i);
//			if(ele.getAttribute("name").equalsIgnoreCase(mercProfile)){
//				MerchantID = ele.getElementsByTagName("MerchantID").item(0).getTextContent();
//				HashKey = ele.getElementsByTagName("HashKey").item(0).getTextContent();
//				HashIV = ele.getElementsByTagName("HashIV").item(0).getTextContent();
//				PlatformID = isProjectContractor.equalsIgnoreCase("N")? "" : MerchantID;
//			}
//		}
		MerchantID ="2000132";
		HashKey ="5294y06JbISpM5x9" ;
		HashIV = "v77hoKGq4kWxNNIS";
		PlatformID =""; 
		
//		MerchantID ="3118692";
//		HashKey ="zHDnLTx8dnBkkaAf" ;
//		HashIV = "e5xqjtY8K18F8L4A";
//		PlatformID ="";
		
		// IgnorePayment
//		ele = (Element)doc.getElementsByTagName("IgnorePayment").item(0);
//		nodeList = ele.getElementsByTagName("Method");
//		ignorePayment = new String[nodeList.getLength()];
		ignorePayment = new String[0];
		
//		for(int i = 0; i < nodeList.getLength(); i++){
//			ignorePayment[i] = nodeList.item(i).getTextContent();
//		}
//		if(HashKey == null){
//			throw new EcpayException(ErrorMessage.MInfo_NOT_SETTING);
//		}
	}
}
