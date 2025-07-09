package com.example.travelPlanner.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travelPlanner.Model.TripModel;
import com.example.travelPlanner.Service.TripService;

@CrossOrigin(origins = "http://localhost:3000") // React default port


@RestController
//All end points in this controller will start with /api/trips
@RequestMapping("/api/trips")

//
public class TripController {
	
//	@Autowired
	private final TripService tripService;
	
	public TripController(TripService tripService) {
        this.tripService = tripService;
    }
	
	 @GetMapping
	    public List<TripModel> getAllTrips() {
	        // This would return a list of trips (normally from a service)
		 return tripService.getAll();
	    }

	    @PostMapping
	    public TripModel createTrip(@RequestBody TripModel trip) {
	        // This would handle a POST request to create a trip
	    	return tripService.createTrip(trip);
	    }

}
