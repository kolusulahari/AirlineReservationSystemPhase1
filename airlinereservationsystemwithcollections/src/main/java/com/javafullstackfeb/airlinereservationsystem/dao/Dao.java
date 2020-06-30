package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.FilghtDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserDetails;

public interface Dao {
	
	//  **********Admin Operations**********************//
	boolean registeringAdmin(AdminDetails adminDetails);

	AdminDetails checkAdmin(String email, String password);

	boolean addingFlights(FilghtDetails flightDetails);

	boolean deletingFlight(int flightId);

	List<FilghtDetails> getFlightDetails();

	boolean bookingStatus(UserDetails userDetails, FilghtDetails flightDetails);
	
	
	// ***************User Operations*************************//
	
	boolean registeringUser(UserDetails userDetails);

	UserDetails checkUser(String emailId, String password);

	List<FilghtDetails> searchFlightByNameInUser(String flightname);

	List<FilghtDetails> searchFlightBySourceInUser(String source);

	List<FilghtDetails> searchFlightByDestinationInUser(String destination);

	List<FilghtDetails> getFlightDetailsInUser();

	BookingDetails requestBook(UserDetails userDetails,FilghtDetails flightDetails);


}
