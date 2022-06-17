package com.bojun1995;

public class Main {
  public static void main(String[] args) throws Exception {
    ExportUtil exportUtil = new ExportUtil();
    try {
      exportUtil.doExport();
//      System.out.println('1');
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}