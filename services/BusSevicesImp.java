package com.RoamBus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RoamBus.access.exception.AdminException;
import com.RoamBus.exception.BusException;
import com.RoamBus.exception.LogException;
import com.RoamBus.model.Bus;
import com.RoamBus.repository.Admindao;
import com.RoamBus.repository.BusDao;

@Service
public class BusSevicesImp  implements BusService{
	
	
	static BusDao busdao;
	static Admindao admindao;

	@Override
	public Bus addBus(Integer adminId, Bus bus) throws BusException,AdminException {
		
		admindao.findById(adminId).orElseThrow(()-> new  AdminException("Please login.."));
		
		return busdao.save(bus);
		
	}
	

	@Override
	public Bus updateBus(Integer adminId, Bus bus) throws BusException, LogException {
		admindao.findById(adminId).orElseThrow(()-> new LogException("Please login fast..."));
		busdao.findById(bus.getBusId()).orElseThrow(()-> new BusException("Not found any BusId "+bus.getBusId()));
		return busdao.save(bus);
	}

	@Override
	public Bus deleteBus(Integer adminId, Integer busId) throws BusException, LogException {
		admindao.findById(adminId).orElseThrow(()-> new LogException("Please login fast..."));
		Bus exitbus = busdao.findById(busId).orElseThrow(()-> new BusException("Bus not exits with bus Id "+ busId));
		
		busdao.delete(exitbus);
		return exitbus;
		
		
	
	}

	@Override
	public Bus viewBus(Integer busId) throws BusException {
	
		return busdao.findById(busId).orElseThrow(()-> new BusException("Bus not exits with bu Id "+ busId));
	}

	@Override
	public List<Bus> viewBusByType(String busType) throws BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bus> viewAllBus() throws BusException {
		
		
		
		return null;
	}

	
	
	

}
