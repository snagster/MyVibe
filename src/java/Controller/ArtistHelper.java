/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Artist;
import Model.Listener;
import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Laura
 */
public class ArtistHelper extends UserHelper{
    
    
    public ArtistHelper(){
        super(); 
        
    }
    
    public void createArtist(String ArtistName, String pw, String username, String email, Date sinceDate, String ContactNr) throws Exception {
       Transaction trans=super.getSession().beginTransaction();
        try {
            if(artistExists(username) ==0){
                //User newUser = new User( username,  pw, Calendar.getInstance().getTime(),  email);
                //session.save(newUser);
                //session.flush();
                // op dit moment is er een user gemaakt, nu moet er ook nog een listener gemaakt worden met een link naar 
                // de betrokken user
                Artist newArtist = new Artist(username, pw, Calendar.getInstance().getTime(),email,ArtistName, Calendar.getInstance().getTime(), ContactNr, 0, sinceDate);
                session.save(newArtist);
                trans.commit();
                session.flush();
            }else{
                throw new Exception("Er bestaat al een user met deze gebruikersnaam"); 
            }
        } catch (Exception e) {
            //throw new Exception("Probleem met de databank, de gebruiker kon niet worden aangemaakt");
            if(trans!=null) trans.rollback();
            throw e; 
        }
    }
    
     @Override
    public void update(int userId, String parameter, String value) throws Exception{
        if(parameter.equals("email") | parameter.equals("username")){
            super.update(userId, parameter, value);
        }else {
            Transaction trans = session.beginTransaction();
            Artist artistToUpdate = (Artist) session.get(Artist.class, userId);
            if(parameter.equals("name")){
                artistToUpdate.setArtistName(value);
            }else if(parameter.equals("sincedate")){
                artistToUpdate.setSinceDate(new SimpleDateFormat("yyyy-MM-dd").parse(value));
            }
            session.update(artistToUpdate); 
            if(!trans.wasCommitted()){
                trans.commit();
            }
            session.close();
        }
    }
    
    public int artistExists(String artistName){
        //in deze functie wordt geen transactie meer gemaakt omdat deze in bovenstaande functie wordt opgeroepen
        //waar wel al een sessie bestaat
        int found = 0; 
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", artistName));
        User user = (User) criteria.uniqueResult();
        if (user!=null) {
           found = 1;
        }
        return found;
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
