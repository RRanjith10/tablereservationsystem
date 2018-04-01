package com.mindtree.table.reservation.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HotelMenuType {
    @Column
    @ApiModelProperty(notes = "Menu name")
    String menuName;
    @Id
    @Column
    @ApiModelProperty(notes = "The database generated product ID")
    int menuId;
    @Column
    @ApiModelProperty(notes = "Rate of the menu")
    Long menuRate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hid", nullable = false)
    @ApiModelProperty(notes = "Hotel id")
    private Hotels hotel;

    public HotelMenuType(String menuName, int menuId, Long menuRate, Hotels hotel) {
        super();
        this.menuName = menuName;
        this.menuId = menuId;
        this.menuRate = menuRate;
        this.hotel = hotel;
    }

    public Long getMenuRate() {
        return menuRate;
    }

    public void setMenuRate(Long menuRate) {
        this.menuRate = menuRate;
    }

    public HotelMenuType() {
        super();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

}
