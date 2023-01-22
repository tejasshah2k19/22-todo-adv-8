package com.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String otp = request.getParameter("otp");

		UserDao userDao = new UserDao();
		UserBean user = userDao.verifyEmailAndOtp(email, otp);

		if (user == null) {

		} else {
			LocalDateTime currentTime = LocalDateTime.now();

			LocalDateTime otpTime = LocalDateTime.parse(user.getOtptimestamp());

			long diff = Duration.between(currentTime, otpTime).getSeconds() / 60;
			if (diff >= 5) {
				// expired
			} else {
				// update
			}
		}

		// verify in db email - otp - timestamp
		// update -> password , ""

		// login

		// false -> REsetpassword.jsp

	}
}
