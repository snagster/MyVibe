/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import static Controller.Servlets.ExportServletStep1.DB_URL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laura
 */
public class ExportServletStep2 extends HttpServlet {
    
      // JDBC driver name and database URL
      static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://snagster.no-ip.biz:3306/MyVibe";

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
        //processRequest(request, response);
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
        Connection conn = null ;
        Statement stmt = null; 
        int aantalCheckboxes = Integer.parseInt(request.getParameter("aantal"));
        //fields = (String []) request.getAttribute("chk_group[]");
        ArrayList<String> fields = new ArrayList<String>();
        for(int i = 0; i < aantalCheckboxes; i ++){
            if(request.getParameter(Integer.toString(i)) != null){
                fields.add(request.getParameter(Integer.toString(i))); 
            }
        }
            try{
                Class.forName("com.mysql.jdbc.Driver");// Open a connection
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                // Execute SQL query
                stmt = conn.createStatement();
                // create temptable
                stmt.executeUpdate("DROP TABLE IF EXISTS  temp_table;");
                stmt.executeUpdate("CREATE TABLE temp_table as " +
                        "SELECT Allowed, UserFullName, UserBirthDate,Users.UserID, AlbumRestricted, AlbumVerified, Albums.ArtistID, AlbumPrice, AlbumYear, AlbumName, Albums.AlbumID, " +
                        "SinceDate, Contracts.ContractID, ArtistContactNumer, ArtistRegDate, ArtistName, ContractBeginDate, ContractEndDate, ContractPrice, Genres.GenreID, " +
                        "GenreAlbumID, GenreName, ListenerBirthDate, Credits, ListenerFullName, OrderDetailID, Orders.OrderID, Tracks.TrackID, Reviews.ListenerID, ReviewID, " +
                        "TrackName, " +
                        "Username, " +
                        "UserPassword, " +
                        "UserRegDate, " +
                        "UserEmail " +
                        "FROM Users LEFT JOIN Admins ON Users.UserID = Admins.UserID LEFT JOIN Artists ON Users.UserID = Artists.UserID LEFT JOIN Listeners ON Users.UserID = Listeners.UserID " +
                        "LEFT JOIN Contracts ON Artists.UserID = Contracts.ArtistID LEFT JOIN Albums ON Artists.UserID = Albums.ArtistID LEFT JOIN Tracks ON Albums.AlbumID = Tracks.AlbumID LEFT JOIN Orders ON Listeners.UserID = Orders.ListenerID " +
                        "LEFT JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID " +
                        "LEFT JOIN GenreAlbum On Albums.AlbumID = GenreAlbum.AlbumID " +
                        "LEFT JOIN Genres ON GenreAlbum.GenreID = Genres.GenreID " +
                        "LEFT JOIN Reviews ON Listeners.UserID = Reviews.ListenerID; " )  ;
                
                        
                    String sql = "SELECT ";
                    for(int i = 0; i < fields.size(); i ++){
                        sql += fields.get(i);
                        if(i != fields.size()-1){
                            sql+=", "; 
                        }
                    }
                    sql +=" FROM temp_table WHERE ";
                    for(int i = 0; i < fields.size(); i ++){
                        sql += fields.get(i) + " IS NOT NULL ";
                        if(i == fields.size()-1){
                            sql+=";"; 
                        }else{
                            sql+="AND "; 
                        }
                    }
                    ResultSet rs = stmt.executeQuery(sql);

                    // Extract data from result set
                    ArrayList <String[]> table_temp= new ArrayList<String[]>();
                    String [] tableheads = new String [aantalCheckboxes];
                    for(int i = 0; i < fields.size(); i ++){
                            tableheads[i] = fields.get(i);
                    }
                    table_temp.add(tableheads); 
                    while(rs.next()){
                        String [] record = new String[aantalCheckboxes]; 
                        for(int i = 0; i < fields.size(); i ++){
                            record[i] = (rs.getString(fields.get(i)));
                        } 
                        table_temp.add(record); 
                    }
                    // Clean-up environment
                    request.setAttribute("table_temp", table_temp); 
                    request.setAttribute("rows", fields.size()); 
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
            
        
        request.getRequestDispatcher("export3.jsp").forward(request, response);
        
    }

}
