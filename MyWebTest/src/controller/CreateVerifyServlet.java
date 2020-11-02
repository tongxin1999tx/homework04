package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateVerify;

@WebServlet(urlPatterns ="/servlet/CreateVerify")
public class CreateVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateVerifyServlet() {
    	super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CreateVerify createVCodeImage  = new CreateVerify();
		String vCode = createVCodeImage.createCode();
		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", vCode);
		response.setContentType("img/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setDateHeader("Expires", 0);
		BufferedImage image = createVCodeImage.CreateImage(vCode);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
//		System.out.println("-----------------------"+vCode);
	}

}
