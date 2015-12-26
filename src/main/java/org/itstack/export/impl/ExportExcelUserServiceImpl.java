package org.itstack.export.impl;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.itstack.domain.bean.UserBean;
import org.itstack.export.ExportExcelService;

import java.util.List;

/**
 * Created by fuzhengwei on 2015/12/26.
 */
public class ExportExcelUserServiceImpl extends ExportExcelService<UserBean> {

    @Override
    public void doExcelCreateContent(Sheet sheet, List<UserBean> contentList) {
        for (UserBean userBean : contentList){
            Row rowContent = sheet.createRow(sheet.getLastRowNum() + 1);
            rowContent.createCell(0).setCellValue(new HSSFRichTextString(userBean.getProvice()));
            rowContent.createCell(1).setCellValue(new HSSFRichTextString(userBean.getCity()));
            rowContent.createCell(2).setCellValue(new HSSFRichTextString(userBean.getSchoolname()));
            rowContent.createCell(3).setCellValue(new HSSFRichTextString(userBean.getName()));
            rowContent.createCell(4).setCellValue(new HSSFRichTextString(userBean.getMobile()));
            rowContent.createCell(5).setCellValue(new HSSFRichTextString(userBean.getIdcard()));
        }
    }

}
