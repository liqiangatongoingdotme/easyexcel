package me.ongoing;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        InputStream in = App.class.getResourceAsStream("/test.xls");

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(in);

            HSSFSheet sheet = workbook.getSheet("蓝光3个大屏指标集合");





            System.out.println(sheet.getRow(0).getCell(0));




        } catch (IOException e) {
            e.printStackTrace();
        }










    }
}
