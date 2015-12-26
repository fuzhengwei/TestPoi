package org.itstack.main;

import org.itstack.domain.bean.UserBean;
import org.itstack.domain.res.ExcelCreateWSRes;
import org.itstack.export.ExportExcelService;
import org.itstack.export.impl.ExportExcelUserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzhengwei on 2015/12/26.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //0、开始时间
        Long start = System.currentTimeMillis();

        ExportExcelService exportExcelService = new ExportExcelUserServiceImpl();
        //1、创建工作簿
        ExcelCreateWSRes excelCreateWSRes = exportExcelService.doExcelCreateWS(125, "人员信息");
        //2、创建工作簿-表头信息
        String[] headCells = {"省份", "城市", "学校", "姓名", "手机号", "身份证号"};
        exportExcelService.doExcelCreateHead(excelCreateWSRes.getSheet(), headCells);
        //3、添加导出内容
        for (int limit = 0; limit < 10; limit++) {
            List<UserBean> userList = new ArrayList<UserBean>();
            for (int count = 0; count < 50000; count++) {
                UserBean userBean = new UserBean();
                userBean.setProvice("北京");
                userBean.setCity("北京");
                userBean.setSchoolname("北京大学");
                userBean.setName("李" + count + "狗");
                userBean.setMobile("13521408888");
                userBean.setIdcard("220182201512261235");
                userList.add(userBean);
            }
            exportExcelService.doExcelCreateContent(excelCreateWSRes.getSheet(), userList);
        }
        //4、创建excel导出文件
        exportExcelService.doExcelWriteFile(excelCreateWSRes.getWorkbook(), "E://export", "usertable.xls");
        //5、删除过期文件非今天的文件
        exportExcelService.doExcelDelTemp("E://export");

        //6、结束时间
        Long end = System.currentTimeMillis();

        System.out.println("开始时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(start));
        System.out.println("完成时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS").format(end));
    }

}
