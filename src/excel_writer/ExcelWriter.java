package excel_writer;

import java.io.File;
import java.io.IOException;
import jxl.*;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.Number;
import sun.text.CollatorUtilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExcelWriter {
	
	public ExcelWriter() {
		
	};
	
	public void writeExcel(String directory) throws IOException, WriteException {
		try {
			 String fileName = directory + "\\report.xls";
			 WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
			 WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			 
			 //Create Formats
			 WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 16);
			 cellFont.setColour(Colour.BLACK);
			 cellFont.setBoldStyle(WritableFont.BOLD);
			 
			 WritableFont smallCellFont = new WritableFont(WritableFont.ARIAL, 12);
			 smallCellFont.setColour(Colour.BLACK);
			 smallCellFont.setBoldStyle(WritableFont.BOLD);
			 
			 // Cell Formats
			 WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			 cellFormat.setBackground(Colour.BLUE2);
			 
			 WritableCellFormat smallCellFormat = new WritableCellFormat(smallCellFont);
			 smallCellFormat.setBackground(Colour.BLUE2);
			 
			 //Add A Label
			 Label companyName = new Label(0, 0, "6 Eagle's Nest Inc.", cellFormat);
			 Label reportType = new Label(4, 0, "PURCHASE ORDER", cellFormat);
			 Label dateTodayLabel = new Label(4, 1, "Date: ");
			 Label dateToday = new Label(5, 1, getCurrDate());
			 Label POLabel = new Label(4, 2, "P. O. #:");
			 Label clientLabel = new Label(4, 3, "Client:");
			 
			 //Other Labels
			 Label itemColumn = new Label(0, 8, "ITEM", smallCellFormat);
			 Label description = new Label(1, 8, "DESCRIPTION", smallCellFormat);
			 Label qty = new Label(2, 8, "QTY.", smallCellFormat);
			 
			 sheet.addCell(companyName);
			 sheet.addCell(new Label(1, 0, "", cellFormat));
			 sheet.addCell(new Label(2, 0, "", cellFormat));
			 sheet.addCell(new Label(3, 0, "", cellFormat));
			 sheet.addCell(new Label(5, 0, "", cellFormat));
			 sheet.addCell(new Label(6, 0, "", cellFormat));
			 sheet.addCell(reportType);
			 sheet.addCell(dateTodayLabel);
			 sheet.addCell(dateToday);
			 sheet.addCell(POLabel);
			 sheet.addCell(clientLabel);
			 
			 System.out.println(fileName);
			 
			 workbook.write();
			 
			 workbook.close();
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getCurrDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		return localDate.toString();
	}
	
}
