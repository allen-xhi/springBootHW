package tw.com.jeff.aioDemo.apiPkg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.jeff.ecpay.payment.integration.AllInOne;
import tw.com.jeff.ecpay.payment.integration.domain.DoActionObj;
import tw.com.jeff.ecpay.payment.integration.exception.EcpayException;

@Controller
public class DoActionController {
	AllInOne all ;
	@RequestMapping(value = "backstage/doAction", method = RequestMethod.GET)
	public ModelAndView doAction(){
		return new ModelAndView("doAction", "command", new DoActionObj());
	}
	
	
	@RequestMapping(value = "backstage/doAction", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public @ResponseBody String doAction(DoActionObj doAction){
		all = new AllInOne("");
		try{
			String result = all.doAction(doAction);
			System.out.println(result);
			return result;
		} catch(EcpayException e){
			throw new Error(e.getNewExceptionMessage());
		}
		
	}
}
