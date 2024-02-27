package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * ��ChoosePayment��ATM�ɪ��������G�q������
 * @author mark.chiu
 *
 */
public class ATMRequestObj {
	
	/**
	 * MerchantID
	 * �X�@�S���s��
	 */
	private String MerchantID;
	
	/**
	 * MerchantTradeNo
	 * �X�@�S������s��
	 */
	private String MerchantTradeNo;
	
	/**
	 * RtnCode
	 * ������A
	 */
	private String RtnCode;
	
	/**
	 * RtnMsg
	 * ����T��
	 */
	private String RtnMsg;
	
	/**
	 * TradeNo
	 * ��ɪ�����s��
	 */
	private String TradeNo;
	
	/**
	 * TradeAmt
	 * ������B
	 */
	private String TradeAmt;

	/**
	 * PaymentType
	 * �X�@�S����ܪ��I�ڤ覡
	 */
	private String PaymentType;
	
	/**
	 * TradeDate
	 * �q�榨�߮ɶ�
	 */
	private String TradeDate;
	
	/**
	 * CheckMacValue
	 * �ˬd�X
	 */
	private String CheckMacValue;
	
	/**
	 * BankCode
	 * ú�O�Ȧ�N�X
	 */
	private String BankCode;
	
	/**
	 * vAccount
	 * ú�O�����b��
	 */
	private String vAccount;
	
	/**
	 * ExpireDate
	 * ú�O����
	 */
	private String ExpireDate;
	
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
	 * @param MerchantTradeNo
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * ���oRtnCode ������A
	 * @return RtnCode
	 */
	public String getRtnCode() {
		return RtnCode;
	}
	/**
	 * �]�wRtnCode ������A
	 * @param RtnCode
	 */
	public void setRtnCode(String rtnCode) {
		RtnCode = rtnCode;
	}
	/**
	 * ���oRtnMsg ����T��
	 * @return RtnMsg
	 */
	public String getRtnMsg() {
		return RtnMsg;
	}
	/**
	 * �]�wRtnMsg ����T��
	 * @param RtnMsg
	 */
	public void setRtnMsg(String rtnMsg) {
		RtnMsg = rtnMsg;
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
	 * @param TradeNo
	 */
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	/**
	 * ���oTradeAmt ������B
	 * @return TradeAmt
	 */
	public String getTradeAmt() {
		return TradeAmt;
	}
	/**
	 * �]�wTradeAmt ������B
	 * @param TradeAmt
	 */
	public void setTradeAmt(String tradeAmt) {
		TradeAmt = tradeAmt;
	}
	/**
	 * ���oPaymentType �X�@�S����ܪ��I�ڤ覡
	 * @return PaymentType
	 */
	public String getPaymentType() {
		return PaymentType;
	}
	/**
	 * �]�wPaymentType �X�@�S����ܪ��I�ڤ覡
	 * @param PaymentType
	 */
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	/**
	 * ���oTradeDate �q�榨�߮ɶ�
	 * @return TradeDate
	 */
	public String getTradeDate() {
		return TradeDate;
	}
	/**
	 * �]�wTradeDate �q�榨�߮ɶ�
	 * @param TradeDate
	 */
	public void setTradeDate(String tradeDate) {
		TradeDate = tradeDate;
	}
	/**
	 * ���oCheckMacValue �ˬd�X
	 * @return CheckMacValue
	 */
	public String getCheckMacValue() {
		return CheckMacValue;
	}
	/**
	 * �]�wCheckMacValue �ˬd�X
	 * @param CheckMacValue
	 */
	public void setCheckMacValue(String checkMacValue) {
		CheckMacValue = checkMacValue;
	}
	/**
	 * ���oBankCode ú�O�Ȧ�N�X
	 * @return BankCode
	 */
	public String getBankCode() {
		return BankCode;
	}
	/**
	 * �]�wBankCode ú�O�Ȧ�N�X
	 * @param BankCode
	 */
	public void setBankCode(String bankCode) {
		BankCode = bankCode;
	}
	/**
	 * ���ovAccount ú�O�����b��
	 * @return vAccount
	 */
	public String getvAccount() {
		return vAccount;
	}
	/**
	 * �]�wvAccount ú�O�����b��
	 * @param vAccount
	 */
	public void setvAccount(String vAccount) {
		this.vAccount = vAccount;
	}
	/**
	 * ���oExpireDate ú�O����
	 * @return ExpireDate
	 */
	public String getExpireDate() {
		return ExpireDate;
	}
	/**
	 * �]�wExpireDate ú�O����
	 * @param ExpireDate
	 */
	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}
	@Override
	public String toString() {
		return "ATMRequestObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo + ", RtnCode="
				+ RtnCode + ", RtnMsg=" + RtnMsg + ", TradeNo=" + TradeNo + ", TradeAmt=" + TradeAmt + ", PaymentType="
				+ PaymentType + ", TradeDate=" + TradeDate + ", CheckMacValue=" + CheckMacValue + ", BankCode="
				+ BankCode + ", vAccount=" + vAccount + ", ExpireDate=" + ExpireDate + "]";
	}
}
