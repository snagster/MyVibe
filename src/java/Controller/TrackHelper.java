package Controller;

import Model.Album;
import Model.Artist;
import Model.Track;
import java.util.Date;
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
    
    public int trackExists(String trackname){
        int found=0;
        Criteria criteria = session.createCriteria(Track.class);
        criteria.add(Restrictions.eq("trackName",trackname));
        Track track = (Track) criteria.uniqueResult();
        if(track!=null){
            found=1;
        }
        return found;
    }
    
    public void createTrack(Album album, String trackName) throws Exception{
        Transaction trans=session.beginTransaction();
        try{
            Track newTrack = new Track(album, trackName);
            session.save(newTrack);
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
    
    public List<Track> getAllTracks(Album album){
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Track.class);
        criteria.add(Restrictions.eq("album",album));
        List<Track> tracks = criteria.list();
        trans.commit();
        return tracks;
    }
    
    
}
