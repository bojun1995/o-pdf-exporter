package com.bojun1995;

import com.spire.xls.*;

public class Main {
  public static void main(String[] args) {
    ExportUtil exportUtil = new ExportUtil();

    String jsonStr = "{\"companyName\":\"福能电厂\",\"stationName\":\"福能发电（#4烟气）\"}";

    Workbook workbook = exportUtil.doExportByTmplAndJson("./tmpl/gas.xlsx", jsonStr);

    workbook.saveToFile("./output/gas-out.pdf", FileFormat.PDF);
    workbook.saveToFile("./output/gas-out.xlsx", FileFormat.Version2016);

    System.out.println("done");
  }
}