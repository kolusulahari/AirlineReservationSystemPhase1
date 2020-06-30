package com.javafullstackfeb.airlinereservationsystem.service;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystem.dao.Dao;
import com.javafullstackfeb.airlinereservationsystem.dto.AdminDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.FilghtDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserDetails;
import com.javafullstackfeb.airlinereservationsystem.validation.Validations;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.AirlineFactory;

public class ServiceImpl implements Service{
	Dao daoRef = AirlineFactory.getAdminDAOImplInstance();
    Validations validation=new Validations();
    
  //*****************Admin Operations ***********************//  
	@Override
	public boolean registeringAdmin(AdminDetails adminDetails) {
		if(adminDetails!=null) {
			return daoRef.registeringAdmin(adminDetails);
		   }
		   throw new AirlineException("Enter correct details");
	}
	
	@Override
	public AdminDetails checkAdmin(String email, String password)   {
		if(validation.emailValidation(email)) {
			if(validation.passwordValidation(password)) {
				return daoRef.checkAdmin(email, password);
			}
		}
		 return null;
	
	}
	
	
	@Override
	public boolean addingFlights(FilghtDetails flightDetails) {
		if(flightDetails!=null) {
			return daoRef.addingFlights(flightDetails);
			}
			throw new AirlineException("Enter Correct details");
			
	}
	@Override
	public boolean deletingFlight(int flightId) {
		if (validation.idValidation(flightId)) {
			return daoRef.deletingFlight(flightId);
		}
		return false;
	}
	@Override
	public List<FilghtDetails> getFlightDetails() {
		return daoRef.getFlightDetails();
	}
	@Override
	public boolean bookingStatus(UserDetails userDetails, FilghtDetails flightDetails) {
		return false;
	}
	
	//************************* User Operations *************************//
	
	@Override
	public boolean registeringUser(UserDetails userDetails) {
		if(userDetails!=null) {
			return daoRef.registeringUser(userDetails);
		   }
		   return false;
	}
	@Override
	public UserDetails checkUser(String emailId, String password) {
		if(validation.emailValidation(emailId)) {
			if(validation.passwordValidation(password)) {
				return daoRef.checkUser(emailId, password);
			}
		}
		 return null;
	}
	@Override
	public List<FilghtDetails> searchFlightByNameInUser(String flightname) {
		if (validation.nameValidation(flightname)) {
			return daoRef.searchFlightByNameInUser(flightname);
		}
		return null;
	}
	@Override
	public List<FilghtDetails> searchFlightBySourceInUser(String source) {
		if (validation.sourceValidation(source)) {
			return daoRef.searchFlightBySourceInUser(source);
		}
		return null;
	}
	@Override
	public List<FilghtDetails> searchFlightByDestinationInUser(String destination) {
		if (validation.destinationValidation(destination)) {
			return daoRef.searchFlightByDestinationInUser(destination);
		}
		return null;
	}
	@Override
	public List<FilghtDetails> getFlightDetailsInUser() {
		return daoRef.getFlightDetailsInUser();

	}
	@Override
	public BookingDetails requestBook(UserDetails userDetails, FilghtDetails flightDetails) {
		if (userDetails != null && flightDetails != null) {
			return daoRef.requestBook(userDetails, flightDetails);
		}
		return null;
	}
	
	//************************ Service Validation *********************//
	
	@Override
	public boolean validatingFlightID(int flightid) {
		if(validation.idValidation(flightid)){
		  return true;
		}
		throw new AirlineException("Invalid Id! Id should contain exactly 4 positive digits");
	}
	@Override
	public boolean validatingFlightName(String flightname) {
	    if(validation.nameValidation(flightname)) {
	    	return true;
	    }
	    throw new AirlineException("Invalid Name! Name should have atleast 4 characters");
	}
	@Override
	public boolean validatingSource(String source) {
      if(validation.sourceValidation(source)) {
    	  return true;
      }
      
      throw new AirlineException("Invalid Source! Source should have atleast 4 characters");
	}

	@Override
	public boolean validatingDestination(String destination) {
		if(validation.destinationValidation(destination)) {
			return true;
		}
		throw new AirlineException("Invalid Destination! Destination should have atleast 4 characters");
	}

	@Override
	public boolean validatingName(String checkName) {
		 if(validation.nameValidation(checkName)) {
		    	return true;
		    }
		    throw new AirlineException("Invalid Name! Name should have atleast 4 characters");
	}
	
	@Override
	public boolean validatingMobile(long checkMobile) {
		if(validation.mobileValidation(checkMobile)) {
			return true;
		}
		throw new AirlineException("Enter Proper Mobile Number");
	}

	@Override
	public boolean validatingEmail(String checkEmail) {
		if(validation.emailValidation(checkEmail)) {
		return false;
		}
		throw new AirlineException("Enter proper email such that it should consist of numbers and alphabets For ex:- chandu3@gmail.com");
	}

	@Override
	public boolean validatingPassword(String checkPassword) {
		if(validation.passwordValidation(checkPassword)) {
		return false;
		}
		throw new AirlineException("Password should contain atleast 6 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) For ex:- @Chandu123");
	}


}
