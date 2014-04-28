/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.NewHibernateUtil;
import Model.GenreAlbum;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;

/**
 *
 * @author Laura
 */
public class ExportServletStep1 extends HttpServlet {

    // JDBC driver name and database URL
      static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://192.168.10.100:3306/MyVibe";

      //  Database credentials
      static final String USER = "MyVibeApp";
      static final String PASS = "Fr0d0AndS@m";
    
    
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
       
        ArrayList<String> tablenames = new ArrayList<String>();
        //alle tabelnamen opvragen aan hibernate
        Map<String, ClassMetadata> m = NewHibernateUtil.getSessionFactory().getAllClassMetadata();
        /* iterate map*/
        for (Map.Entry<String, ClassMetadata> entry : m.entrySet())
        {
            AbstractEntityPersister aep = (AbstractEntityPersister) entry.getValue();
            String tableName = aep.getTableName();
            tablenames.add(tableName); 
        }
        
        request.setAttribute("tables", tablenames);
        request.getRequestDispatcher("export.jsp").forward(request, response);
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
        ArrayList<ArrayList<String>> tables = new ArrayList<ArrayList<String>>();
        Connection conn = null ;
        Statement stmt = null; 
            //alle properties van deze klasse opvragen aan hibernate
            ///komt die databank code
            try{
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");// Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                // Execute SQL query
                stmt = conn.createStatement();
                if(request.getParameter("MyVibe.GenreAlbum") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"GenreAlbum");
                    String sql;
                    sql = "SHOW COLUMNS FROM GenreAlbum;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Users") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Users");
                    String sql;
                    sql = "SHOW COLUMNS FROM Users;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("Admins") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Admins");
                    String sql;
                    sql = "SHOW COLUMNS FROM Admins;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Albums") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Albums");
                    String sql;
                    sql = "SHOW COLUMNS FROM Albums;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                
                if(request.getParameter("Artists") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Artists");
                    String sql;
                    sql = "SHOW COLUMNS FROM Artists;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("Listeners") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Listeners");
                    String sql;
                    sql = "SHOW COLUMNS FROM Listeners;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Orders") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Orders");
                    String sql;
                    sql = "SHOW COLUMNS FROM Orders;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Tracks") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Tracks");
                    String sql;
                    sql = "SHOW COLUMNS FROM Tracks;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Reviews") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Reviews");
                    String sql;
                    sql = "SHOW COLUMNS FROM Reviews;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                
                if(request.getParameter("MyVibe.OrderDetails") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"OrderDetails");
                    String sql;
                    sql = "SHOW COLUMNS FROM OrderDetails;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Genres") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Genres");
                    String sql;
                    sql = "SHOW COLUMNS FROM Genres;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                if(request.getParameter("MyVibe.Contracts") != null){
                    ArrayList<String> columns = new ArrayList<String>();
                    columns.add(0,"Contracts");
                    String sql;
                    sql = "SHOW COLUMNS FROM Contracts;";
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    while(rs.next()){
                        columns.add(rs.getString("Field"));  
                    }
                    // Clean-up environment
                    rs.close();
                    tables.add(columns);
                }
                stmt.close();
                conn.close();
            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                        conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }
            }//end finally try
         
             

        request.setAttribute("tables", tables); 
        request.getRequestDispatcher("export2.jsp").forward(request, response);
    }

   
}
