package com.mindtree.table.reservation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.table.reservation.entity.HotelMenuType;

public interface MenuRepository extends CrudRepository<HotelMenuType, Integer>{
	List<HotelMenuType> findByHotelHid(int hid);

}
