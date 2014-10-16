package com.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InputStream myxls = new FileInputStream("fastHire.xls");
			HSSFWorkbook wb = new HSSFWorkbook(myxls);

			HSSFSheet sheet = wb.getSheetAt(1);       // first sheet
			HSSFRow row     = sheet.getRow(0);        // third row
			HSSFCell cell   = row.getCell((short)0);  // fourth cell
			
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://GDOT-GOVSQL01:1932;databaseName=fasthire", "fasthireuser", "fasthireuser01");
			System.out.println("connected");
			
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				System.out.println("The Cell was a String with value " + cell.getStringCellValue());
				String[] strArray = StringUtils.split(cell.getStringCellValue(), ',');
				System.out.println(strArray[0]+"*"+strArray[1]);
				
//				PreparedStatement stmt = conn.prepareStatement("select count(*) from users where LastName like ?");
//				stmt.setString(1, strArray[0]+"%");
//				ResultSet rs = stmt.executeQuery();
				
			} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				System.out.println("The cell was a number " + cell.getStringCellValue());
			} else {
				System.out.println("The cell was nothing we're interested in");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
