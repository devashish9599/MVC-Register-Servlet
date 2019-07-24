package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.modals.SubmitUser;
import com.mysql.cj.xdevapi.Statement;
import com.utils.ConnectionUts;

public class SubmitUserDAO {
	PreparedStatement pts = null;
	Statement statement = null;
	Connection connection = null;
	int resultSet = 0;
	
	public SubmitUserDAO() throws ClassNotFoundException, SQLException {
		connection = ConnectionUts.getConnection();
	}
	
	public boolean submit(SubmitUser user) throws SQLException {
		boolean existStatus = false;
		//SubmitUser submitUser = new SubmitUser();
		String sql = "INSERT INTO users(username, password) VALUES(?,?)";
		pts = connection.prepareStatement(sql);
		pts.setString(1,user.getUser());
		pts.setString(2, user.getPassword());
		resultSet = pts.executeUpdate();
		if(resultSet !=0) {
			existStatus= true;
		}
		return existStatus;
		}
}
