package Model;
// Generated 6-mrt-2014 11:07:43 by Hibernate Tools 3.6.0



/**
 * OrderDetails generated by hbm2java
 */
public class OrderDetail  implements java.io.Serializable {


     private Integer orderDetailId;
     /*private Track track;*/
     private Album album;
     private Order order;

    public OrderDetail() {
    }

    public OrderDetail(/*Track track*/Album album, Order order) {
       /*this.track = track;*/
       this.album = album;
       this.order = order;
    }
   
    public Integer getOrderDetailId() {
        return this.orderDetailId;
    }
    
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    
    /*public Track getTrack() {
        return this.track;
    }
    
    public void setTrack(Track track) {
        this.track = track;
    }*/
    
    public Album getAlbum() {
        return this.album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
}


