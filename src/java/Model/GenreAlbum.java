package Model;
// Generated 27-feb-2014 12:19:32 by Hibernate Tools 3.6.0



/**
 * GenreAlbum generated by hbm2java
 */
public class GenreAlbum  implements java.io.Serializable {


     private Integer genreAlbumId;
     private Genre genre;
     private Album album;

    public GenreAlbum() {
    }

    public GenreAlbum(Genre genre, Album album) {
       this.genre = genre;
       this.album = album;
    }
   
    public Integer getGenreAlbumId() {
        return this.genreAlbumId;
    }
    
    public void setGenreAlbumId(Integer genreAlbumId) {
        this.genreAlbumId = genreAlbumId;
    }
    public Genre getGenre() {
        return this.genre;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }




}


