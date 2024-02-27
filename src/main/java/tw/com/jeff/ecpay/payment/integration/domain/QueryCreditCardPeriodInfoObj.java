package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * �H�Υd�w���w�B�q��d�ߪ���
 * @author mark.chiu
 *
 */
public class QueryCreditCardPeriodInfoObj {
	
	/**
	 * MerchantID
	 * �X�@�S���s��
	 */
	private String MerchantID = "";
	
	/**
	 * MerchantTradeNo
	 * �X�@�S������s��
	 */
	private String MerchantTradeNo = "";
	
	/**
	 * TimeStamp
	 * ���Үɶ�
	 */
	private String TimeStamp = "";
	
	/********************* getters and setters *********************/
	
	/**
	 * ���oMerchantID �X�@�S���s��
	 * @return MerchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * �]�wMerchantID �X�@�S���s��
	 * @param merchantID
	 */
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	/**
	 * ���oMerchantTradeNo �X�@�S������s��
	 * @return MerchantTradeNo
	 */
	public String getMerchantTradeNo() {
		return MerchantTradeNo;
	}
	/**
	 * �]�wMerchantTradeNo �X�@�S������s��
	 * @param merchantTradeNo
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * ���oTimeStamp ���Үɶ�
	 * @return TimeStamp
	 */
	public String getTimeStamp() {
		return TimeStamp;
	}
	/**
	 * �]�wTimeStamp ���Үɶ�
	 * @param timeStamp
	 */
	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "QueryCreditCardPeriodInfoObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo
				+ ", TimeStamp=" + TimeStamp + "]";
	}
}
