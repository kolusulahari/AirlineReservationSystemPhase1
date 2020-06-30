package com.javafullstackfeb.airlinereservationsystem.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class FilghtDetails {
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int noofseatsavailable;
	private LocalDateTime arrivalDateTime;
	private LocalDateTime departureDateTime;
}