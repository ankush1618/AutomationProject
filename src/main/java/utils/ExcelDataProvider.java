package main.java.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {


    @DataProvider(name="userData")
    public Object[][] userDataProvider() throws IOException {
        // Load Excel file from resources folder
        FileInputStream fis=new FileInputStream(new File("TestData_Sheet.xlsx"));
        //Read Workbook
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // Get the first sheet in the workbook
        Sheet sheet=wb.getSheetAt(0);
        //get the number of rows in the sheet
        int totalRows=sheet.getPhysicalNumberOfRows();
        int rowsNo=sheet.getLastRowNum()-sheet.getFirstRowNum();
        //get ColumnCount
        int totalCols=sheet.getRow(0).getPhysicalNumberOfCells();
        int totalColumns=sheet.getRow(0).getLastCellNum();
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        //Create 2 D array to store the Data
        Object [][] data=new Object[rowCount][columnCount];

        //loop through each row and column to fetch data

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); // Skip header row
            if (row != null) {
                Object[] rowData = new Object[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        if (cell.getCellType() == CellType.STRING) {
                            rowData[j] = cell.getStringCellValue();
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            rowData[j] = String.valueOf(cell.getNumericCellValue());
                        }
                    }
                }
                data[i] = rowData;
            }
        }
        wb.close();
        return data;
    }

//    @DataProvider(name="userDataHeaders")
//    public Object[][] userDataProviderWithHeaders() throws IOException {
//        // Load Excel file from resources folder
//        File file=new File("C:\\Users\\ankpal2\\OneDrive - Publicis Groupe\\Desktop\\AutomationFramework\\Framework_Ankush\\src\\main\\resources\\TestData_Sheet.xlsx");
//        // Create an input stream to read Excel file
//        FileInputStream inputStream = new FileInputStream(file);
//        //Read Workbook
//        Workbook wb=new XSSFWorkbook(inputStream);
//        // Get the first sheet in the workbook
//        Sheet sheet=wb.getSheetAt(0);
//        //get the number of rows in the sheet
//        int totalRows=sheet.getPhysicalNumberOfRows();
//        int rowsNo=sheet.getLastRowNum()-sheet.getFirstRowNum();
//        //get ColumnCount
//        int totalCols=sheet.getRow(0).getPhysicalNumberOfCells();
//        int totalColumns=sheet.getRow(0).getLastCellNum();
//
//        // Create a List to store the data
//        List<Map<String, String>> dataList = new ArrayList<>();
//
//        //loop through each row and column to fetch data
//        for(int i=0;i<totalRows;i++){
//            //Ignoring the first row
//            Row row=sheet.getRow(i+1);
//            // Create a Map to store column names and corresponding cell values
//            Map<String, String> rowData = new HashMap<>();
//            for(int j=0;j<totalColumns;j++){
//                // Fetch column name from header row
//                String colNames=sheet.getRow(0).getCell(j).getStringCellValue();
//                String values=row.getCell(j).getStringCellValue();
//                rowData.put(colNames,values);
//
//            }
//            // Add row data to the list
//            dataList.add(rowData);
//        }
//        //closing the workbook and input stream
//        wb.close();
//        inputStream.close();
//        //convert list to 2D array
//        Object[][] data=new Object[dataList.size()][1];
//        for(int i=0;i<dataList.size();i++){
//            data[i][0]=dataList.get(i);
//        }
//        return data;
//    }



}
