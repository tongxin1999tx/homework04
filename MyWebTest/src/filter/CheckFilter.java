package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;


@WebFilter("/CheckFilter")
public class CheckFilter implements javax.servlet.Filter {
		private FilterConfig config; 
		private String notCheck;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
 
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getServletPath();
		System.out.println(path);	
		if (notCheck.indexOf(path) == -1) {
			HttpSession session= request.getSession();
			if (session.getAttribute("currentUser")==null) {
				request.setAttribute("info", "ÇëµÇÂ¼ºó³¢ÊÔ£¡");
				request.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
			else {
				chain.doFilter(req, resp);
			}
		}else {
			chain.doFilter(req, resp);
		}
	}
	

	@Override
	public void init(FilterConfig config) throws ServletException {
		notCheck = config.getInitParameter("noCheck");
	}

}
