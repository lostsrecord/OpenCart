package utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData") //where the test will get the data for tests
	public String[][] getData() throws IOException {
		String path = "./testData/LoginData.xlsx"; //identifying source excel file
		
		ExcelUtility xluUtility = new ExcelUtility(path);
		int totalrows = xluUtility.getRowCount("Sheet1");
		int totalcols = xluUtility.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcols];
		
		for (int i=1;i<=totalrows; i++) {
			for (int j=0;j<totalcols; j++) {
				logindata[i-1][j]=xluUtility.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
