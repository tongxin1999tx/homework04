package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UserDao;
import vo.User;

@WebServlet("/queryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queryParams = request.getParameter("queryParams");
		String pageParams = request.getParameter("pageParams");

		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String,Object> mapPage = gson.fromJson(pageParams, HashMap.class);
		User user = new User();
		Page page = Page.getPageParams(mapPage);
		if(queryParams != null) {
			user = gson.fromJson(queryParams, User.class);
		}
		UserDao userdao = new UserDao();
		ArrayList<User> rows = userdao.query(user,page);
		int total = userdao.count(user,page);
		doGet(request, response);
		
		HashMap<String, Object> mapReturn = new HashMap<String, Object>();
		mapReturn.put("rows",rows);
		mapReturn.put("total",total);
		String jsonStr = gson.toJson(mapReturn);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}




















