/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.ExportGenerators.GenerateCsv;
import Controller.ExportGenerators.GeneratePdf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laura
 */
public class ExportServletStep3 extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("application/csv");
        PrintWriter w = response.getWriter();

        ArrayList<String[]> temp_table = (ArrayList<String[]> )request.getAttribute("temp_table"); 
       
        w.println(GenerateCsv.generateCsvFile(temp_table));

        w.flush();
        w.close();*/
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("csv") != null){
            response.setContentType("application/csv");
            response.setHeader("content-disposition","filename=export.csv"); // set the file name to whatever required..
            PrintWriter w = response.getWriter();
        
            ArrayList<String[]> temp_table = (ArrayList<String[]> )request.getSession().getAttribute("temp_table"); 
       
            w.println(GenerateCsv.generateCsvFile(temp_table));

            w.flush();
            w.close();
        }else if(request.getParameter("pdf") != null){
            response.setContentType("application/pdf");
            response.setHeader("content-disposition","filename=export.pdf"); 
            ArrayList<String[]> temp_table = (ArrayList<String[]> )request.getSession().getAttribute("temp_table"); 
            GeneratePdf.generatePdfFile(temp_table);
            //InputStream in = ... // depends where you store your file 
            InputStream in = new FileInputStream(new File("export.pdf")); 
            ServletOutputStream out = response.getOutputStream();
            byte[] buffer = new byte[4096];
            while(in.read(buffer, 0, 4096) != -1)
            out.write(buffer, 0, 4096);
            in.close();
            out.flush();
            out.close();
        }
        
    }
    
}
