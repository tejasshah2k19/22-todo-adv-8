package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbConnection;

public class HomeServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"select count(*) as incompleted from todo where userId = ? and isCompleted = 0  ");
			pstmt.setInt(1, userId);
			ResultSet rsInComplete = pstmt.executeQuery(); // select -> output -> result

			rsInComplete.next();

			int inCompleted = rsInComplete.getInt("incompleted");

			PreparedStatement pstmt2 = con
					.prepareStatement("select count(*) as completed  from todo where userId = ? and isCompleted = 1  ");
			pstmt2.setInt(1, userId);
			ResultSet rsComplete = pstmt2.executeQuery(); // select -> output -> result

			rsComplete.next();
			int completed = rsComplete.getInt("completed");

			System.out.println(completed);
			System.out.println(inCompleted);

			System.out.println(rsInComplete.next());

			request.setAttribute("rsInComplete", inCompleted);
			request.setAttribute("rsComplete", completed);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

}
