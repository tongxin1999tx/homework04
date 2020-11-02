package controller;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import dao.DownloadDao;
import vo.Download;  
  

@WebServlet( urlPatterns = "/GetdownloadListController" )  
public class GetdownloadListController extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {  
    	DownloadDao dao = new DownloadDao();
    	ArrayList<Download> list = dao.query();
    	request.setAttribute("downloadlist", list);
    	RequestDispatcher rd = request.getRequestDispatcher("/download.jsp");
    	rd.forward(request, response);

    }  
  
}
