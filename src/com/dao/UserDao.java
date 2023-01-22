package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public boolean isPresent(String email) {

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? ");
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery(); // select
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

//			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateOtp(String email, String otp) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("update users set otp = ? , otptimestamp = now() where email = ? ");
			pstmt.setString(1, otp);
			pstmt.setString(2, email);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean verifyEmailAndOtp(String email , String otp) {

		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and otp = ? ");

			pstmt.setString(1, email);
			pstmt.setString(2, otp);

			ResultSet rs = pstmt.executeQuery(); // select
			if (rs.next()) {
				user = new UserBean();
				user.setEmail(email);
				user.setOtp(otp);
				user.setOtptimestamp(rs.getString("otptimestamp"));
			}

//			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
