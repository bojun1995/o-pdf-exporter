package com.bojun1995;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;

public class HeaderFooterHelper extends PdfPageEventHelper {
  //一页加载完成触发，写入页眉和页脚
  public void onEndPage(PdfWriter writer, Document document) {
    Font cnFont = null;
    try {
      cnFont = new ExportUtil().getCnFont();
    } catch (DocumentException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //生成左侧页眉
    ColumnText.showTextAligned(writer.getDirectContent(),
      Element.ALIGN_LEFT, new Paragraph("左页眉", cnFont),
      document.left(), PageSize.A4.getHeight() - 30, 0);

    //生成右侧页眉
    ColumnText.showTextAligned(writer.getDirectContent(),
      Element.ALIGN_RIGHT, new Paragraph("右页眉", cnFont),
      document.right(), PageSize.A4.getHeight() - 30, 0);

    //生成左侧页脚
    ColumnText.showTextAligned(writer.getDirectContent(),
      Element.ALIGN_LEFT, new Paragraph("左页脚", cnFont),
      document.left(), 20, 0);

    //生成右侧页脚
    ColumnText.showTextAligned(writer.getDirectContent(),
      Element.ALIGN_RIGHT, new Paragraph("右页脚", cnFont),
      document.right(), 20, 0);

  }

}
