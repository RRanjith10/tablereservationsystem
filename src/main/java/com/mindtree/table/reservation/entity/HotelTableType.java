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
public class HotelTableType {

    @Column
    @ApiModelProperty(notes = "Name of the table reserved by the customer")
    String tableName;
    @Id
    @Column
    @ApiModelProperty(notes = "Id of the table reserved by the customer")
    int tableId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "hid", nullable = false)
    private Hotels hotel;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public void setHotel(Hotels hotel) {
        this.hotel = hotel;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public HotelTableType(String tableName, int tableId, Hotels hotel) {
        super();
        this.tableName = tableName;
        this.tableId = tableId;
        this.hotel = hotel;
    }

    public HotelTableType() {
        super();
    }

}
