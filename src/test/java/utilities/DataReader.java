package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static List<Map<String, String>> getData(String filepath, String sheetName) throws IOException {
		
		List<Map<String, String>> data = new ArrayList<>();
		
		FileInputStream file = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFRow headerRow = sheet.getRow(0);
		int rows = sheet.getLastRowNum();
		for (int r = 1; r <= rows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			Map<String, String> currentRowData = new HashMap<>();
			for (int c = 0; c < currentRow.getLastCellNum(); c++) {
				String key = headerRow.getCell(c).getStringCellValue();
				String value = currentRow.getCell(c).getStringCellValue();
				currentRowData.put(key, value);
			}
			data.add(currentRowData);
		}
		file.close();
		wb.close();
		return data;
	}

}
