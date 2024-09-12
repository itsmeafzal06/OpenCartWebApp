package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DDTUtility {
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{

		String path = ".\\testData\\loginCreds.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);
		int totalrow=xlUtil.getRowCount("Sheet1");
		int totalcell=xlUtil.getCellCount("Sheet1", totalrow);
		
		String loginData[][]= new String[totalrow][totalcell];
		for(int r=1;r<=totalrow;r++) {
			for(int c=0;c<totalcell;c++) {
				loginData[r-1][c]=xlUtil.getCellData("Sheet1", r, c);
			}
			
		}
		return loginData;
	}

}
