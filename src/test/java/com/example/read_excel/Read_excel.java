package com.example.read_excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Read_excel {
    public static String [][]read_sheet() throws IOException, InvalidFormatException {
        File myfile=new File(".\\Data\\data.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(myfile);
        XSSFSheet mysheetwork=wb.getSheet("user");
        int rows=mysheetwork.getPhysicalNumberOfRows();
        int columns=mysheetwork.getRow(0).getLastCellNum();
        String [][]myarray=new String[rows-1][columns];
        for(int i=1;i<rows;i++){
            for (int k=0;k<columns;k++){
                XSSFRow row=mysheetwork.getRow(i);
                myarray[i-1][k]=String.valueOf(row.getCell(k));
            }
        }
        return myarray;
    }
}
