package tw.com.jeff.ecpay.payment.integration.domain;

/**
 * ����ATM�q�檫��
 * @author mark.chiu
 *
 */
public class AioCheckOutATM {
	
	/**
	 * MerchantID
	 * �X�@�S���s��(�Ѻ�ɴ���)
	 */
	private String MerchantID = "";
	
	/**
	 * MerchantTradeNo
	 * �X�@�S������s��(�ѦX�@�S������)�A�ӥ���s�����i����
	 */
	private String MerchantTradeNo = "";
	
	/**
	 * MerchantTradeDate
	 * �X�@�S������ɶ�
	 */
	private String MerchantTradeDate = "";
	
	/**
	 * PaymentType
	 * �������
	 */
	private String PaymentType = "aio";
	
	/**
	 * TotalAmount
	 * ������B
	 */
	private String TotalAmount = "";
	
	/**
	 * TradeDesc
	 * ����y�z
	 */
	private String TradeDesc = "";
	
	/**
	 * ItemName
	 * �ӫ~�W��
	 */
	private String ItemName = "";
	
	/**
	 * ReturnURL
	 * �I�ڧ����q���^�Ǻ��}
	 */
	private String ReturnURL = "";
	
	/**
	 * ChoosePayment
	 * ��ܹw�]�I�ڤ覡
	 */
	private String ChoosePayment = "ATM";
	
	/**
	 * ClientBackURL
	 * Client�ݪ�^�X�@�S���t�Ϊ����s�s��
	 */
	private String ClientBackURL = "";
	
	/**
	 * ItemURL
	 * �ӫ~�P����}
	 */
	private String ItemURL = "";
	
	/**
	 * Remark
	 * �Ƶ����
	 */
	private String Remark = "";
	
	/**
	 * ChooseSubPayment
	 * ��ܹw�]�I�ڤl����
	 */
	private String ChooseSubPayment = "";
	
	/**
	 * OrderResultURL
	 * Client�ݦ^�ǥI�ڵ��G���}
	 */
	private String OrderResultURL = "";
	
	/**
	 * NeedExtraPaidInfo
	 * �O�_�ݭn�B�~���I�ڸ�T
	 */
	private String NeedExtraPaidInfo = "";
	
	/**
	 * DeviceSource
	 * �˸m�ӷ�
	 */
	private String DeviceSource = "";
	
	/**
	 * IgnorePayment
	 * ���åI�ڤ覡
	 */
	private String IgnorePayment = "";
	
	/**
	 * PlatformID
	 * �S���X�@���x�ӥN��(�Ѻ�ɴ���)
	 */
	private String PlatformID = "";
	
	/**
	 * InvoiceMark
	 * �q�l�o���}�ߵ��O
	 */
	private String InvoiceMark = "";
	
	/**
	 * HoldTradeAMT
	 * �O�_���𼷴�
	 */
	private String HoldTradeAMT = "";
	
	/**
	 * EncryptType
	 * CheckMacValue�[�K����
	 */
	private String EncryptType = "1";
	
	/**
	 * ExpireDate
	 * ���\ú�O���ĤѼ�
	 */
	private String ExpireDate = "";
	
	/**
	 * PaymentInfoURL
	 * Server�ݦ^�ǥI�ڬ�����T
	 */
	private String PaymentInfoURL = "";
	
	/**
	 * ClientRedirectURL
	 * Client�ݦ^�ǥI�ڬ�����T
	 */
	private String ClientRedirectURL = "";
	
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
	 * ���oMerchantTradeNo �X�@�S������s��(�ѦX�@�S������)�A�ӥ���s�����i����
	 * @return MerchantTradeNo
	 */
	public String getMerchantTradeNo() {
		return MerchantTradeNo;
	}
	/**
	 * �]�wMerchantTradeNo �X�@�S������s��(�ѦX�@�S������)�A�ӥ���s�����i����
	 * @param merchantTradeNo
	 */
	public void setMerchantTradeNo(String merchantTradeNo) {
		MerchantTradeNo = merchantTradeNo;
	}
	/**
	 * ���oMerchantTradeDate �X�@�S������ɶ�
	 * @return MerchantTradeDate
	 */
	public String getMerchantTradeDate() {
		return MerchantTradeDate;
	}
	/**
	 * �]�wMerchantTradeDate �X�@�S������ɶ��A�ХH yyyy/MM/dd HH:mm:ss�榡�a�J
	 * @param merchantTradeDate
	 */
	public void setMerchantTradeDate(String merchantTradeDate) {
		MerchantTradeDate = merchantTradeDate;
	}
	/**
	 * ���oPaymentType �������
	 * @return PaymentType
	 */
	public String getPaymentType() {
		return PaymentType;
	}
	/**
	 * �]�wPaymentType �������
	 * @param paymentType
	 */
//	public void setPaymentType(String paymentType) {
//		PaymentType = paymentType;
//	}
	/**
	 * ���oTotalAmount ������B
	 * @return TotalAmount
	 */
	public String getTotalAmount() {
		return TotalAmount;
	}
	/**
	 * �]�wTotalAmount ������B
	 * @param totalAmount
	 */
	public void setTotalAmount(String totalAmount) {
		TotalAmount = totalAmount;
	}
	/**
	 * ���oTradeDesc ����y�z
	 * @return TradeDesc
	 */
	public String getTradeDesc() {
		return TradeDesc;
	}
	/**
	 * �]�wTradeDesc ����y�z
	 * @param tradeDesc
	 */
	public void setTradeDesc(String tradeDesc) {
		TradeDesc = tradeDesc;
	}
	/**
	 * ���oItemName �ӫ~�W��
	 * @return ItemName
	 */
	public String getItemName() {
		return ItemName;
	}
	/**
	 * �]�wItemName �ӫ~�W��
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	/**
	 * ���oReturnURL �I�ڧ����q���^�Ǻ��}
	 * @return ReturnURL
	 */
	public String getReturnURL() {
		return ReturnURL;
	}
	/**
	 * �]�wReturnURL �I�ڧ����q���^�Ǻ��}
	 * @param returnURL
	 */
	public void setReturnURL(String returnURL) {
		ReturnURL = returnURL;
	}
	/**
	 * ���oChoosePayment ��ܹw�]�I�ڤ覡
	 * @return ChoosePayment
	 */
	public String getChoosePayment() {
		return ChoosePayment;
	}
	/**
	 * �]�wChoosePayment ��ܹw�]�I�ڤ覡
	 * @param choosePayment
	 */
//	public void setChoosePayment(String choosePayment) {
//		ChoosePayment = choosePayment;
//	}
	/**
	 * ���oClientBackURL Client�ݪ�^�X�@�S���t�Ϊ����s�s��
	 * @return ClientBackURL
	 */
	public String getClientBackURL() {
		return ClientBackURL;
	}
	/**
	 * �]�wClientBackURL Client�ݪ�^�X�@�S���t�Ϊ����s�s��
	 * @param clientBackURL
	 */
	public void setClientBackURL(String clientBackURL) {
		ClientBackURL = clientBackURL;
	}
	/**
	 * ���oItemURL �ӫ~�P����}
	 * @return ItemURL
	 */
	public String getItemURL() {
		return ItemURL;
	}
	/**
	 * �]�w ItemURL �ӫ~�P����}
	 * @param itemURL
	 */
	public void setItemURL(String itemURL) {
		ItemURL = itemURL;
	}
	/**
	 * ���oRemark �Ƶ����
	 * @return Remark
	 */
	public String getRemark() {
		return Remark;
	}
	/**
	 * �]�wRemark �Ƶ����
	 * @param remark
	 */
	public void setRemark(String remark) {
		Remark = remark;
	}
	/**
	 * ���oChooseSubPayment ��ܹw�]�I�ڤl����
	 * @return ChooseSubPayment
	 */
	public String getChooseSubPayment() {
		return ChooseSubPayment;
	}
	/**
	 * �]�wChooseSubPayment ��ܹw�]�I�ڤl����
	 * @param chooseSubPayment
	 */
	public void setChooseSubPayment(String chooseSubPayment) {
		ChooseSubPayment = chooseSubPayment;
	}
	/**
	 * ���oOrderResultURL Client�ݦ^�ǥI�ڵ��G���}
	 * @return OrderResultURL
	 */
	public String getOrderResultURL() {
		return OrderResultURL;
	}
	/**
	 * �]�wOrderResultURL Client�ݦ^�ǥI�ڵ��G���}
	 * @param orderResultURL
	 */
	public void setOrderResultURL(String orderResultURL) {
		OrderResultURL = orderResultURL;
	}
	/**
	 * ���oNeedExtraPaidInfo �O�_�ݭn�B�~���I�ڸ�T 
	 * @return NeedExtraPaidInfo
	 */
	public String getNeedExtraPaidInfo() {
		return NeedExtraPaidInfo;
	}
	/**
	 * �]�wNeedExtraPaidInfo �O�_�ݭn�B�~���I�ڸ�T 
	 * @param needExtraPaidInfo
	 */
	public void setNeedExtraPaidInfo(String needExtraPaidInfo) {
		NeedExtraPaidInfo = needExtraPaidInfo;
	}
	/**
	 * ���oDeviceSource �˸m�ӷ�
	 * @return DeviceSource
	 */
	public String getDeviceSource() {
		return DeviceSource;
	}
	/**
	 * �]�wDeviceSource �˸m�ӷ�
	 * @param deviceSource
	 */
	public void setDeviceSource(String deviceSource) {
		DeviceSource = deviceSource;
	}
	/**
	 * ���oIgnorePayment ���åI�ڤ覡
	 * @return IgnorePayment
	 */
	public String getIgnorePayment() {
		return IgnorePayment;
	}
	/**
	 * �]�wIgnorePayment ���åI�ڤ覡
	 * @param ignorePayment
	 */
	public void setIgnorePayment(String ignorePayment) {
		IgnorePayment = ignorePayment;
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
	/**
	 * ���oInvoiceMark �q�l�o���}�ߵ��O
	 * @return InvoiceMark
	 */
	public String getInvoiceMark() {
		return InvoiceMark;
	}
	/**
	 * �]�wInvoiceMark �q�l�o���}�ߵ��O
	 * @param invoiceMark
	 */
	public void setInvoiceMark(String invoiceMark) {
		InvoiceMark = invoiceMark;
	}
	/**
	 * ���oHoldTradeAMT �O�_���𼷴�
	 * @return HoldTradeAMT
	 */
	public String getHoldTradeAMT() {
		return HoldTradeAMT;
	}
	/**
	 * �]�wHoldTradeAMT �O�_���𼷴�
	 * @param holdTradeAMT
	 */
	public void setHoldTradeAMT(String holdTradeAMT) {
		HoldTradeAMT = holdTradeAMT;
	}
	/**
	 * ���oEncryptType CheckMacValue�[�K����
	 * @return EncryptType
	 */
	public String getEncryptType() {
		return EncryptType;
	}
	/**
	 * �]�wEncryptType CheckMacValue�[�K����
	 * @param encryptType
	 */
//	public void setEncryptType(String encryptType) {
//		EncryptType = encryptType;
//	}
	/**
	 * ���oExpireDate ���\ú�O���ĤѼ�
	 * @return ExpireDate
	 */
	public String getExpireDate() {
		return ExpireDate;
	}
	
	/**
	 * �]�wExpireDate ���\ú�O���ĤѼ�
	 * @param expireDate
	 */
	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}
	/**
	 * ���oPaymentInfoURL Server�ݦ^�ǥI�ڬ�����T
	 * @return PaymentInfoURL
	 */
	public String getPaymentInfoURL() {
		return PaymentInfoURL;
	}
	/**
	 * �]�wPaymentInfoURL Server�ݦ^�ǥI�ڬ�����T
	 * @param paymentInfoURL
	 */
	public void setPaymentInfoURL(String paymentInfoURL) {
		PaymentInfoURL = paymentInfoURL;
	}
	/**
	 * ���oClientRedirectURL Client�ݦ^�ǥI�ڬ�����T
	 * @return ClientRedirectURL
	 */
	public String getClientRedirectURL() {
		return ClientRedirectURL;
	}
	/**
	 * �]�wClientRedirectURL Client�ݦ^�ǥI�ڬ�����T
	 * @param clientRedirectURL
	 */
	public void setClientRedirectURL(String clientRedirectURL) {
		ClientRedirectURL = clientRedirectURL;
	}
	@Override
	public String toString() {
		return "AioCheckOutATM [MerchantID=" + MerchantID + ", MerchantTradeNo=" + MerchantTradeNo
				+ ", MerchantTradeDate=" + MerchantTradeDate + ", PaymentType=" + PaymentType + ", TotalAmount="
				+ TotalAmount + ", TradeDesc=" + TradeDesc + ", ItemName=" + ItemName + ", ReturnURL=" + ReturnURL
				+ ", ChoosePayment=" + ChoosePayment + ", ClientBackURL=" + ClientBackURL + ", ItemURL=" + ItemURL
				+ ", Remark=" + Remark + ", ChooseSubPayment=" + ChooseSubPayment + ", OrderResultURL=" + OrderResultURL
				+ ", NeedExtraPaidInfo=" + NeedExtraPaidInfo + ", DeviceSource=" + DeviceSource + ", IgnorePayment="
				+ IgnorePayment + ", PlatformID=" + PlatformID + ", InvoiceMark=" + InvoiceMark + ", HoldTradeAMT="
				+ HoldTradeAMT + ", EncryptType=" + EncryptType + ", ExpireDate=" + ExpireDate + ", PaymentInfoURL="
				+ PaymentInfoURL + ", ClientRedirectURL=" + ClientRedirectURL + "]";
	}
}
