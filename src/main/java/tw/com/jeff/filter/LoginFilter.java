package tw.com.jeff.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns="/needLogin/*")
public class LoginFilter extends HttpFilter {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		setLoginStatus("false");
		String url = request.getContextPath()+"/login";
		HttpSession session = request.getSession();
		String loginStatus = String.valueOf(session.getAttribute("loginStatus"));
		if(loginStatus==null||loginStatus.equals("false")||loginStatus.equals("null")) {
			System.out.println("please login");
			response.sendRedirect(url);
		}
		super.doFilter(request, response, chain);
	}
	@Override
	public void destroy() {
		System.out.println("login filter destory");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("login filter init");
		super.init();
	}


}
