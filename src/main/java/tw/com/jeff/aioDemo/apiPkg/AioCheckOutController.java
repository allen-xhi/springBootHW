package tw.com.jeff.aioDemo.apiPkg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.jeff.ecpay.payment.integration.AllInOne;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutALL;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutATM;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutBARCODE;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutCVS;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutDevide;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutOneTime;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutPeriod;
import tw.com.jeff.ecpay.payment.integration.domain.AioCheckOutWebATM;
import tw.com.jeff.ecpay.payment.integration.domain.InvoiceObj;
import tw.com.jeff.ecpay.payment.integration.exception.EcpayException;

@Controller
public class AioCheckOutController {
	AllInOne all;
	@RequestMapping(value = "/frontEnd/aioCheckOut", method = RequestMethod.GET)
	public String aioCheckOut(Model model){
		model.addAttribute("info", "綠界金流付款選擇頁");
		return "aioCheckOut";
	}
	
	@RequestMapping(value = "/aioCheckOut/aioCheckOutALL", method = RequestMethod.GET)
	public ModelAndView aioCheckOutALL(){
		return new ModelAndView("views/aioCheckOutALL", "command", new AioCheckOutALL());
	}
	
	
	@RequestMapping(value = "/aioCheckOut/aioCheckOutALL", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutALL(AioCheckOutALL aio){
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("item1");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutATM", method = RequestMethod.GET)
	public ModelAndView aioCheckOutATM(){
		return new ModelAndView("aioCheckOutATM", "command", new AioCheckOutATM());
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutATM", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutATM(AioCheckOutATM aio, @RequestParam(value="ChooseSubPayment")String payment){
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬開發票
		invoice.setRelateNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 30));
		invoice.setCustomerID("123456");
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("2");
		invoice.setLoveCode("X123456");
		invoice.setPrint("0");
		//DB裡面資料
		invoice.setInvoiceItemName("電視");
		invoice.setInvoiceItemCount("1");
		invoice.setInvoiceItemWord("台");
		invoice.setInvoiceItemPrice("50");
		invoice.setInvoiceItemTaxType("1");
		//客戶填入系統所得的資訊
		invoice.setCustomerName("Mark");
		invoice.setCustomerAddr("台北");
		invoice.setCustomerPhone("0911429215");
		//系統決定延遲天數
		invoice.setDelayDay("1");
		//系統設定字軌類別
		invoice.setInvType("07");
		//買加填選
		aio.setChooseSubPayment(payment);
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("電視");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutBARCODE", method = RequestMethod.GET)
	public ModelAndView aioCheckOutBARCODE(){
		return new ModelAndView("aioCheckOutBARCODE", "command", new AioCheckOutBARCODE());
	}
	
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutBARCODE", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutBARCODE(AioCheckOutBARCODE aio){
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("item1");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		//廠商自行設定
		aio.setStoreExpireDate("7");
		aio.setDesc_1("d1");
		aio.setDesc_2("d2");
		aio.setDesc_3("d3");
		aio.setDesc_4("d4");
		aio.setPaymentInfoURL("http://www.yahoo.com.tw");
		aio.setClientBackURL("");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutCVS", method = RequestMethod.GET)
	public ModelAndView aioCheckOutCVS(){
		return new ModelAndView("aioCheckOutCVS", "command", new AioCheckOutCVS());
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutCVS", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutCVS(AioCheckOutCVS aio, @RequestParam(value="ChooseSubPayment")String payment){
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬開發票
		invoice.setRelateNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 30));
		invoice.setCustomerID("123456");
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("2");
		invoice.setLoveCode("X123456");
		invoice.setPrint("0");
		//DB裡面資料
		invoice.setInvoiceItemName("電視|電腦");
		invoice.setInvoiceItemCount("1|1");
		invoice.setInvoiceItemWord("台|台");
		invoice.setInvoiceItemPrice("50|50");
		invoice.setInvoiceItemTaxType("1|1");
		//客戶填入系統所得的資訊
		invoice.setCustomerName("Mark");
		invoice.setCustomerAddr("台北");
		invoice.setCustomerPhone("0911429215");
		//系統決定延遲天數
		invoice.setDelayDay("1");
		//系統設定字軌類別
		invoice.setInvType("07");
		//買加填選
		aio.setChooseSubPayment(payment);
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("電視50元#電腦50元");
		aio.setTotalAmount("100");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutDevide", method = RequestMethod.GET)
	public ModelAndView aioCheckOutDevide(){
		return new ModelAndView("aioCheckOutDevide", "command", new AioCheckOutDevide());
	}
	
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutDevide", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutDevide(AioCheckOutDevide aio){
		all = new AllInOne("");
		System.out.println(aio.getRemark());
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("item1");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		//後台幫忙算 使用刷卡分期的總付款金額。
		aio.setInstallmentAmount("60");
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutOneTime", method = RequestMethod.GET)
	public ModelAndView aioCheckOutOneTime(){
		return new ModelAndView("aioCheckOutOneTime", "command", new AioCheckOutOneTime());
	}
	
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutOneTime", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutDevide(AioCheckOutOneTime aio){
		all = new AllInOne("");
		System.out.println(aio.getRemark());
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("item1");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutPeriod", method = RequestMethod.GET)
	public ModelAndView aioCheckOutPeriod(){
		return new ModelAndView("aioCheckOutPeriod", "command", new AioCheckOutPeriod());
	}
	
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutPeriod", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutPeriod(AioCheckOutPeriod aio){
		all = new AllInOne("");
		System.out.println(aio.getRemark());
		InvoiceObj invoice = new InvoiceObj();
		//模擬不開發票
		invoice = null;
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("item1");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		//廠商自行設定定期定額規則
		aio.setPeriodAmount("50");
		aio.setPeriodType("M");
		aio.setFrequency("1");
		aio.setExecTimes("99");
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutWebATM", method = RequestMethod.GET)
	public ModelAndView aioCheckOutWebATM(){
		return new ModelAndView("aioCheckOutWebATM", "command", new AioCheckOutWebATM());
	}
	
	@RequestMapping(value = "frontEnd/aioCheckOut/aioCheckOutWebATM", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutWebATM(AioCheckOutWebATM aio, @RequestParam(value="ChooseSubPayment")String payment){
		all = new AllInOne("");
		InvoiceObj invoice = new InvoiceObj();
		//模擬開發票
		invoice.setRelateNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 30));
		invoice.setCustomerID("123456");
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("2");
		invoice.setLoveCode("X123456");
		invoice.setPrint("0");
		//DB裡面資料
		invoice.setInvoiceItemName("電視");
		invoice.setInvoiceItemCount("1");
		invoice.setInvoiceItemWord("台");
		invoice.setInvoiceItemPrice("50");
		invoice.setInvoiceItemTaxType("1");
		//客戶填入系統所得的資訊
		invoice.setCustomerName("Mark");
		invoice.setCustomerAddr("台北");
		invoice.setCustomerPhone("0911429215");
		//系統決定延遲天數
		invoice.setDelayDay("1");
		//系統設定字軌類別
		invoice.setInvType("07");
		//買加填選
		aio.setChooseSubPayment(payment);
		//廠商系統自行產生
		aio.setMerchantTradeNo(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20));
		Date date = new Date();
		//廠商可自行決定交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		aio.setMerchantTradeDate(sdf.format(date));
		//從廠商DB撈出的商品資訊
		aio.setItemName("電視");
		aio.setTotalAmount("50");
		aio.setTradeDesc("item desc");
		//廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		//後端設定付款完成通知回傳網址
		aio.setReturnURL("http://211.23.128.214:5000");
		try{
			String html = all.aioCheckOut(aio, invoice);
			System.out.println(html);
			return html;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
}
