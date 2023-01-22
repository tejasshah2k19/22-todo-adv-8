package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.util.Mailer;
import com.util.OtpGenerator;

public class ForgetPassowrdServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		UserDao userDao = new UserDao();
		if (userDao.isPresent(email)) {
			System.out.println("doOtp");
			String otp = OtpGenerator.generateOtp(6);
			userDao.updateOtp(email, otp);//ram@gmail.com , 2653233
			//setOtp is users account with datetime 
			//sendMail
			//javax mail 
			Mailer.sendOtpForForgetPassword(email, otp);
			
		}

 	response.sendRedirect("ResetPassword.jsp");
	}

}
