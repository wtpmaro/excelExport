package com.example.excelandpdf.view;

import com.example.excelandpdf.model.Invoice;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelUserListReportView extends AbstractXlsView {


    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");

        @SuppressWarnings("unchecked")
        List<Invoice> list = (List<Invoice>) model.get("userList");

        Sheet sheet = workbook.createSheet("User List");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("First Name");
        header.createCell(2).setCellValue("Surname");
        header.createCell(3).setCellValue("Age");

        int rowNum = 1;

        for (Invoice user : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getSurname());
            row.createCell(3).setCellValue(user.getAge());
        }

    }
}

