package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * ��ChoosePayment��CVS��BARCODE�ɪ��������G�q������
 * @author mark.chiu
 *
 */
public class CVSOrBARCODERequestObj {
	
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
	 * PaymentNo
	 * ú�O�N�X
	 */
	private String PaymentNo;
	
	/**
	 * ExpireDate
	 * ú�O����
	 */
	private String ExpireDate;
	
	/**
	 * Barcode1
	 * ���X�Ĥ@�q���X
	 */
	private String Barcode1;
	
	/**
	 * Barcode2
	 * ���X�ĤG�q���X
	 */
	private String Barcode2;
	
	/**
	 * Barcode3
	 * ���X�ĤT�q���X
	 */
	private String Barcode3;
	
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
	 * ���oRtnCode ������A
	 * @return RtnCode
	 */
	public String getRtnCode() {
		return RtnCode;
	}

	/**
	 * �]�wRtnCode ������A
	 * @param rtnCode
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
	 * @param rtnMsg
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
	 * @param tradeNo
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
	 * @param tradeAmt
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
	 * @param paymentType
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
	 * @param tradeDate
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
	 * @param checkMacValue
	 */
	public void setCheckMacValue(String checkMacValue) {
		CheckMacValue = checkMacValue;
	}

	/**
	 * ���oPaymentNo ú�O�N�X
	 * @return PaymentNo
	 */
	public String getPaymentNo() {
		return PaymentNo;
	}

	/**
	 * �]�wPaymentNo ú�O�N�X
	 * @param paymentNo
	 */
	public void setPaymentNo(String paymentNo) {
		PaymentNo = paymentNo;
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
	 * @param expireDate
	 */
	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}

	/**
	 * ���oBarcode1 ���X�Ĥ@�q���X
	 * @return Barcode1
	 */
	public String getBarcode1() {
		return Barcode1;
	}

	/**
	 * �]�wBarcode1 ���X�Ĥ@�q���X
	 * @param barcode1
	 */
	public void setBarcode1(String barcode1) {
		Barcode1 = barcode1;
	}

	/**
	 * ���oBarcode2 ���X�ĤG�q���X
	 * @return Barcode2
	 */
	public String getBarcode2() {
		return Barcode2;
	}

	/**
	 * �]�wBarcode2 ���X�ĤG�q���X
	 * @param barcode2
	 */
	public void setBarcode2(String barcode2) {
		Barcode2 = barcode2;
	}

	/**
	 * ���oBarcode3 ���X�ĤT�q���X
	 * @return Barcode3
	 */
	public String getBarcode3() {
		return Barcode3;
	}

	/**
	 * �]�wBarcode3 ���X�ĤT�q���X
	 * @param barcode3
	 */
	public void setBarcode3(String barcode3) {
		Barcode3 = barcode3;
	}

	@Override
	public String toString() {
		return "CVSOrBARCODERequestObj [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo
				+ ", RtnCode=" + RtnCode + ", RtnMsg=" + RtnMsg + ", TradeNo=" + TradeNo + ", TradeAmt=" + TradeAmt
				+ ", PaymentType=" + PaymentType + ", TradeDate=" + TradeDate + ", CheckMacValue=" + CheckMacValue
				+ ", PaymentNo=" + PaymentNo + ", ExpireDate=" + ExpireDate + ", Barcode1=" + Barcode1 + ", Barcode2="
				+ Barcode2 + ", Barcode3=" + Barcode3 + "]";
	}
}
