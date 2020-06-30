package com.javafullstackfeb.airlinereservationsystem.repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.FilghtDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserDetails;

public class Repository {
	public static List<AdminDetails> ADMIN_DETAILS = new ArrayList<AdminDetails>();
	public static  List<UserDetails>  USER_DETAILS = new ArrayList<UserDetails>();
	public static  List<FilghtDetails>  FLIGHT_DETAILS = new ArrayList<FilghtDetails>();
	public static  List<BookingDetails> BOOKING_DETAILS = new ArrayList<BookingDetails>();
	
	public static void dataBase() {
		
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setEmailId("monica@gmail.com");
		adminDetails.setId(1);
		adminDetails.setMobileNo(9177897240L);
		adminDetails.setName("monica");
		adminDetails.setPassword("@Monica123");
		ADMIN_DETAILS.add(adminDetails);
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("rachel");
		userDetails.setEmailId("rachel@gmail.com");
		userDetails.setPassword("@Rachel123");
		userDetails.setMobileNumber(9177897240L);
		USER_DETAILS.add(userDetails);
		
		
		FilghtDetails flightDetails = new FilghtDetails();
		flightDetails.setFlightId(1001);
		flightDetails.setFlightName("SpiceJet");
		flightDetails.setSource("Vizag");
		flightDetails.setDestination("Banglore");
		flightDetails.setNoofseatsavailable(20);
		flightDetails.setArrivalDateTime(LocalDateTime.of(2020, Month.JULY, 24, 12, 30));
		flightDetails.setDepartureDateTime(LocalDateTime.of(2020, Month.JULY, 24, 2, 30));
		FLIGHT_DETAILS.add(flightDetails);
		
		FilghtDetails flightDetails1 = new FilghtDetails();
		flightDetails1.setFlightId(1002);
		flightDetails1.setFlightName("Indigo");
		flightDetails1.setSource("Banglore");
		flightDetails1.setDestination("Hyderabad");
		flightDetails1.setNoofseatsavailable(10);
		flightDetails1.setArrivalDateTime(LocalDateTime.of(2020, Month.JULY, 26, 1, 30));
		flightDetails1.setDepartureDateTime(LocalDateTime.of(2020, Month.JULY, 26, 3, 30));
		FLIGHT_DETAILS.add(flightDetails1);
		
		FilghtDetails flightDetails2 = new FilghtDetails();
		flightDetails2.setFlightId(1003);
		flightDetails2.setFlightName("GoAir");
		flightDetails2.setSource("Chennai");
		flightDetails2.setDestination("Delhi");
		flightDetails2.setNoofseatsavailable(12);
		flightDetails2.setArrivalDateTime(LocalDateTime.of(2020, Month.AUGUST, 24, 12, 30));
		flightDetails2.setDepartureDateTime(LocalDateTime.of(2020, Month.AUGUST, 24, 2, 30));
		FLIGHT_DETAILS.add(flightDetails2);
		
		FilghtDetails flightDetails3 = new FilghtDetails();
		flightDetails3.setFlightId(1004);
		flightDetails3.setFlightName("AirAsia");
		flightDetails3.setSource("Delhi");
		flightDetails3.setDestination("Mumbai");
		flightDetails3.setNoofseatsavailable(25);
		flightDetails3.setArrivalDateTime(LocalDateTime.of(2020, Month.AUGUST, 15, 10, 00));
		flightDetails3.setDepartureDateTime(LocalDateTime.of(2020, Month.AUGUST, 15, 12, 00));
		FLIGHT_DETAILS.add(flightDetails3);
		
		FilghtDetails flightDetails4 = new FilghtDetails();
		flightDetails4.setFlightId(1005);
		flightDetails4.setFlightName("TruJet");
		flightDetails4.setSource("Kerala");
		flightDetails4.setDestination("SriNagar");
		flightDetails4.setNoofseatsavailable(12);
		flightDetails4.setArrivalDateTime(LocalDateTime.of(2020, Month.OCTOBER, 24, 6, 30));
		flightDetails4.setDepartureDateTime(LocalDateTime.of(2020, Month.OCTOBER, 24, 8, 30));
		FLIGHT_DETAILS.add(flightDetails4);
		
	}

}
