/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Listener;
import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Laura
 */
public class ListenerHelper extends UserHelper {
    
    
    public ListenerHelper(){
        super(); 
        
    }
    
    public void createListener(String email, String pw, String username, String Fullname, Date birthdate) throws Exception {
       Transaction trans=super.getSession().beginTransaction();
        try {
            if(super.userExists(username) ==0){
                //User newUser = new User( username,  pw, Calendar.getInstance().getTime(),  email);
                //session.save(newUser);
                //session.flush();
                // op dit moment is er een user gemaakt, nu moet er ook nog een listener gemaakt worden met een link naar 
                // de betrokken user
                Listener newListener = new Listener(username, pw, Calendar.getInstance().getTime(),email, Fullname, 30,  birthdate);
                super.getSession().save(newListener);
                trans.commit();
                super.getSession().flush();
            }else{
                throw new Exception("Er bestaat al een user met deze gebruikersnaam"); 
            }
        } catch (Exception e) {
            //throw new Exception("Probleem met de databank, de gebruiker kon niet worden aangemaakt");
            if(trans!=null) trans.rollback();
            throw e; 
        }
    }
    
    
    
}
