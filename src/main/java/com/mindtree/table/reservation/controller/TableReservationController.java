package com.mindtree.table.reservation.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

/**
 * @author Ranjith Ranganathan
 *
 */
@Controller
public class TableReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    CustomerRegistrationService customerRegistrationService;
    @Autowired
    private EmailService sender;
    
    @ApiOperation(value = "Home page of the Online Table Reservation System",response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized to access the system"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Online Table Reservation is not found/unavailable")
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Map<String, Object> model) {
        return "home";
    }
    
    @ApiOperation(value = "Loads Reservation page",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized to create a new user"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "User registerion is not found/unavailable")
    })
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(Map<String, Object> model) {
        return new ModelAndView("Registration");
    }

    @ApiOperation(value = "Registers the user in the system",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "User created Successfully"),
        @ApiResponse(code = 401, message = "You are not authorized to create a new user"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "User registerion is not found/unavailable")
    })
    @RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") Customer user, BindingResult bindingResult, Model model) {
        customerRegistrationService.saveCustomer(user);
        return new ModelAndView("Login", "message", "Registration Successful.");
    }
    @ApiOperation(value = "Loads login page",response = String.class)
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized to access the system"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Online Table Reservation is not found/unavailable")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "Login";
    }
    @ApiOperation(value = "To perform validation with the enterred user credentials",response = ModelAndView.class)
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)
    public ModelAndView validateUser(@ModelAttribute("user") Customer user, HttpServletRequest request) {

        boolean validUser = customerRegistrationService.validateUser(user.getEmailId(), user.getPassword());
        // checks the db to find the user is valid
        if (validUser) {
            Customer cust = customerRegistrationService.searchCustomer(user.getEmailId());
            HttpSession session = request.getSession();
            session.setAttribute("validuserEmailId", cust.getEmailId());
            session.setAttribute("validuserName", cust.getCustName());
            List<String> citiesList = reservationService.fetchAllCitiesofHotels();

            return new ModelAndView("Search", "citieslist", citiesList);
        }
        else {
            return new ModelAndView("Login", "message", "Enter valid username and password!!!");
        }
    }
    @ApiOperation(value = "Performs Search of all the cities available in the system",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized to access the system"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Online Table Reservation is not found/unavailable")
    })
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(Map<String, Object> model) {
        // this gives the hotel's city list to display in search for city page
        List<String> citiesList = reservationService.fetchAllCitiesofHotels();

        return new ModelAndView("Search", "citieslist", citiesList);
    }
    @ApiOperation(value = "Searches all the hotels present in the selected city",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Hotel search is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to search the hotels"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Search results are not found/unavailable")
    })
    @RequestMapping(value = "/searchHotels", method = RequestMethod.POST)
    public ModelAndView searchHotel(@RequestParam("searchbycity") String searchname) {
        // this is to get the hotels list based on the city name
        List<Hotels> retrieveHotels = reservationService.searchHotelsByCity(searchname);
        if (retrieveHotels.size() == 0) {
            return new ModelAndView("Search", "message", "No Hotels found in the selected city. Please select another city.");
        }
        return new ModelAndView("DisplayHotels", "retrieveHotels", retrieveHotels);
    }
    @ApiOperation(value = "Retrieves the hotel details and send",response = ModelAndView.class)
    @RequestMapping(value = "/viewHotel", method = RequestMethod.GET)
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
    @ApiOperation(value = "Makes reservation with the details given by the user",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Reservation is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to make the reservation"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Reservation service is not found/unavailable")
    })
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
        int billTotal = reservationService.calculateTotalBilleAmount(itemList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("billTotal", billTotal);
        modelAndView.setViewName("PaymentView");
        return modelAndView;

    }
    @ApiOperation(value = "Makes payment for the items purchased by the customer",response = ModelAndView.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Payment is Successful"),
        @ApiResponse(code = 401, message = "You are not authorized to make the payment"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Payment gateway is not found/unavailable")
    })
    @RequestMapping(value = "/makePayment", method = RequestMethod.POST)
    public ModelAndView makePayment(@RequestParam("billTotal") Long billTotal, @RequestParam("cardNo") String cardNo,
        @RequestParam("cvv") String cvv, Model model, HttpServletRequest request) {

        boolean paymentStatus = reservationService.paymentProcess(billTotal, cardNo, cvv);
        if (paymentStatus) {
            HttpSession session = request.getSession();
            String bookeduserMailId = (String) session.getAttribute("bookeduserMailId");
            String bookedhname = (String) session.getAttribute("bookedhname");
            String bookedusertableSelected = (String) session.getAttribute("bookedusertableSelected");
            String bookedmenuSelected = (String) session.getAttribute("bookedmenuSelected");
            int bookedpersonCount = (int) session.getAttribute("bookedpersonCount");
            String bookedUserName = (String) session.getAttribute("validuserName");
            reservationService.saveBooking(billTotal, bookeduserMailId, bookedhname, bookedusertableSelected,
                bookedmenuSelected, bookedUserName, bookedpersonCount);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("PaymentSuccess");
            try {

                sender.sendEmail(billTotal, bookeduserMailId, bookedUserName , bookedhname, bookedusertableSelected, bookedmenuSelected,
                    bookedpersonCount);

                return new ModelAndView("PaymentSuccess", "message", "Email Sent!");
            }
            catch (Exception ex) {
                return new ModelAndView("PaymentSuccess", "message", "Error in sending email: " + ex);
            }
        }
        return new ModelAndView("PaymentView", "message", "Payment Unsuccessful...");
    }
}