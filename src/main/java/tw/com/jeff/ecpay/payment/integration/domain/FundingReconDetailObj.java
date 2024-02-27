package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * �U���H�Υd���ڹ�b����ɪ���
 * @author mark.chiu
 *
 */
public class FundingReconDetailObj {
	
	/**
	 * MerchantID
	 * �|���s��(��allPay����)
	 */
	private String MerchantID = "";
	
	/**
	 * PayDateType
	 * �d�ߤ�����O
	 */
	private String PayDateType = "";
	
	/**
	 * StartDate
	 * �d�߶}�l���
	 */
	private String StartDate = "";
	
	/**
	 * EndDate
	 * �d�ߵ������
	 */
	private String EndDate = "";
	
	/********************* getters and setters *********************/
	
	/**
	 * ���oMerchantID �|���s��(��allPay����)
	 * @return MerchantID
	 */
	public String getMerchantID() {
		return MerchantID;
	}
	/**
	 * �]�wMerchantID �|���s��(��allPay����)
	 * @param merchantID
	 */
	public void setMerchantID(String merchantID) {
		MerchantID = merchantID;
	}
	/**
	 * ���oPayDateType �d�ߤ�����O
	 * @return PayDateType
	 */
	public String getPayDateType() {
		return PayDateType;
	}
	/**
	 * �]�wPayDateType �d�ߤ�����O
	 * @param payDateType
	 */
	public void setPayDateType(String payDateType) {
		PayDateType = payDateType;
	}
	/**
	 * ���oStartDate �d�߶}�l���
	 * @return StartDate
	 */
	public String getStartDate() {
		return StartDate;
	}
	/**
	 * �]�wStartDate �d�߶}�l���
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		StartDate = startDate;
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
	@Override
	public String toString() {
		return "FundingReconDetailObj [MerchantID=" + MerchantID + ", PayDateType=" + PayDateType + ", StartDate="
				+ StartDate + ", EndDate=" + EndDate + "]";
	}
}
