package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDao;
import dao.UserDao;
import vo.User;




@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public RegisterServlet() {
        super();

    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if ("adduser".equals(method)) {
            adduser(req, resp);
        }
    }


    public void adduser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");
        String povi = req.getParameter("name");
        String city = req.getParameter("stuname");

        //�����û�������
        User user = new User();
        //�����жϺ�������ֵ
        RegisterDao dao =new RegisterDao();
        boolean f=dao.add(user);
        //��ʾ��Ϣ
        if(f) {
            req.setAttribute("iofo", "ע��ɹ���");
            req.getRequestDispatcher("login.html").forward(req,resp);
        }
        else {
            req.setAttribute("info", "�����˺ţ��ظ���¼��");
            req.getRequestDispatcher("login.html").forward(req,resp);
        }
    }
}