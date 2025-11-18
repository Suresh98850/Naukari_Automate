package TestNGFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class gettingDataFromExcel {
	
	
	//identify testcases coloumn in the sheet
	@DataProvider
	public List givedata() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Suresh Bathula\\Desktop\\productiondata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		ArrayList<String> a =new  ArrayList<>();
		int sheetcount=wb.getNumberOfSheets();
		for(int i=0;i<sheetcount;i++) {
			if(wb.getSheetName(i).equalsIgnoreCase("prodData")) {
				XSSFSheet sheet=wb.getSheetAt(i);
				Iterator<Row>row=sheet.iterator();
				Row firstrow=row.next();
				Iterator<org.apache.poi.ss.usermodel.Cell>cel=firstrow.cellIterator();
				int k=0;
				int colom=0;
				while(cel.hasNext()) {
					if(cel.next().getStringCellValue().equalsIgnoreCase("Users")){
						colom=k;
						
					}
					k++;
				}
				System.out.println(colom);
				while(row.hasNext()) {
					Row r=row.next();
					if(r.getCell(colom).getStringCellValue().equalsIgnoreCase("Suresh1")) {
						Iterator<org.apache.poi.ss.usermodel.Cell>cv=r.cellIterator();
						while(cv.hasNext()) {
							a.add(cv.next().getStringCellValue());
						}
					}
					
				}
			}
		}
		return a;
	}
	
	@Test(dataProvider="givedata")
	public void takingdata(String b) {
		
		System.out.println(b);
		
	}
	
	
}
