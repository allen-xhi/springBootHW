package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * �H�Υd���b/�h��/����/��󪫥�
 * @author mark.chiu
 *
 */
public class DoActionObj {
	
	/**
	 * MerchantID
	 * �X�@�S���s��(�Ѻ�ɴ���)
	 */
	private String MerchantID = "";
	
	/**
	 * MerchantTradeNo
	 * �X�@�S������s��
	 */
	private String MerchantTradeNo = "";
	
	/**
	 * TradeNo
	 * ��ɪ�����s��
	 */
	private String TradeNo = "";
	
	/**
	 * Action
	 * ����ʧ@
	 */
	private String Action = "";
	
	/**
	 * TotalAmount
	 * ���B
	 */
	private String TotalAmount = "";
	
	/**
	 * PlatformID
	 * �S���X�@���x�ӥN��(�Ѻ�ɴ���)
	 */
	private String PlatformID = "";
	
	/********************* getters and setters *********************/
	
	/**
	 * ���oMerchantID �X�@�S���s��(�Ѻ�ɴ���)
	 * @return MerchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * �]�wMerchantID �X�@�S���s��(�Ѻ�ɴ���)
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
	 * ���oTradeNo ��ɪ�����s��
	 * @return TradeNo
	 */
	public String getTradeNo() {
		return TradeNo;
	}
	/**
	 * �]�wTradeNo ��ɪ�����s��
	 * @param tradeNo
	 */
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	/**
	 * ���oAction ����ʧ@
	 * @return Action
	 */
	public String getAction() {
		return Action;
	}
	/**
	 * �]�wAction ����ʧ@
	 * @param action
	 */
	public void setAction(String action) {
		Action = action;
	}
	/**
	 * ���oTotalAmount ���B
	 * @return TotalAmount
	 */
	public String getTotalAmount() {
		return TotalAmount;
	}
	/**
	 * �]�wTotalAmount ���B
	 * @param totalAmount
	 */
	public void setTotalAmount(String totalAmount) {
		TotalAmount = totalAmount;
	}
	/**
	 * ���oPlatformID �S���X�@���x�ӥN��(�Ѻ�ɴ���)
	 * @return PlatformID
	 */
	public String getPlatformID() {
		return PlatformID;
	}
	/**
	 * �]�wPlatformID �S���X�@���x�ӥN��(�Ѻ�ɴ���)
	 * @param platformID
	 */
	public void setPlatformID(String platformID) {
		PlatformID = platformID;
	}
	@Override
	public String toString() {
		return "DoActionObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo + ", TradeNo=" + TradeNo
				+ ", Action=" + Action + ", TotalAmount=" + TotalAmount + ", PlatformID=" + PlatformID + "]";
	}
}
