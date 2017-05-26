package CapstonesTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadXls {
	public void readXLSFile(String fileName) {
		InputStream ExcelFileToRead = null;
		HSSFWorkbook workbook = null;
		try {
			ExcelFileToRead = new FileInputStream(fileName);
			
			//Getting the workbook instance for xls file
			workbook = new HSSFWorkbook(ExcelFileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//getting the first sheet from the workbook using sheet name. 
		// We can also pass the index of the sheet which starts from '0'.
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		HSSFRow row;
		HSSFCell cell;
		
		//Iterating all the rows in the sheet
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();
			
			//Iterating all the cells of the current row
			Iterator cells = row.cellIterator();

			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue() + " ");
				} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue() + " ");
				} else { // //Here if require, we can also add below methods to
							// read the cell content
							// HSSFCell.CELL_TYPE_BLANK
							// HSSFCell.CELL_TYPE_FORMULA
							// HSSFCell.CELL_TYPE_ERROR
				}

			}
			System.out.println();
			try {
				ExcelFileToRead.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ReadXls readXls = new ReadXls();
		readXls.readXLSFile("W:\\ExcelSheet.xls");
	}
}