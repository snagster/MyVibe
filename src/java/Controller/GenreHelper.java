/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Album;
import Model.Genre;
import Model.GenreAlbum;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Daan
 */
public class GenreHelper {
    Session session = null;
    
    public GenreHelper(){
        this.session = NewHibernateUtil.getSessionFactory().openSession();
    }
    
    public Session getSession(){
        return this.session; 
    }
    
    public List<Genre> getAllGenres(){
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Genre.class);
        List<Genre> genres = criteria.list();
        trans.commit();
        return genres;
    }
    
    public List<Genre> getAlbumGenres(Album album){
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(GenreAlbum.class);
        criteria.add(Restrictions.eq("album",album));
        List<GenreAlbum> GenreAlbums = criteria.list();
        trans.commit();
        
        List<Genre> genres = new ArrayList<Genre>();
        
        criteria = session.createCriteria(GenreAlbum.class);
        for(GenreAlbum genreAlbum : GenreAlbums){
            session.beginTransaction();
            criteria.add(Restrictions.eq("genre",genreAlbum.getGenre()));
            genres.add((Genre) criteria.uniqueResult());
            trans.commit();
        }
        return genres;
    }
    
    public void addAlbumGenre(Genre genre, Album album) throws Exception{
        Transaction trans=session.beginTransaction();
        try{
        GenreAlbum newGenreAlbum = new GenreAlbum(genre, album);
        session.save(newGenreAlbum);
        if(!trans.wasCommitted()){
            trans.commit();
        }
        session.flush();
        }catch (Exception e){
            if(trans!=null){
                trans.rollback();
            }
            throw e;
        }
    }
}


