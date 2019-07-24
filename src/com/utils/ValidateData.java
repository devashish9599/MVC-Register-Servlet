package com.utils;

import java.util.ArrayList;
import java.util.List;

public class ValidateData {
	
	public static List<String> erMsg = null;
	
	public static boolean isValidate(String ...params) {
		erMsg = new ArrayList<String>();
		boolean isvalid = true;
		for (int i= 0; i < params.length; i++) {
			if(params[i].trim().equals("")) {
				erMsg.add("fields can not be left empty");
				isvalid = false;
			}
		}
		return isvalid;
		}
}

