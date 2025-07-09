package com.example.travelPlanner.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class TripModel {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String destination;
	    private LocalDate startDate;
	    private LocalDate endDate;

	    // Getters, Setters, Constructors
	    
	    public TripModel() {}
	    
//	    @Getter =?lombok syntax?
	    public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    //to add others ..
	    public String getDestination() {
	        return destination;
	    }
	    
	    public void setDestination(String destination) {
	        this.destination = destination;
	    }
	    
	    public LocalDate getDate() {
	        return startDate;
	    }
	    
	    public void setStartDate(LocalDate sDate) {
	        this.startDate = sDate;
	    }
	    
	    public LocalDate getEndDate() {
	        return endDate;
	    }
	    
	    public void setEndDate(LocalDate eDate) {
	        this.endDate = eDate;
	    }
}



