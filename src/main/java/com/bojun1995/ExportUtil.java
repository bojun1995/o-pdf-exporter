package com.bojun1995;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spire.xls.CellRange;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.util.ArrayList;
import java.util.Map;

public class ExportUtil {

  public Workbook doExportByTmplAndJson(String tmplUrl, String jsonStr) {
    Map<String, Object> parsedJsonObj = (Map<String, Object>) JSON.parse(jsonStr);

    // 加载模板excel
    Workbook workbook = new Workbook();
    workbook.loadFromFile(tmplUrl);

    // 只获取第1页sheet
    Worksheet sheet = workbook.getWorksheets().get(0);

    // 行
    CellRange[] rows = sheet.getRows();
    for (int i = 0; i < rows.length; i++) {
      CellRange cell = rows[i];

      // 列
      ArrayList<CellRange> cellList = cell.getCellList();
      cellList.forEach(cellRange -> {
        // 单元格
        String cellValue = cellRange.getValue();
        if (cellValue.contains("{\"excel-export-util$\":")) {
          // 读取配置
          Map<String, JSONObject> cellConfig = (Map<String, JSONObject>) JSON.parse(cellValue);
          JSONObject config = cellConfig.get("excel-export-util$");

          // Cell配置
          String cellType = (String) config.get("type");
          String valueKey = (String) config.get("valueKey");

          // String
          if ("String".equals(cellType)) {
            String realVal = (String) parsedJsonObj.get(valueKey);
            System.out.println(realVal);
            cellRange.setValue(realVal);
          }

        }
      });
    }

    // 宽度自适应
    workbook.getConverterSetting().setSheetFitToWidth(true);

    return workbook;
  }
}
