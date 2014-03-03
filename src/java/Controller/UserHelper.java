/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserHelper {
    Session session = null;
    
    public UserHelper(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
        
    }
    
    public int userExists(String username){
        //in deze functie wordt geen transactie meer gemaakt omdat deze in bovenstaande functie wordt opgeroepen
        //waar wel al een sessie bestaat
        int found = 0; 
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        User user = (User) criteria.uniqueResult();
        if (user!=null) {
           found = 1;
        }
        return found; 
    }
    
    public User getUserByUsername(String username){
        Transaction trans=session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        User user = (User) criteria.uniqueResult();
        trans.commit();
        return user; 
        
    }
    
    public String hashPassword(String password){
        String salt = "Th1s 1s m3 @dd1ng @ funny s@lt!";
        password = password + salt;
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            
            byte byteData[] = md.digest();
            
            
            //convert the byte to hex format
            
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ListenerHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hexString.toString();
    }
}
