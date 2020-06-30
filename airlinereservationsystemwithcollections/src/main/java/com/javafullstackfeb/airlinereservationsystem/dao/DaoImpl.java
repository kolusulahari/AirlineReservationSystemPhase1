package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.FilghtDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.repository.Repository;

public class DaoImpl implements Dao {

	@Override
	public boolean registeringAdmin(AdminDetails adminDetails) {
		// TODO Auto-generated method stub
		for (AdminDetails regAdmin : Repository.ADMIN_DETAILS) {
			if ((regAdmin.getEmailId()).equalsIgnoreCase(adminDetails.getEmailId())) {
				return false;
			}
		}
		Repository.ADMIN_DETAILS.add(adminDetails);
		return true;
	}

	@Override
	public AdminDetails checkAdmin(String email, String password)  {
		// TODO Auto-generated method stub
		for (AdminDetails checkAdmin : Repository.ADMIN_DETAILS) {
			if ((checkAdmin.getEmailId().equalsIgnoreCase(email)) && (checkAdmin.getPassword().equals(password))) {
				return checkAdmin;
			}
		}
		throw new AirlineException("Invalid Credentials");
	}

	@Override
	public boolean addingFlights(FilghtDetails flightDetails) {
		// TODO Auto-generated method stub
		for (FilghtDetails addFlight : Repository.FLIGHT_DETAILS ) {
			if (addFlight.getFlightId() == flightDetails.getFlightId()) {
				return false;
			}
		}
		Repository.FLIGHT_DETAILS .add(flightDetails);
		return true;
	}

	@Override
	public boolean deletingFlight(int flightId) {
		// TODO Auto-generated method stub
		boolean ds = false;
		for (int i = 0; i <= Repository.FLIGHT_DETAILS.size() - 1; i++) {
			FilghtDetails retrievedFlight = Repository.FLIGHT_DETAILS.get(i);
			int retrievedId = retrievedFlight.getFlightId();
			if (flightId == retrievedId) {
				ds = true;
				Repository.FLIGHT_DETAILS.remove(i);
				break;
			}
		}
		return ds;
	}

	
	@Override
	public List<FilghtDetails> getFlightDetails() {
		// TODO Auto-generated method stub
		return Repository.FLIGHT_DETAILS;
	}

	@Override
	public boolean bookingStatus(UserDetails userDetails, FilghtDetails flightDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registeringUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		for (UserDetails ud : Repository.USER_DETAILS) {
			if ((ud.getEmailId()).equalsIgnoreCase(userDetails.getEmailId())) {
				return false;
			}
		}
		Repository.USER_DETAILS.add(userDetails);
		return true;
	}

	@Override
	public UserDetails checkUser(String emailId, String password) {
		// TODO Auto-generated method stub
		for (UserDetails ud :Repository.USER_DETAILS) {
			if ((ud.getEmailId().equalsIgnoreCase(emailId)) && (ud.getPassword().equals(password))) {
				return ud;
			}
		}
		throw new AirlineException("Invalid Credentials");
	}

	@Override
	public List<FilghtDetails> searchFlightByNameInUser(String flightname) {
		// TODO Auto-generated method stub
		ArrayList<FilghtDetails> sl = new ArrayList<FilghtDetails>();
		for (int i = 0; i <= Repository.FLIGHT_DETAILS.size() - 1; i++) {
			FilghtDetails rf = Repository.FLIGHT_DETAILS.get(i);
			String rfn = rf.getFlightName();
			if (flightname.equalsIgnoreCase(rfn)) {
				sl.add(rf);
				return sl;
			}
		}
		if (sl.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return sl;
		}
	}

	@Override
	public List<FilghtDetails> searchFlightBySourceInUser(String source) {
		// TODO Auto-generated method stub
		ArrayList<FilghtDetails> sl = new ArrayList<FilghtDetails>();
		for (int i = 0; i <= Repository.FLIGHT_DETAILS.size() - 1; i++) {
			FilghtDetails rf = Repository.FLIGHT_DETAILS.get(i);
			String rfs = rf.getSource();
			if (source.equalsIgnoreCase(rfs)) {
				sl.add(rf);
			}
		}
		if (sl.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return sl;
		}
	}

	@Override
	public List<FilghtDetails> searchFlightByDestinationInUser(String destination) {
		// TODO Auto-generated method stub
		ArrayList<FilghtDetails> sl = new ArrayList<FilghtDetails>();
		for (int i = 0; i <= Repository.FLIGHT_DETAILS.size() - 1; i++) {
			FilghtDetails rf = Repository.FLIGHT_DETAILS.get(i);
			String rfd = rf.getDestination();
			if (destination.equalsIgnoreCase(rfd)) {
				sl.add(rf);
			}
		}
		if (sl.size() == 0) {
			throw new AirlineException("Flight not found");
		} else {
			return sl;
		}
	}

	@Override
	public List<FilghtDetails> getFlightDetailsInUser() {
		// TODO Auto-generated method stub
		return Repository.FLIGHT_DETAILS;
	}

	@Override
	public BookingDetails requestBook(UserDetails userDetails, FilghtDetails flightDetails) {
		// TODO Auto-generated method stub
		 boolean flag = false, 
					isRequestExists = false;
	          		BookingDetails bookingDetails = new BookingDetails();
	                 UserDetails uf = new UserDetails();
	                 FilghtDetails fd = new FilghtDetails();
	     			for (BookingDetails bs : Repository.BOOKING_DETAILS) {
						if (flightDetails.getFlightId() ==  bs.getFlightDetails().getFlightId()) {
							isRequestExists = true;
						}
					} 
	     			if(!isRequestExists) {
	     				for (UserDetails ud :  Repository.USER_DETAILS) {
							if (userDetails.getUserId() == ud.getUserId()) {
								for (FilghtDetails flight : Repository.FLIGHT_DETAILS) {
									if (flight.getFlightId() == flightDetails.getFlightId()) {
										uf= ud;
										fd = flight;
										
											flag = true;
									     }
										
								       }
								   }	
	     				}
					
	              
						if (flag == true) {
							bookingDetails.setFlightDetails(fd);;
							
							bookingDetails.setUserDetails(uf);;
							Repository.BOOKING_DETAILS.add(bookingDetails);
						return bookingDetails;
						}
					}
			throw new AirlineException("Invalid request or you cannot request that book");
			

	}

}
