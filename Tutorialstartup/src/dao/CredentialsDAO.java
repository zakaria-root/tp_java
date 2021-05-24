package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.credentialsC;
import tools.MySqlConnection;

public class CredentialsDAO {
	public static credentialsC checkcrdentials(String l, String p) {
		credentialsC res = new credentialsC();
		String sql = "select * from logins where login =? and password =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySqlConnection.getconnectionmysql();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, l);
			ps.setString(2, p);
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur avec PS");
		}
		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				res.setIdcredential(rs.getInt(1));
				res.setLogin(rs.getString(2));
				res.setPassword(rs.getString(3));
				res.setIdemp(rs.getInt(4));
				res.setRole(rs.getString(5));
			} else
				return null;
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur avec RS");

			return null;
		}
		return res;
	}
	
	public static List<credentialsC> allCrdentials() {	
		List<credentialsC> ares = new ArrayList<credentialsC>();
		String sql = "select * from logins";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySqlConnection.getconnectionmysql();
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				credentialsC res = new credentialsC();
				res.setIdcredential(rs.getInt(1));
				res.setLogin(rs.getString(2));
				res.setPassword(rs.getString(3));
				res.setIdemp(rs.getInt(4));
				res.setRole(rs.getString(5));
				ares.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ares;
	
	}
	
	public static int deleteCrdentials(int id) {
		int nb=0;
	String sql = "delete from logins where id = ?";
	PreparedStatement ps = null;
	Connection con = MySqlConnection.getconnectionmysql();
	try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		nb = ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nb;
	
	}
}
