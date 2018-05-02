package com.mindtree.table.reservation;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class TableReservationApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    try {
            Server.createTcpServer().start();
        }
        catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: ", e);
        }
		return application.sources(TableReservationApplication.class);
	}

	public static void main(String[] args) throws Exception {
	    Server.createTcpServer().start();
		SpringApplication.run(TableReservationApplication.class, args);
	}

}
