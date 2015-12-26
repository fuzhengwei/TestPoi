package org.itstack.domain.res;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by fuzhengwei on 2015/12/26.
 */
public class ExcelCreateWSRes {

    private Workbook workbook;
    private Sheet sheet;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }
}
