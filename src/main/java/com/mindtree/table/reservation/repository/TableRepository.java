package com.mindtree.table.reservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.entity.HotelTableType;

public interface TableRepository extends CrudRepository<HotelTableType, Integer> {
    List<HotelTableType> findByHotelHid(int hid);

}
