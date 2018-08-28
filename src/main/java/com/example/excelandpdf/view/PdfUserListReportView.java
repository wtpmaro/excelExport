package com.example.excelandpdf.view;

import com.example.excelandpdf.model.Invoice;

import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PdfUserListReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        final String FOX = "src/main/resources/img/fox.bmp";
        response.setHeader("Content-Disposition", "attachment; filename=\"user_list.pdf\"");

        @SuppressWarnings("unchecked")
        List<Invoice> list = (List<Invoice>) model.get("userList");

        
        document.add(new Paragraph("User List"));
        Table table = new Table(4);
/*
        table.addCell(String.format("Page %d of", writer.getPageNumber()));
*/

        table.addCell("Id");
        table.addCell("First name");
        table.addCell("Surname");
        table.addCell("Age");

        for(Invoice user : list){
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getName());
            table.addCell(user.getSurname());
            table.addCell(String.valueOf(user.getAge()));
        }

        document.add(table);
    }

}
