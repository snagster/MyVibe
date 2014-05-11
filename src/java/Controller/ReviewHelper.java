/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Album;
import Model.Listener;
import Model.Review;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
        
   
    public void createReview(Listener listener, Album album, String reviewText) throws Exception{
        Transaction trans=session.beginTransaction();
        try{
            Review review = new Review(listener ,album, reviewText);
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
