package com.bojun1995;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

import java.io.IOException;

public class WorkbookExporter {

  private Font getCnFont() throws DocumentException, IOException {
    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    return new Font(bfChinese);
  }


}
