/**
 * BizExtBo.java
 * com.jhw.bo.gaode
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月14日 		Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/
/**
 * BizExtBo.java
 * com.jhw.bo.gaode
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月14日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.bo.gaode;

/**
 * ClassName:BizExtBo
 * Function: TODO 深度信息,extensions=all的时候显示 
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午7:18:33
 *
 * @see
 */
public class BizExtBo {

    /** 评分*/
    private String rating;
    /** 人均消费*/
    private String cost;
    /** 是否可订餐*/
    private String meal_ordering;
    /** 是否可选座*/
    private String seat_ordering;
    /** 是否可订票*/
    private String ticket_ordering;
    /** */
    private String hotel_ordering;
    
    /**
     * rating
     *
     * @return the rating
     * @since lil Ver 1.0
    */
    
    public String getRating() {
        return rating;
    }
    
    /**
     * rating
     *
     * @param rating the rating to set
     * @since lil Ver 1.0
     */
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    /**
     * cost
     *
     * @return the cost
     * @since lil Ver 1.0
    */
    
    public String getCost() {
        return cost;
    }
    
    /**
     * cost
     *
     * @param cost the cost to set
     * @since lil Ver 1.0
     */
    
    public void setCost(String cost) {
        this.cost = cost;
    }
    
    /**
     * meal_ordering
     *
     * @return the meal_ordering
     * @since lil Ver 1.0
    */
    
    public String getMeal_ordering() {
        return meal_ordering;
    }
    
    /**
     * meal_ordering
     *
     * @param meal_ordering the meal_ordering to set
     * @since lil Ver 1.0
     */
    
    public void setMeal_ordering(String meal_ordering) {
        this.meal_ordering = meal_ordering;
    }
    
    /**
     * seat_ordering
     *
     * @return the seat_ordering
     * @since lil Ver 1.0
    */
    
    public String getSeat_ordering() {
        return seat_ordering;
    }
    
    /**
     * seat_ordering
     *
     * @param seat_ordering the seat_ordering to set
     * @since lil Ver 1.0
     */
    
    public void setSeat_ordering(String seat_ordering) {
        this.seat_ordering = seat_ordering;
    }
    
    /**
     * ticket_ordering
     *
     * @return the ticket_ordering
     * @since lil Ver 1.0
    */
    
    public String getTicket_ordering() {
        return ticket_ordering;
    }
    
    /**
     * ticket_ordering
     *
     * @param ticket_ordering the ticket_ordering to set
     * @since lil Ver 1.0
     */
    
    public void setTicket_ordering(String ticket_ordering) {
        this.ticket_ordering = ticket_ordering;
    }
    
    /**
     * hotel_ordering
     *
     * @return the hotel_ordering
     * @since lil Ver 1.0
    */
    
    public String getHotel_ordering() {
        return hotel_ordering;
    }
    
    /**
     * hotel_ordering
     *
     * @param hotel_ordering the hotel_ordering to set
     * @since lil Ver 1.0
     */
    
    public void setHotel_ordering(String hotel_ordering) {
        this.hotel_ordering = hotel_ordering;
    }
    
}

