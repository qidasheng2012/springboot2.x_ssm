package com.springboot.ssm.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel工具类
 */
public class ExcelUtils {

    /**
     * 导出(07版.xlsx)Excel到指定路径下
     *
     * @param path      路径
     * @param excelName Excel名称
     * @param sheetName sheet页名称
     * @param clazz     Excel要转换的类型
     * @param data      要导出的数据
     */
    public static void export4File(String path, String excelName, String sheetName, Class clazz, List data) {
        String fileName = path.concat(excelName).concat(ExcelTypeEnum.XLSX.getValue());
        EasyExcel.write(fileName, clazz).sheet(sheetName).doWrite(data);
    }

    /**
     * 导出(07版.xlsx)Excel到web
     *
     * @param response  响应
     * @param excelName Excel名称
     * @param sheetName sheet页名称
     * @param clazz     Excel要转换的类型
     * @param data      要导出的数据
     * @throws Exception
     */
    public static void export4Web(HttpServletResponse response, String excelName, String sheetName, Class clazz, List data) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(excelName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ExcelTypeEnum.XLSX.getValue());
        EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(data);
    }

}
