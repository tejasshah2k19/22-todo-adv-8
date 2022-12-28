package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbConnection;

@WebServlet("/AddToDoServlet")
public class AddToDoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String datetime = request.getParameter("datetime");

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into todo (title,description,datetime,isCompleted,userid) values (?,?,?,?,?)");
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setString(3, datetime);
			pstmt.setBoolean(4, false);
			pstmt.setInt(5, userId);

			pstmt.executeUpdate();

			
			response.sendRedirect("AddToDo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
