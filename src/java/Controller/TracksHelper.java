/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Album;
import Model.Track;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jens
 */
public class TracksHelper 
{
    Session session = null;
    
    public TracksHelper()
    {
        this.session = NewHibernateUtil.getSessionFactory().openSession();     
    }
    
    public Session getSession()
    {
        return this.session; 
    }  
    public ArrayList getTracksFromAlbum(Album album)
    {
        
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Track.class);
        criteria.add(Restrictions.eq("album", album));
        ArrayList result = (ArrayList<Track>) criteria.list();
        if(!trans.wasCommitted()){
            trans.commit();
        }
        return result;
        
    }
}
