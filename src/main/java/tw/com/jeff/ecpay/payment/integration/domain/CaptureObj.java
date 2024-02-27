package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * �X�@�S���ӽм��ڪ���
 * @author mark.chiu
 *
 */
public class CaptureObj {
	
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
	 * CaptureAMT
	 * �X�@�S���ӽм��ڪ��B
	 */
	private String CaptureAMT = "";
	
	/**
	 * UserRefundAMT
	 * �n�h�ڵ��R�誺���B
	 */
	private String UserRefundAMT = "0";
	
	/**
	 * PlatformID
	 * �S���X�@���x�ӥN��(�Ѻ�ɴ���)
	 */
	private String PlatformID = "";
	
	/**
	 * Remark
	 * �Ƶ�
	 */
	private String Remark = "";
	
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
	 * ���oCaptureAMT �X�@�S���ӽм��ڪ��B
	 * @return CaptureAMT
	 */
	public String getCaptureAMT() {
		return CaptureAMT;
	}
	/**
	 * �]�wCaptureAMT �X�@�S���ӽм��ڪ��B
	 * @param captureAMT
	 */
	public void setCaptureAMT(String captureAMT) {
		CaptureAMT = captureAMT;
	}
	/**
	 * ���oUserRefundAMT �n�h�ڵ��R�誺���B
	 * @return UserRefundAMT
	 */
	public String getUserRefundAMT() {
		return UserRefundAMT;
	}
	/**
	 * �]�wUserRefundAMT �n�h�ڵ��R�誺���B
	 * @param userRefundAMT
	 */
//	public void setUserRefundAMT(String userRefundAMT) {
//		UserRefundAMT = userRefundAMT;
//	}
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
	/**
	 * ���oRemark �Ƶ�
	 * @return Remark
	 */
	public String getRemark() {
		return Remark;
	}
	/**
	 * �]�wRemark �Ƶ�
	 * @param remark
	 */
	public void setRemark(String remark) {
		Remark = remark;
	}
	@Override
	public String toString() {
		return "CaptureObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo + ", CaptureAMT="
				+ CaptureAMT + ", UserRefundAMT=" + UserRefundAMT + ", PlatformID=" + PlatformID + ", Remark=" + Remark
				+ "]";
	}
}
