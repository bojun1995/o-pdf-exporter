package com.bojun1995;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExportUtil {

  public Font getCnFont() throws DocumentException, IOException {
    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    return new Font(bfChinese);
  }

  public void getConfigByExcelTmpl(String tmplPath) {
    try {
      XSSFWorkbook templateFile = new XSSFWorkbook(new FileInputStream(new File(tmplPath)));
      XSSFSheet sheet = templateFile.getSheetAt(0);
      Iterator<Row> rowIterator = sheet.rowIterator();
      while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          System.out.println(cell);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void doExport() throws IOException, DocumentException {
    getConfigByExcelTmpl("./template/template.xlsx");

//    Document document = new Document(PageSize.A4, 20, 20, 100, 40);
//    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./output/export.pdf"));
//    writer.setPageEvent(new HeaderFooterHelper());
//
//    document.open();
//
//    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//    Font cnFont = new Font(bfChinese);
//
//    PdfPTable table = new PdfPTable(3);
//    table.setWidthPercentage(100); // 宽度100%填充
//
//    List<PdfPRow> listRow = table.getRows();
//    //设置列宽
//    float[] columnWidths = {1f, 2f, 3f};
//    table.setWidths(columnWidths);
//
//    //行1
//    PdfPCell cells1[] = new PdfPCell[3];
//    PdfPRow row1 = new PdfPRow(cells1);
//
//    //单元格
//    cells1[0] = new PdfPCell(new Paragraph("第一列", cnFont));//单元格内容
//    cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//    cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//
//    cells1[1] = new PdfPCell(new Paragraph("222", cnFont));
//    cells1[2] = new PdfPCell(new Paragraph("333"));
//
//    //把第一行添加到集合
//    for (int i = 0; i < 100; i++) {
//      listRow.add(row1);
//    }
//
//    //把表格添加到文件中
//    document.add(table);
//    //关闭文档
//    document.close();
//    //关闭书写器
//    writer.close();

  }

}
