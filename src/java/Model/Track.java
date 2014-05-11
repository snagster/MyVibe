package Model;
// Generated 6-mrt-2014 11:07:43 by Hibernate Tools 3.6.0


import java.util.Date;
/**
 * Tracks generated by hbm2java
 */
public class Track  implements java.io.Serializable {


     private Integer trackId;
     private Album album;
     private String trackName;

    public Track() {
    }
    
    public Track(Album album, String trackName) {
       this.album = album;
       this.trackName = trackName;
    }
   
    public Integer getTrackId() {
        return this.trackId;
    }
    
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }
    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
    public String getTrackName() {
        return this.trackName;
    }
    
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}


