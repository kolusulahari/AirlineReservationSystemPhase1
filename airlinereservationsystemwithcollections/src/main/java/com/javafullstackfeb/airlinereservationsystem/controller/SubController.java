package com.javafullstackfeb.airlinereservationsystem.controller;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.javafullstackfeb.airlinereservationsystem.dto.AdminDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.BookingDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.FilghtDetails;
import com.javafullstackfeb.airlinereservationsystem.dto.UserDetails;
import com.javafullstackfeb.airlinereservationsystem.exception.AirlineException;
import com.javafullstackfeb.airlinereservationsystem.factory.AirlineFactory;
import com.javafullstackfeb.airlinereservationsystem.repository.Repository;
import com.javafullstackfeb.airlinereservationsystem.service.Service;
import com.javafullstackfeb.airlinereservationsystem.service.ServiceImpl;
import com.javafullstackfeb.airlinereservationsystem.validation.Validations;

import lombok.extern.log4j.Log4j;
@SuppressWarnings("unused")
@Log4j

public class SubController {
	
	public static void arsController() throws Exception{

		Repository.dataBase();
		Validations validation = new Validations();
		Service service = AirlineFactory.getAdminServiceImplInstance(); 

		boolean exit = false;
		int checkId = 0;
		String checkName = null;
		long checkMobile = 0;
		
		long checkMobileno=0;
		String checkEmail = null;
		String checkPassword = null;
		int flightId = 0;
		String flightName = null;
		String flightSource = null;
		String flightDestination = null;
	    int SeatsAvailable = 0;
	    LocalDateTime arrivalDateTime=null;
	    LocalDateTime departureDateTime=null;
		

		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info("<*********************** WELCOME TO AIRLINE RESERVATION SYSTEM *******************");
				log.info("1. Admin Page");
				log.info("2. User Page");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					//Service service = AirlineFactory.getAdminServiceImplInstance(); 
					do {
						try {
							log.info("1. Admin Registration");
							log.info("2. Admin Login");
							log.info("3. Exit");
							int choice1 = scanner.nextInt();
							switch (choice1) {
							
						
						case 1:
							 try {
								 do {
									try {
										log.info("Enter ID : ");
										checkId = scanner.nextInt();
										exit = true;
									} catch (InputMismatchException e) {
										log.error("ID should consist of only digits");
										exit = false;
										scanner.next();
									} catch (AirlineException e) {
										exit = false;
										log.error(e.getMessage());
									}
								} while (!exit);
								 
								 do {
										try {
											log.info("Enter Your Name : ");
											checkName = scanner.next();
											service.validatingName(checkName);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error("Name should consists of only Alphabates");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Your MobileNumber : ");
											checkMobile = scanner.nextLong();
											service.validatingMobile(checkMobile);
											exit = true;
										} catch (InputMismatchException e) {
											log.error("Mobile Number  should consists of only numbers");
											exit = false;
											scanner.next();
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Email to Register : ");
											checkEmail = scanner.next();
											service.validatingEmail(checkEmail);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error(" Email should consist of numbers and alphabets");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Password :");
											checkPassword = scanner.next();
											service.validatingPassword(checkPassword);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error("Password doesnt accept spaces ");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);

									AdminDetails bean = new AdminDetails();
									bean.setId(checkId);
									bean.setName(checkName);
									bean.setMobileNo(checkMobile);
									bean.setEmailId(checkEmail);
									bean.setPassword(checkPassword);

									boolean check = service.registeringAdmin(bean);
									if (check) {
										log.info("You have registered Successfully");
									} else {
										log.info("Already registered");
									}
									break;
				                  }catch (InputMismatchException e) {
				      				log.error("Invalid entry ");
				      				
				    				scanner.next();
				    				break;
				    			}
				                  catch (AirlineException e) {
									log.info(e.getMessage());
									break;
								}
							
						case 2:
							log.info("Enter registered email to login : ");
							String email = scanner.next();
							log.info("Enter registered Password to login : ");
							String password = scanner.next();
							try {
								AdminDetails adminDetails = service.checkAdmin(email, password);
								if (adminDetails != null) {
									log.info("Logged in successfullyyy...!!!");
								do {
									try {
										log.info("1.   Add Flights");
										log.info("2.   Remove Flight");
										log.info("3.   View All FlightDetails");
										log.info("4.   Logout");
										int choice2 = scanner.nextInt();
										switch (choice2) {
										case 1:

											do {
												log.info("Enter FlightID to add : ");
												flightId = scanner.nextInt();
												try {
													service.validatingFlightID(flightId);
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("Id should contains only digits");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												log.info("Enter FlightName : ");
												flightName= scanner.next();
												try {
													service.validatingFlightName(flightName);
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("FlightName should contains only Alphabets");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												try {
												log.info("Enter Source : ");
												flightSource = scanner.next();
												
													service.validatingSource(flightSource);
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("Source should contains only Alphabates");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												log.info("Enter Destination : ");
												flightDestination = scanner.next();
												try {
													service.validatingDestination(flightDestination);
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("Destination should contains only Alphabates");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												log.info("Enter No.of seat Available in the Flight : ");
												SeatsAvailable = scanner.nextInt();
												try {
							
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("noofSeatsAvailable should contains only digits");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												log.info("Enter  Flight Arrival Date Time : ");
												 arrivalDateTime=LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
												try {
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("its should contains only digits");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											do {
												log.info("Enter  Flight departure Date Time : ");
												 departureDateTime=LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
												try {
													exit = true;
												} catch (InputMismatchException e) {
													exit = false;
													log.error("its should contains only digits");
												} catch (AirlineException e) {
													exit = false;
													log.error(e.getMessage());
												}
											} while (!exit);
											FilghtDetails bean1 = new FilghtDetails();
											bean1.setFlightId(flightId);
											bean1.setFlightName(flightName);
											bean1.setSource(flightSource);
											bean1.setDestination(flightDestination);
											bean1.setNoofseatsavailable(SeatsAvailable);
											bean1.setArrivalDateTime(arrivalDateTime);
											bean1.setDepartureDateTime(departureDateTime);
											boolean check2 = service.addingFlights(bean1);
											if (check2) {
												log.info("Flight added of id = " + flightId);
											} else {
												log.info("Flight already exist of id = " + flightId);
											}
											break;
										case 2:
											log.info("Remove Flight ");
											log.info("Enter Flight Id");
											int flightId3 = scanner.nextInt();
											service.validatingFlightID(flightId3);
											try {
											if (flightId3 == 0) {
												log.info("Please Enter the Valid FlightId");
											} else {
												FilghtDetails bean6 = new FilghtDetails();
												bean6.setFlightId(flightId3);
												boolean remove = service.deletingFlight(flightId3);
												if (remove) {
													log.info("The Flight is removed of Id = " + flightId3);
												} else {
													log.error("Not Found Any Flight With This Id");
												}
											}
											} catch (InputMismatchException e) {
												log.error("Invalid entry valid Id");
												scanner.nextLine();
											} catch (AirlineException e) {
												log.info(e.getMessage());
											}
											break;
										case 3:
											List<FilghtDetails> info = service.getFlightDetails();
											for (FilghtDetails flightBean : info) {
												if (flightBean != null) {
													log.info(flightBean.getFlightId()+"       " + flightBean.getFlightName()+"        " +flightBean.getSource()+"   to    " + flightBean.getDestination()+"        " +flightBean.getArrivalDateTime()+"        " +flightBean.getDepartureDateTime()+"      " +flightBean.getNoofseatsavailable() +" (Seats Available)");
												} else {
													log.info("No Flight are available in the Flight Details");
												}
											}
											break;
										case 4:
											log.info("Logged Out Successfully....!!!");
											arsController();

										default:
											log.info("Invalid!! Please Enter Valid Choice");
											break;
										}  // Switch3 closing
									} catch (InputMismatchException e) {
										log.error("Invalid entry please provide only positive integer");
										scanner.nextLine();
									}
								} while (true);
								} else {
									log.info("EmailId ***");
								}
							} catch (AirlineException e) {
								log.info(e.getMessage());
							}
							break;
						case 3:
							arsController();
							break;

						default:
							log.info(" Invalid!! Please Enter Valid Choice");
							break;
						} // switch2 closing
					} catch (InputMismatchException e) {
						log.error("Invalid entry please provide only positive integer");
						scanner.nextLine();
					}
				} while (true);
				case 2:
					//Service service1 = new ServiceImpl();
					do {
						try {
							log.info("1. User Register");
							log.info("2. User Login");
							log.info("3. Exit");
							int choice3 = scanner.nextInt();
							switch (choice3) {
							case 1:
								try {
									do {
										try {
											log.info("Enter ID : ");
											checkId = scanner.nextInt();
											exit = true;
										} catch (InputMismatchException e) {
											log.error("ID should consist of only digits");
											exit = false;
											scanner.next();
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);

									do {
										try {
											log.info("Enter Your Name : ");
											checkName = scanner.next();
											service.validatingName(checkName);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error("Name should consists of only Alphabates");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Your MobileNumber : ");
											checkMobile = scanner.nextLong();
											service.validatingMobile(checkMobile);
											exit = true;
										} catch (InputMismatchException e) {
											log.error("Mobile Number  should consists of only numbers");
											exit = false;
											scanner.next();
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Email to Register : ");
											checkEmail = scanner.next();
											service.validatingEmail(checkEmail);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error(" Email should consist of numbers and alphabets");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);
									do {
										try {
											log.info("Enter Password :");
											checkPassword = scanner.next();
											service.validatingPassword(checkPassword);
											exit = true;
										} catch (InputMismatchException e) {
											exit = false;
											log.error("Password doesnt accept spaces ");
										} catch (AirlineException e) {
											exit = false;
											log.error(e.getMessage());
										}
									} while (!exit);

									UserDetails bean1 = new UserDetails();
									bean1.setUserId(checkId);
									bean1.setUserName(checkName);
									bean1.setMobileNumber(checkMobile);
									bean1.setEmailId(checkEmail);
									bean1.setPassword(checkPassword);

									boolean check = service.registeringUser(bean1);
									if (check) {
										log.info("Registered Successfully");
									} else {
										log.info("Already registered");
									}
									break;
									 }catch (InputMismatchException e) {
						      				log.error("Invalid entry ");
						    				scanner.nextLine();
						    				break;
						    			}
						                catch (AirlineException e) {
											log.info(e.getMessage());
											break;
										}
								
						       case 2:
						    	   log.info("Enter registered email  : ");
							String email = scanner.next();
							log.info("Enter registered Password : ");
							String password = scanner.next();
							try {
								UserDetails userBean = service.checkUser(email, password);
								if (userBean != null) {
									log.info("Logged In Successfully....!!!");
									do {
									try {
										
										log.info("1.   Search Flight By Source");
										log.info("2.   Search Flight By Destination");
										log.info("3.   Search Flight By Name");
										log.info("4.   View All Flight Details");
										log.info("5.   Book The Flight");
										log.info("6.   Logout");
										int choice2 = scanner.nextInt();
										switch (choice2) {
										case 1:
											log.info("Search Flight Details by Source : ");
											String source = scanner.next();

											FilghtDetails bean3 = new FilghtDetails();
											bean3.setSource(source);
											List<FilghtDetails> flightSource1 = service.searchFlightBySourceInUser(source);
											for (FilghtDetails flightBean : flightSource1) {
												if (flightBean!= null) {
													log.info(flightBean.getFlightId()+"       " + flightBean.getFlightName()+"        " +flightBean.getSource()+"   to    " + flightBean.getDestination()+"        " +flightBean.getArrivalDateTime()+"        " +flightBean.getDepartureDateTime()+"      " +flightBean.getNoofseatsavailable() +" (Seats Available)");
												} else {
													log.info("No Flights are available with this Source");
												}
											}
											break;

										case 2:

											log.info("Search flight by Destination : ");
											String destination= scanner.next();

											FilghtDetails bean4 = new FilghtDetails();
											bean4.setDestination(destination);
											List<FilghtDetails> flightDestination1 = service.searchFlightByDestinationInUser(destination);
											
											for (FilghtDetails flightBean : flightDestination1) {
												if (flightBean != null) {
													log.info(flightBean.getFlightId()+"       " + flightBean.getFlightName()+"        " +flightBean.getSource()+"   to    " + flightBean.getDestination()+"        " +flightBean.getArrivalDateTime()+"        " +flightBean.getDepartureDateTime()+"      " +flightBean.getNoofseatsavailable() +" (Seats Available)");
												
												} else {
													log.info("No Flights are available with this Destination");
												}
											}
											break;
										case 3:
											log.info(" Search Flight by Name : ");
											String name = scanner.next();

											FilghtDetails bean5 = new FilghtDetails();
											bean5.setFlightName(name);
											List<FilghtDetails> fname = service.searchFlightByNameInUser(name);
											
											for (FilghtDetails flightBean : fname) {
												if (flightBean!= null ) {
													log.info(flightBean.getFlightId()+"       " + flightBean.getFlightName()+"        " +flightBean.getSource()+"   to    " + flightBean.getDestination()+"        " +flightBean.getArrivalDateTime()+"        " +flightBean.getDepartureDateTime()+"      " +flightBean.getNoofseatsavailable() +" (Seats Available)");
												
												} else {
													log.info("No Flights are available with this Name");
												}
											}
											break;
										case 4:
											List<FilghtDetails> info = service.getFlightDetails();
											
											for (FilghtDetails flightBean : info) {
												if (flightBean != null) {
													log.info(flightBean.getFlightId()+"       " + flightBean.getFlightName()+"        " +flightBean.getSource()+"   to    " + flightBean.getDestination()+"        " +flightBean.getArrivalDateTime()+"        " +flightBean.getDepartureDateTime()+"      " +flightBean.getNoofseatsavailable() +" (Seats Available)");
												
												} else {
													log.info("No Flight are available in the Flight Details");
												}
											}
											break;
										case 5:
											log.info("Enter User Id : ");
											int userId2 = scanner.nextInt();
                                             
										     UserDetails userBean1 = new UserDetails();
											userBean.setUserId(userId2);
											log.info("Enter Flight Id : ");
											int flightId2 = scanner.nextInt();
											FilghtDetails flightDetails1 = new FilghtDetails();                                    
                                             flightDetails1.setFlightId(flightId2);
                                             log.info("Enter No of seats : ");
                                             int seats=scanner.nextInt();
                                             BookingDetails bookingStatus=new BookingDetails();
                                             bookingStatus.setNoofSeatsBooked(seats);
                                             
                                             
											try {
												BookingDetails request = service.requestBook(userBean, flightDetails1);
												log.info("Requested to Airline Management ");
												log.info(
														request.getFlightDetails().getFlightId() + " "+ 
														request.getFlightDetails().getFlightName()  + " "+ 
														request.getUserDetails().getUserId()  + " "+ 
														request.getUserDetails().getUserName()  + " "+ 
														request.getFlightDetails().getSource()  + " "+ 
														request.getFlightDetails().getDestination()  + " "+ 
														request.getFlightDetails().getArrivalDateTime()  + " "+ 
														request.getFlightDetails().getDepartureDateTime()  + " "+ 
														bookingStatus.getNoofSeatsBooked()
														);
											} catch(InputMismatchException e) {
												log.error("Invalid Entry");
												scanner.nextLine();
											} 
											catch (Exception e) {
												log.info("Invalid Request of booking");
											}
											break;
										case 6:
											arsController();

										default:
											log.error("Please Enter Valid Choice....!!!");
											break;
										}
									} catch (InputMismatchException e) {
										log.error("Invalid entry please provide only positive integer");
										scanner.nextLine();
									} catch(AirlineException e) {
										log.info(e.getMessage());
									}
								} while (true);
								}
							}catch (InputMismatchException e) {
									System.err.println("Invalid entry please provide 1 or 2 or 3 or 4 or 5 or 6");
									scanner.nextLine();
								} catch (AirlineException e) {
									log.info(e.getMessage());
								}
						case 3:
							arsController();
							break;

						default:
							log.error(" Invalid!! Please Enter Valid Choice");
							//System.err.println("Choice must be 1 or 2");
							break;
						}
					} catch (InputMismatchException e) {
						log.error("Invalid entry please provide only positive integer");
						scanner.nextLine();
					} catch(AirlineException e) {
						log.info(e.getMessage());
					}
				} while (true);
			}
		} catch (InputMismatchException e) { 
			log.error("Invalid entry please provide only positive integer");
			scanner.nextLine();
		}
	} while (true);
}
}