/*	
 * @(#)removeString.java     1.0 @2013-3-19		
 * 		
 * Copyright (c) 2010 SHANGHAI BINGKUN DIGITAL TECHNOLOGY CO.,LTD		
 * All rights reserved		
 * 		
 * This software is the confidential and proprietary information of 		
 * SHANGHAI BINGKUN.("Confidential Information").  You shall not		
 * disclose such Confidential Information and shall use it only in		
 * accordance with the terms of the license agreement you entered into		
 * with SHANGHAI BINGKUN.		
 */

/**
 *
 * 说明：
 *
 * @author jijw
 *
 * @version  2013-3-19
 */
public class removeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "13:30:05";
		String ss = s.replaceAll(":","");
		System.out.println(s);
		System.out.println(ss);
	}

}
