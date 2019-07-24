package com.service;

import java.sql.SQLException;

import com.DAO.SubmitUserDAO;
import com.modals.SubmitUser;

public class SubmitToDb {
	SubmitUserDAO  dao = null;
	public SubmitToDb(SubmitUserDAO dao) {
		this.dao=dao;
		}
	
	public boolean register(SubmitUser submitUser) throws SQLException {
		boolean status = true;
		if(!dao.submit(submitUser)) {
			status=false;
		}
		return status;
		
		
	}

}
