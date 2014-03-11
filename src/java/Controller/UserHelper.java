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
    
    public Session getSession(){
        return this.session; 
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
    
    public void updatePassword(String username, String email, String password) throws Exception{
        if(this.getUserByUsername(username)!=null){
            User u = this.getUserByUsername(username);
            if(u.getUserEmail().equals(email)){
                Transaction trans = session.beginTransaction();
                User userToUpdate = (User)session.get(User.class,u.getUserId());
                userToUpdate.setUserPassword(this.hashPassword(password));
                session.update(userToUpdate); 
                trans.commit();
                session.close();
            }else{
                throw new Exception("Via het emailadres verifiëren wij u identiteit. U gaf een foutief "
                        + "emailadres op, wat inhoud dat wij u passwoord niet zullen veranderen."); 
            }
        }else{
            throw new Exception("Er bestaan geen gebruiker met die username. U are suspicious"); 
        }
    }
    
    public void update(int userId, String parameter, String value) throws Exception{
        Transaction trans = session.beginTransaction();
        User userToUpdate = (User) session.get(User.class, userId);
        if(parameter.equals("username")){
            if(this.getUserByUsername(value) == null){
                userToUpdate.setUsername(value);
            }else{
                trans.rollback();
                session.close();
                throw new Exception("Deze username is al in gebruik, kies een andere!"); 
            }
        }else if(parameter.equals("email")){
            userToUpdate.setUserEmail(value);
        }
        session.update(userToUpdate); 
        trans.commit();
        session.close();
    }
}
