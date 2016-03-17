package servletclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.PDB;

public class BusinessServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PDB db = new PDB();
	  	ArrayList<HashMap<String,Object>> list = db.query("select * from business where usernumber=?", new String[]{request.getParameter("usernumber").toString()});
	  	request.setAttribute("list",list);
		request.getRequestDispatcher("2business.jsp").forward(request, response);
	}
}
