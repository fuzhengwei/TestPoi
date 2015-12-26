package org.itstack.export;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.itstack.domain.res.ExcelCreateWSRes;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fuzhengwei on 2015/12/26.
 */
public abstract class ExportExcelService<T> {

    /**
     * 创建工作簿
     *
     * @param rowAccessWindowSize
     * @param SheetName
     * @return
     */
    public ExcelCreateWSRes doExcelCreateWS(int rowAccessWindowSize, String SheetName) {
        ExcelCreateWSRes excelCreateWSRes = new ExcelCreateWSRes();
        Workbook workbook = new SXSSFWorkbook(rowAccessWindowSize);
        Sheet sheet = workbook.createSheet(SheetName);
        excelCreateWSRes.setWorkbook(workbook);
        excelCreateWSRes.setSheet(sheet);
        return excelCreateWSRes;
    }

    /**
     * 创建工作簿-表头信息
     *
     * @param sheet
     * @param headCells
     */
    public void doExcelCreateHead(Sheet sheet, String[] headCells) {
        Row rowHead = sheet.createRow(0);
        for (int i = 0; i < headCells.length; i++) {
            rowHead.createCell(i).setCellValue(new HSSFRichTextString(headCells[i]));
        }
    }

    /**
     * 泛型自己添加导出内容
     *
     * @param sheet
     * @param contentList
     */
    public abstract void doExcelCreateContent(Sheet sheet, List<T> contentList);

    /**
     * 创建excel导出文件
     *
     * @param workbook
     * @param fileUrl
     * @param fileName
     * @throws Exception
     */
    public void doExcelWriteFile(Workbook workbook, String fileUrl, String fileName) throws Exception {
        //校验文件夹
        File exportFile = new File(fileUrl);
        if (!exportFile.isDirectory()) {
            exportFile.mkdirs();
        }
        //校验文件
        File exportExcel = new File(fileUrl + "/" + fileName);
        if (!exportExcel.exists()) {
            exportExcel.createNewFile();
        }
        //创建写入流
        FileOutputStream out = new FileOutputStream(fileUrl + "/" + fileName, true);
        workbook.write(out);
        out.flush();
        out.close();
    }

    /**
     * 删除过期文件非今天的文件
     * @param fileUrl
     * @throws Exception
     */
    public void doExcelDelTemp(String fileUrl) throws Exception {
        //校验文件夹
        File tempFile = new File(fileUrl);
        if (tempFile.isDirectory()) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String nowDate = sf.format(new Date());
            File[] files = tempFile.listFiles();
            for (File file : files) {
                String tempFileDate = sf.format(file.lastModified());
                if (!nowDate.equals(tempFileDate)) {
                    file.delete();
                }
            }
        }
    }

}
