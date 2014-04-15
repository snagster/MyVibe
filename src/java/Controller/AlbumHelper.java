/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Album;
import Model.Artist;
import Model.Track;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * @author Daan
 */
public class AlbumHelper {
    Session session = null;
    
    public AlbumHelper(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
    }
    
     public Session getSession(){
        return this.session; 
    }
    
    public int albumExists(String albumname){
        int found=0;
        Criteria criteria = session.createCriteria(Album.class);
        criteria.add(Restrictions.eq("albumname",albumname));
        Album album = (Album) criteria.uniqueResult();
        if(album!=null){
            found=1;
        }
        return found;
    }
    
    public Album getAlbumByAlbumname(String albumname){
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Album.class);
        criteria.add(Restrictions.eq("albumname",albumname));
        Album album = (Album) criteria.uniqueResult();
        trans.commit();
        return album;
    }
    
    public void delete(int albumId){
        Album albumToDelete = (Album) session.get(Album.class, albumId);
        Transaction trans = session.beginTransaction();
        session.delete(albumToDelete);
        if(!trans.wasCommitted()){
            trans.commit();
        }
        session.close();
    }
    
    public void createAlbum(Artist artist, String AlbumName, Date AlbumYear, double AlbumPrice) throws Exception{
        Transaction trans=session.beginTransaction();
        
        /*Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(AlbumYear);
        int currentYear = c.get(Calendar.YEAR);*/

        try{
            if(albumExists(AlbumName)==0){
                Album newAlbum = new Album(artist, AlbumName, AlbumYear, null, AlbumPrice, false, false);
                session.save(newAlbum);
                trans.commit();
                session.flush();
            } else {
                throw new Exception("Er bestaat al een album met deze albumnaam");
            }
        } catch (Exception e){
            if(trans!=null) trans.rollback();
            throw e;
        }
        
        
        
        
    }
    
    
}