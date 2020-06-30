package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
@SuppressWarnings("serial")
@Data
public class BookingDetails implements Serializable{
	private FilghtDetails flightDetails;
	private UserDetails UserDetails;
	private int noofSeatsBooked;
}
