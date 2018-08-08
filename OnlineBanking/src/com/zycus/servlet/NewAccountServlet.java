package com.zycus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zycus.operations.AccountOperation;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/new-account.do")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String holderName = request.getParameter("holderName");
		String accountType = request.getParameter("accountType");
		
		PrintWriter out = response.getWriter();
		
		if(holderName == null || holderName.equals("")) {
			out.println("<h3> Please Enter Holder Name </h3>");
		}
		else {
			
			if(accountType == null || accountType.equals("Select")) {
				out.println("<h3> Please select a account type </h3>");
			}
			else {
				AccountOperation.createAccount(holderName, accountType);
				out.println("<h3> Account creation is in progress </h3>");
			}
		}
	}
}
