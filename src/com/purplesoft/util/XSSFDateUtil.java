package com.purplesoft.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class XSSFDateUtil extends DateUtil {  
    protected static int absoluteDay(Calendar cal, boolean use1904windowing) {  
        return DateUtil.absoluteDay(cal, use1904windowing);  
    }
    
    public static String getStringCellValue(Cell cell) {  
        String strCell = "";  
        switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_STRING:  
                strCell = cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_NUMERIC:  
                if (XSSFDateUtil.isCellDateFormatted(cell)) {  
                    //  如果是date类型则 ，获取该cell的date值  
                    strCell = new SimpleDateFormat("yyyy-MM-dd").format(XSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
                } else { // 纯数字  
                    strCell = String.valueOf(cell.getNumericCellValue());  
                }  
                    break;  
            case Cell.CELL_TYPE_BOOLEAN:  
                strCell = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_BLANK:  
                strCell = "";  
                break;  
            default:  
                strCell = "";  
                break;  
        }  
        if (strCell.equals("") || strCell == null) {  
            return "";  
        }  
        if (cell == null) {  
            return "";  
        }  
        return strCell;  
    } 
}  
