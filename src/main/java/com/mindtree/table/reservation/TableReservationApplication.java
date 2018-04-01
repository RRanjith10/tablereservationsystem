package com.mindtree.table.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class RestaurantTableReservationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestaurantTableReservationApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestaurantTableReservationApplication.class, args);
	}

}
