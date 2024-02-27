package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * �U���X�@�S����b�C���ɪ���
 * @author mark.chiu
 *
 */
public class TradeNoAioObj {
	
	/**
	 * MerchantID
	 * �X�@�S���s��(�Ѻ�ɴ���)
	 */
	private String MerchantID = "";
	
	/**
	 * DateType
	 * �d�ߤ�����O
	 */
	private String DateType = "";
	
	/**
	 * BeginDate
	 * �d�߶}�l���
	 */
	private String BeginDate = "";
	
	/**
	 * EndDate
	 * �d�ߵ������
	 */
	private String EndDate = "";
	
	/**
	 * PaymentType
	 * �I�ڤ覡
	 */
	private String PaymentType = "";
	
	/**
	 * PlatformStatus
	 * �q������
	 */
	private String PlatformStatus = "";
	
	/**
	 * PaymentStatus
	 * �I�ڪ��A
	 */
	private String PaymentStatus = "";
	
	/**
	 * AllocateStatus
	 * ���ڪ��A
	 */
	private String AllocateStatus = "";
	
	/**
	 * MediaFormatted
	 * CSV�榡
	 */
	private String MediaFormated = "";
	
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
	 * ���oDateType �d�ߤ�����O
	 * @return DateType
	 */
	public String getDateType() {
		return DateType;
	}
	/**
	 * �]�wDateType �d�ߤ�����O
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		DateType = dateType;
	}
	/**
	 * ���oBeginDate �d�߶}�l���
	 * @return BeginDate
	 */
	public String getBeginDate() {
		return BeginDate;
	}
	/**
	 * �]�wBeginDate �d�߶}�l���
	 * @param beginDate
	 */
	public void setBeginDate(String beginDate) {
		BeginDate = beginDate;
	}
	/**
	 * ���oEndDate �d�ߵ������
	 * @return EndDate
	 */
	public String getEndDate() {
		return EndDate;
	}
	/**
	 * �]�wEndDate �d�ߵ������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	/**
	 * ���oPaymentType �I�ڤ覡
	 * @return PaymentType
	 */
	public String getPaymentType() {
		return PaymentType;
	}
	/**
	 * �]�wPaymentType �I�ڤ覡
	 * @param paymentType
	 */
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	/**
	 * ���oPlatformStatus �q������
	 * @return PlatformStatus
	 */
	public String getPlatformStatus() {
		return PlatformStatus;
	}
	/**
	 * �]�wPlatformStatus �q������
	 * @param platformStatus
	 */
	public void setPlatformStatus(String platformStatus) {
		PlatformStatus = platformStatus;
	}
	/**
	 * ���oPaymentStatus �I�ڪ��A
	 * @return PaymentStatus
	 */
	public String getPaymentStatus() {
		return PaymentStatus;
	}
	/**
	 * �]�wPaymentStatus �I�ڪ��A
	 * @param paymentStatus
	 */
	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}
	/**
	 * ���oAllocateStatus ���ڪ��A
	 * @return AllocateStatus
	 */
	public String getAllocateStatus() {
		return AllocateStatus;
	}
	/**
	 * �]�wAllocateStatus ���ڪ��A
	 * @param allocateStatus
	 */
	public void setAllocateStatus(String allocateStatus) {
		AllocateStatus = allocateStatus;
	}
	/**
	 * ���oMediaFormatted CSV�榡
	 * @return MediaFormatted
	 */
	public String getMediaFormated() {
		return MediaFormated;
	}
	/**
	 * �]�wMediaFormatted CSV�榡
	 * @param mediaFormatted
	 */
	public void setMediaFormated(String mediaFormatted) {
		MediaFormated = mediaFormatted;
	}
	@Override
	public String toString() {
		return "TradeNoAioObj [MerchantID=" + MerchantID + ", DateType=" + DateType + ", BeginDate=" + BeginDate
				+ ", EndDate=" + EndDate + ", PaymentType=" + PaymentType + ", PlatformStatus=" + PlatformStatus
				+ ", PaymentStatus=" + PaymentStatus + ", AllocateStatus=" + AllocateStatus + ", MediaFormated="
				+ MediaFormated + "]";
	}
}
