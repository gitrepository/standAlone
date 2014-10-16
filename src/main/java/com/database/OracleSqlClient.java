package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleSqlClient {

	public static void main(String[] args) {
		Connection sCon = DBUtil.getSQLServerConnection();
		Connection oCon = DBUtil.getOrcaleServerConnection();
		
		cmisFunctionality(oCon, sCon);
	}

	private static void cmisFunctionality(Connection oCon, Connection sCon){

		String cc = ""+
		"select ct.CONTRACT_NUMBER, cs.name, ct.STATUS "+
		"from CONTRACT ct "+
		"Left join consultant cs "+
		"on cs.CONSULTANT_ID = ct.PRIME_CONSULTANT_ID "+
		"where cs.name is not null "+
		"order by cs.name, ct.CONTRACT_NUMBER ";

		String cplVendor = ""+
		"select ct.CONTRACT_ID, v.PSFT_VENDOR_CODE, v.VENDOR_NAME "+
		"from CONTRACT ct "+
		"left join VENDOR v "+
		"on ct.VENDOR_ID = v.VENDOR_ID "+
		"where ct.CONTRACT_ID = ? ";

		
		PreparedStatement ccPS;
		try {
			ccPS = oCon.prepareStatement(cc);
			ResultSet ccRS = ccPS.executeQuery();
			String currentVendor = "1";
			String prevVendor = "2";
			while(ccRS.next()){
				currentVendor = ccRS.getString(2);
				if(!currentVendor.equals(prevVendor)){
					PreparedStatement cplVendorPS = sCon.prepareStatement(cplVendor);
					cplVendorPS.setString(1, ccRS.getString(1));
					ResultSet cplVendorRS = cplVendorPS.executeQuery();
					boolean cplContractExists = false;
					while(cplVendorRS.next()){
						cplContractExists = true;
					}
					if(!cplContractExists){
						System.out.println("### CPL CONTRACT DOESNT EXIST FOR "+ccRS.getString(1)+" STATUS "+ccRS.getString(3));
					}
					prevVendor = currentVendor;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
