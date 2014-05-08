package Controller;

import Model.Album;
import Model.Artist;
import Model.Track;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Jens
 */
public class TrackHelper {
    Session session = null;

    public TrackHelper(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
    }

    public Session getSession(){
        return this.session; 
    }

    public List<Track> getAllTracks(String album){
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Track.class);
        criteria.add(Restrictions.eq("album",album));
        List<Track> tracks = criteria.list();
        trans.commit();
        return tracks;
    }
}
