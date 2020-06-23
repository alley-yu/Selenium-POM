package com.crm.qa.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestExcel {
	public static void main(String[] args) throws IOException {
		Workbook wb = null;
		
        try  { //or new HSSFWorkbook();
        	wb = new XSSFWorkbook();
            CreationHelper creationHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");

            // Create a row and put some cells in it. Rows are 0 based.
            Row row = sheet.createRow((short) 0);
            // Create a cell and put a value in it.
            Cell cell = row.createCell((short) 0);
            cell.setCellValue(1);

            //numeric value
            row.createCell(1).setCellValue(1.2);

            //plain string value
            row.createCell(2).setCellValue("This is a string cell");

            //rich text string
            RichTextString str = creationHelper.createRichTextString("Apache3");
            Font font = wb.createFont();
            font.setItalic(true);
            font.setUnderline(Font.U_SINGLE);
            str.applyFont(font);
            row.createCell(3).setCellValue(str);

            //boolean value
            row.createCell(4).setCellValue(true);

            //formula
            row.createCell(5).setCellFormula("SUM(A1:B1)");

            //date
            CellStyle style = wb.createCellStyle();
            style.setDataFormat(creationHelper.createDataFormat().getFormat("m/d/yy h:mm"));
            cell = row.createCell(6);
            cell.setCellValue(new Date());
            cell.setCellStyle(style);

            //hyperlink
            row.createCell(7).setCellFormula("SUM(A1:B1)");
            cell.setCellFormula("HYPERLINK(\"http://google.com\",\"Google\")");

            //If there is no directory specified, the xls file will be created under the root of current project.
            wb.write(new FileOutputStream("ooxml-cell.xlsx"));
            
            // Write the output to a file
            //try (FileOutputStream fileOut = new FileOutputStream("ooxml-cell.xlsx")) {
               // wb.write(fileOut);
            //}
        } catch(Exception ext) {
        	
        	ext.printStackTrace();
        }
    }

}
