package com.example.excelandpdf.controller;

import com.example.excelandpdf.model.Invoice;
import com.example.excelandpdf.view.ExcelUserListReportView;
import com.example.excelandpdf.view.PdfUserListReportView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class ReportController {

    @RequestMapping(value="/report", method=RequestMethod.GET)
    public ModelAndView userListReport(HttpServletRequest req, HttpServletResponse res){

        String typeReport = req.getParameter("type");

        List<Invoice> list = new ArrayList<Invoice>();
        list.add(new Invoice(1, "username 1", "First name 1", 21));
        list.add(new Invoice(2, "username 2", "First name 2", 22));
        list.add(new Invoice(3, "username 3", "First name 3", 23));
        list.add(new Invoice(4, "username 4", "First name 4", 24));
        list.add(new Invoice(5, "username 5", "First name 5", 25));

        if(typeReport != null && typeReport.equals("xls")){
            return new ModelAndView(new ExcelUserListReportView(), "userList", list);
        } else if(typeReport != null && typeReport.equals("pdf")) {
            return new ModelAndView(new PdfUserListReportView(), "userList", list);
        }
        return new ModelAndView("userListReport", "userList", list);
    }
}
