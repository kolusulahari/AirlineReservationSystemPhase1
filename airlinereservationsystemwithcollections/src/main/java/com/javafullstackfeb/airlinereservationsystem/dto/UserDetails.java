package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings("serial")
@Data
public class UserDetails implements Serializable{
		private int userId;
		private String userName;
		private String emailId;
		@ToString.Exclude
		private String password;
		private long mobileNumber;
		
}

