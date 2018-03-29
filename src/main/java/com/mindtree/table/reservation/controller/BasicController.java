package com.mindtree.table.reservation.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.table.reservation.entity.Customer;
import com.mindtree.table.reservation.entity.HotelMenuType;
import com.mindtree.table.reservation.entity.HotelTableType;
import com.mindtree.table.reservation.entity.Hotels;
import com.mindtree.table.reservation.service.CustomerRegistrationService;
import com.mindtree.table.reservation.service.EmailService;
import com.mindtree.table.reservation.service.ReservationService;

@Controller
public class BasicController {
	@Autowired
	ReservationService reservationService;
	@Autowired
	CustomerRegistrationService customerRegistrationService;
	@Autowired
	private EmailService sender;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "home";
	}

	@RequestMapping("/login")
	public String login(Map<String, Object> model) {
		return "Login";
	}
	
	@RequestMapping("/search")
	public ModelAndView search(Map<String, Object> model) {
		//this gives the hotel's city list to display in search for city page
		List<String> citiesList = reservationService.fetchAllCitiesofHotels();

		return new ModelAndView("Search", "citieslist", citiesList);
	}

	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(@ModelAttribute("user") Customer user, HttpServletRequest request) {

		boolean validUser = customerRegistrationService.checkLogin(user.getEmailId(), user.getPassword());
		//checks the db to find the user is valid
		if (validUser) {
			Customer cust = customerRegistrationService.searchCustomer(user.getEmailId());
			HttpSession session = request.getSession();
			session.setAttribute("validuserEmailId", cust.getEmailId());
			session.setAttribute("validuserName", cust.getCustName());
			List<String> citiesList = reservationService.fetchAllCitiesofHotels();

			return new ModelAndView("Search", "citieslist", citiesList);
		} else {
			return new ModelAndView("Login", "message", "Enter valid username and password!!!");
		}
	}

	@RequestMapping("/registration")
	public ModelAndView registration(Map<String, Object> model) {
		return new ModelAndView("Registration");
	}

	@RequestMapping("/viewHotel")
	public ModelAndView viewHotel(@RequestParam("btn") String hotelId, Model model) {

		Hotels selectedHotel = reservationService.searchHotelsById(hotelId);
		List<HotelTableType> tableList = reservationService.searchTablesByHotelId(hotelId);
		List<HotelMenuType> menuList = reservationService.searchMenuByHotelId(hotelId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("selectedHotel", selectedHotel);
		modelAndView.addObject("tableList", tableList);
		modelAndView.addObject("menuList", menuList);
		modelAndView.setViewName("DisplaySpecificHotel");
		return modelAndView;
	}

	@RequestMapping(value = "/placeReservation", method = RequestMethod.POST)
	public ModelAndView placeReservation(@RequestParam("hname") String hname,
			@RequestParam("userMailId") String userMailId, @RequestParam("tableSelected") String tableSelected,
			@RequestParam("personCount") int personCount, @RequestParam("menuSelected") String menuSelected,
			HttpServletRequest request, @RequestParam("menuS") String menuS, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("bookeduserMailId", userMailId);
		session.setAttribute("bookedhname", hname);
		session.setAttribute("bookedusertableSelected", tableSelected);
		session.setAttribute("bookedmenuSelected", menuSelected);
		session.setAttribute("bookedpersonCount", personCount);

		String[] items = menuS.split(":");
		List<String> itemList = Arrays.asList(items);
		System.out.println(itemList);
		int billTotal = reservationService.calculateTotalBilleAmount(itemList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("billTotal", billTotal);
		modelAndView.setViewName("PaymentView");
		return modelAndView;

	}

	@RequestMapping(value = "/doPayment", method = RequestMethod.POST)
    public ModelAndView doPayment(@RequestParam("billTotal") Long billTotal, @RequestParam("cardNo") String cardNo,
        @RequestParam("cvv") String cvv, Model model, HttpServletRequest request) {

        boolean paymentStatus = reservationService.paymentProcess(billTotal, cardNo, cvv);
        if (paymentStatus) {
            HttpSession session = request.getSession();
            String bookeduserMailId = (String) session.getAttribute("bookeduserMailId");
            String bookedhname = (String) session.getAttribute("bookedhname");
            String bookedusertableSelected = (String) session.getAttribute("bookedusertableSelected");
            String bookedmenuSelected = (String) session.getAttribute("bookedmenuSelected");
            int bookedpersonCount = (int) session.getAttribute("bookedpersonCount");
            // System.out.println(valid);
            String bookedUserName = (String) session.getAttribute("validuserName");
            reservationService.saveBooking(billTotal, bookeduserMailId, bookedhname, bookedusertableSelected,
                bookedmenuSelected, bookedUserName, bookedpersonCount);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("PaymentSuccess");
            try {

                sender.sendEmail(billTotal, bookeduserMailId, bookedhname, bookedusertableSelected, bookedmenuSelected,
                    bookedpersonCount);

                return new ModelAndView("PaymentSuccess", "message", "Email Sent!");
            }
            catch (Exception ex) {
                return new ModelAndView("PaymentSuccess", "message", "Error in sending email: " + ex);
            }
        }
        return new ModelAndView("PaymentView", "message", "Payment Unsuccessful...");
    }

	
	@RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("user") Customer user, BindingResult bindingResult, Model model) {
		customerRegistrationService.saveCustomer(user);
		return new ModelAndView("Login", "message", "Registration Successful!!!");
	}

	
	@RequestMapping(value = "/searchHotels", method = RequestMethod.POST)
	public ModelAndView searchHotel(@RequestParam("searchbycity") String searchname) {
		//this is to get the hotels list based on the city name
		List<Hotels> retrieveHotels = reservationService.searchHotelsByCity(searchname);
		System.out.println("****" + retrieveHotels);
		if (retrieveHotels.size() == 0) {
			return new ModelAndView("Search", "message", "No Hotel found in that city!!!!");
		} else
			System.out.println("address:" + retrieveHotels.get(0).getAddress());
		return new ModelAndView("DisplayHotels", "retrieveHotels", retrieveHotels);
	}

}