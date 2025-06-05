package com.example.travelPlanner.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Reservation") // to rename the db name
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long ID;
	//1 reservation has one user
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
