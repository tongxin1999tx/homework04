package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDao;
import vo.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String usercode = request.getParameter("userCode");
		
		User currentUser = new User();
		
		HttpSession session = request.getSession();
		String savecode = (String)session.getAttribute("Verifycode");
//		System.out.println(savecode+"-------------------");
		String forwardPath = "";
		if (!usercode.equalsIgnoreCase(savecode)){
			request.setAttribute("info","验证码输入错误");
			forwardPath = "/error.jsp";
		}else {
			System.out.println("------------------------------------------");
			System.out.println("验证成功");
			UserDao userDao = new UserDao();
			currentUser	= userDao.getUser(user);
			System.out.println(currentUser.toString());
			if(currentUser.getUserName() == null) {
				request.setAttribute("info", "用户不存在");
				forwardPath = "/error.jsp";
			} else if(currentUser.getPassword().equals(pass)) {
				request.setAttribute("currentUser",currentUser);
				forwardPath = "/main.jsp";
			} else {
					request.setAttribute("info", "密码错误");
					forwardPath = "/error.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}
}
