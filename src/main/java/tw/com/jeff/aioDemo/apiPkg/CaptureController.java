package tw.com.jeff.aioDemo.apiPkg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.jeff.ecpay.payment.integration.AllInOne;
import tw.com.jeff.ecpay.payment.integration.domain.CaptureObj;
import tw.com.jeff.ecpay.payment.integration.exception.EcpayException;

@Controller
public class CaptureController {
	AllInOne all ;
	@RequestMapping(value = "backstage/capture", method = RequestMethod.GET)
	public ModelAndView capture(){
		return new ModelAndView("capture", "command", new CaptureObj());
	}
	
	
	@RequestMapping(value = "backstage/capture", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String capture(CaptureObj capture){
		all = new AllInOne("");
		try{
			String result = all.capture(capture);
			System.out.println(result);
			return result;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
}
