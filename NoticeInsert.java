package com.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/NoticeInsert")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("tit");
		String des = request.getParameter("desc");
		String phone = request.getParameter("cont");
		String email = request.getParameter("mail);
		String date = request.getParameter("dat");
		
		
boolean isTrue;
		
		isTrue = NoticeDBUtil.insertdetails(title, des, phone,email,date);
		
		if(isTrue == true) {
			String Title = request.getParameter("tit");

			
			isTrue = NoticeDBUtil.validate(Title);
			
			if (isTrue = true) {
				List<Notice> noticeDetails = NoticeDBUtil.getNotice(Title);
				request.setAttribute("noticeDetails",noticeDetails);
				
				RequestDispatcher dis = request.getRequestDispatcher("success2.jsp");
				dis.forward(request, response);
			} else {
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
			
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		

	}

}
