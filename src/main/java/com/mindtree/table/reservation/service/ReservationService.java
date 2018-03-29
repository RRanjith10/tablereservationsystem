package com.mindtree.table.reservation.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.table.reservation.repository.BookingRepo;
import com.mindtree.table.reservation.repository.CustomerRepository;
import com.mindtree.table.reservation.repository.HotelRepository;
import com.mindtree.table.reservation.repository.MenuRepository;
import com.mindtree.table.reservation.repository.TableRepository;
import com.mindtree.table.reservation.entity.Booking;
import com.mindtree.table.reservation.entity.Customer;
import com.mindtree.table.reservation.entity.HotelMenuType;
import com.mindtree.table.reservation.entity.HotelTableType;
import com.mindtree.table.reservation.entity.Hotels;
@Service
public class ReservationService {
	@Autowired
	HotelRepository hotelRepo;
	@Autowired
	TableRepository tableRepository;
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	BookingRepo bookingRepo;
	
	public List<Hotels> searchHotelsByCity(String city){
		return hotelRepo.findByCity(city);
	}
	public List<HotelTableType> searchTablesByHotelId(String hId){
		int hotelId = Integer.parseInt(hId);
		List<HotelTableType> tableList = tableRepository.findByHotelHid(hotelId);
		//for(HotelTableType h:hl)
			//System.out.println(h.getTableName());
		return tableList;
	}
	
	public List<HotelMenuType> searchMenuByHotelId(String hId){
		int hotelId = Integer.parseInt(hId);
		List<HotelMenuType> menuList = menuRepository.findByHotelHid(hotelId);
		
		return menuList;
	}
	
	public Hotels searchHotelsById(String hId){
		int hotelId = Integer.parseInt(hId);
		
		return hotelRepo.findByHid(hotelId);
	}
	public void calculatePayment(String personCount, String menu) {
		
		
	}
	public int calculatePayment(int personCount, int rate) {
		// TODO Auto-generated method stub
		return personCount*rate;
		
	}
	//mocked payment //checks the account no. length as 10digit
	public boolean paymentProcess(Long billTotal, String cardNo, String cvv){
		if(cardNo !=null && cardNo.length()==10){
		return true;
		}
		return false;
	}
	//public 
	public boolean saveBooking(Long billTotal,String bookeduserMailId, String bookedhname, String bookedusertableSelected,
			String bookedmenuSelected, String bookedUserName, int bookedpersonCount) {
		Customer cust = customerRepo.findByEmailId(bookeduserMailId);
		List<Hotels> hotel =  hotelRepo.findByHname(bookedhname);
		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setBillTotal(billTotal);
		booking.setBookedDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		booking.setCustomer(cust);
		booking.setHotel(hotel.get(0));
		cust.getCustName();
		bookingRepo.save(booking);
		return true;
	}
	public List<String> fetchAllCitiesofHotels(){
		List<String> citiesList = new ArrayList<String>();
		List<Hotels> hotelsList= hotelRepo.findAll();
		for(Hotels hotel:hotelsList){
			if(!citiesList.contains(hotel.getCity())){
			citiesList.add(hotel.getCity());
			}
		}
		return citiesList;
		
	}
	public int calculateTotalBilleAmount(List<String> itemList) {
		int total = 0;
		for (String item : itemList){
			String[] specificItem = item.split("---");
			 List<String> specificItemm = Arrays.asList(specificItem);
			 
			 int itemPerRate = Integer.parseInt(specificItemm.get(1));
			 /*int billTotal = reservationService.calculatePayment(personCount,
				Integer.parseInt(menuSelected.substring(start + 3, end)));*/
		
			 int quantity = Integer.parseInt(specificItemm.get(2));
			 total = total + (itemPerRate * quantity);
			 
		}
		/*int billTotal = reservationService.calculatePayment(personCount,
				Integer.parseInt(menuSelected.substring(start + 3, end)));*/
		return total;
	}
}
