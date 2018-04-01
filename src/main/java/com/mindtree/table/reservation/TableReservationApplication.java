package com.mindtree.table.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class TableReservationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TableReservationApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TableReservationApplication.class, args);
	}

}
