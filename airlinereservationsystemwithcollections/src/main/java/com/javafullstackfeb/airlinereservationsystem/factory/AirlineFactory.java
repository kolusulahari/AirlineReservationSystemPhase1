package com.javafullstackfeb.airlinereservationsystem.factory;

import com.javafullstackfeb.airlinereservationsystem.dao.Dao;
import com.javafullstackfeb.airlinereservationsystem.dao.DaoImpl;
import com.javafullstackfeb.airlinereservationsystem.service.Service;
import com.javafullstackfeb.airlinereservationsystem.service.ServiceImpl;

public class AirlineFactory {
	private AirlineFactory() {
		
	}
    public static Dao getAdminDAOImplInstance() {
    	Dao admindao=new DaoImpl();
    	return admindao;
    }
    public static Service getAdminServiceImplInstance() {
    	Service adminService=new ServiceImpl();
    	return adminService;
    }
    
}
