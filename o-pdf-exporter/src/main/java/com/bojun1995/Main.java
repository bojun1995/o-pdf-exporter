package com.bojun1995;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
  public static void main(String[] args) throws Exception {
    ExportUtil exportUtil = new ExportUtil();
    try {
      XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("./template/template.xlsx"));
      FileOutputStream out = new FileOutputStream("./output/template-out.xlsx");
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}