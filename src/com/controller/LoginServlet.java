package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbConnection;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstName = rs.getString("firstName");
				
				HttpSession session = request.getSession(); // user ? 
				session.setAttribute("userId", rs.getInt("userId"));
				
				
				Cookie c = new Cookie("userName", firstName);
				response.addCookie(c);
				response.sendRedirect("HomeServlet");
			} else {
				request.setAttribute("error", "Invalid Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {

		}
	}

}
