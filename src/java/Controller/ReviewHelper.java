/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Album;
import Model.Artist;
import Model.Listener;
import Model.Review;
import Model.User;
import java.io.PrintWriter;
import java.util.Calendar;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Jens
 */
public class ReviewHelper {
    Session session = null;
    
    public ReviewHelper(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
    }
    
     public Session getSession(){
        return this.session; 
    }
        
   
    public void createReview(Listener listener, Album album, String ReviewText) throws Exception{
        Transaction trans=session.beginTransaction();
        

        try{  
                System.out.println(ReviewText);
                Review review = new Review(listener ,album,ReviewText);
                System.out.println("OK");
                session.save(review);
                if(!trans.wasCommitted()){
                    trans.commit();
                }
                session.flush();

        } catch (Exception e){
            if(trans!=null) {
                trans.rollback();
            }
            throw e;
        }

    }
   
}
