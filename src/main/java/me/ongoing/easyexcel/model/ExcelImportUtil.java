package me.ongoing.easyexcel.model;


import me.ongoing.App;
import me.ongoing.Kpis;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class ExcelImportUtil {



   public static <T> List<T> importExcel(File f, Class<?> clazz, ExcelParam rowCount)
   {

       List<T> result = new ArrayList<T>();

       FileInputStream in = null;

       HSSFWorkbook workbook = null;

       try {

           in = new FileInputStream(f);

           workbook = new HSSFWorkbook(in);

           HSSFSheet sheet = workbook.getSheet("蓝光3个大屏指标集合");


           Map<Integer,String> titleMap = getTitleMap(sheet,rowCount);

           Map<String,ExcelEntity> metaDataMap = getClassMetaData(clazz);



          for(int i=rowCount.getBeginRow();i<rowCount.getEndRow();i++)
          {

              T t = (T) clazz.newInstance();




              Row row = sheet.getRow(i);


              for (int j = row.getFirstCellNum(), le = row.getLastCellNum(); j < le; j++)
              {
                  int index  = j;

                  Cell cell = row.getCell(j);

                  if(cell!=null)
                  {
                      String value = cell.toString();

                      String title =titleMap.get(index);

                      ExcelEntity entity = metaDataMap.get(title);

                      if(entity==null)
                      {
                          continue;
                      }
                      String fieldName = entity.getFieldName();

                      System.out.println(entity);

                      PropertyDescriptor p = new PropertyDescriptor(fieldName,clazz);

                      Method method = p.getWriteMethod();

                      method.invoke(t,value);



                  }







              }
              result.add(t);

              System.out.println();

          }



           /*Iterator<Row> rows = sheet.iterator();

           Row row = null;

           int count =0;

           while (rows.hasNext() && row == null || count<rowCount.getEndRow())
           {

               row = rows.next();


               for (int i = row.getFirstCellNum(), le = row.getLastCellNum(); i < le; i++)
               {
                   int index  = i;

                   Cell cell = row.getCell(i);





                  // System.out.print(index+" "+row.getCell(i)+" ||");

               }

               System.out.println();

               count++;
           }*/



       // System.out.print(result);

       } catch (IOException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (IntrospectionException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       } finally {

           try {
               workbook.close();
               in.close();
           } catch (IOException e) {
               e.printStackTrace();
           }


       }






        return result;


   }

    private static Map<Integer,String> getTitleMap(HSSFSheet sheet, ExcelParam rowCount) {
//{0=序号, 1=  , 2=指标名称, 3=模板, 4=单位, 5=需用户提供？, 6=指标规则, 7=指标值举例, 8=时间维度, 9=空间维度, 10=其他维度}
        Map<Integer,String> result = new HashMap<Integer,String>();

        Row titleRow = sheet.getRow(rowCount.getTitleRowNum());

        for(int i=0;i<titleRow.getLastCellNum();i++)
        {

            Cell cell = titleRow.getCell(i);

            if(cell!=null)
            {

                String cellString = cell.toString().replace("\\s+","");

                if(cellString!="")
                {

                    result.put(cell.getColumnIndex(),cell.toString());

                }


            }



        }


        System.out.println(result);


        return result;


    }


    public static Map<String,ExcelEntity> getClassMetaData(Class clazz)
   {

       Map<String,ExcelEntity> result = new HashMap<String,ExcelEntity>();

       Field[] fields = clazz.getDeclaredFields();


       for(Field f:fields)
       {
           ExcelEntity entity = new ExcelEntity();
           Annotation[] annotations = f.getDeclaredAnnotations();
           Excel excel = (Excel)annotations[0];
           entity.setName(excel.name());
           entity.setExportFormat(excel.exportFormat());
           entity.setFieldName(f.getName());
           result.put(excel.name(),entity);

       }

       return result;

   }




    public static void setProperty(Object obj,String propertyName,Class value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        PropertyDescriptor pd = new PropertyDescriptor(propertyName,obj.getClass());

        Method setMethod = pd.getWriteMethod();

        setMethod.invoke(obj, new Object[]{value});


    }




    public static void main(String[] args) {



    //System.out.println(getClassMetaData(Kpis.class));

        URL url =  App.class.getResource("/test.xls");



       List<Kpis> list =  ExcelImportUtil.importExcel(new File(url.getFile()), Kpis.class,new ExcelParam(0,1,94));


       System.out.println(list.get(0));







    }


}
