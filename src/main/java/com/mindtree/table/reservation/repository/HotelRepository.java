package com.mindtree.table.reservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.entity.Hotels;

public interface HotelRepository extends CrudRepository<Hotels, Integer> {
    List<Hotels> findByCity(String city);

    Hotels findByHid(int hotelId);

    List<Hotels> findByHname(String hname);

    public List<Hotels> findAll();
}
