package com.example.travelPlanner.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travelPlanner.Model.TripModel;
import com.example.travelPlanner.Repository.TripRepository;

@Service

public class TripService {
	
//	Sits between the controller and repository
	
//	@Autowired
	private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripModel createTrip(TripModel trip) {
    	return this.tripRepository.save(trip);
    }
    
    public List<TripModel> getAll(){
    	return this.tripRepository.findAll();
    }
    
    public void deleteTrip(Long ID) {
    	this.tripRepository.deleteById(ID);
    	
    }
    
    public TripModel getTripByID(Long ID) {
    	return this.tripRepository.getOne(ID);
    }
    
    public List<TripModel> getByDestination(String destination) {
    	return this.tripRepository.findByDestination(destination);
    }
}
