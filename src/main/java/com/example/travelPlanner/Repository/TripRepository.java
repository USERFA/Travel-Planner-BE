package com.example.travelPlanner.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.travelPlanner.Model.TripModel;

@Repository

//has built it methods to interact with the DB (like a Data  Access Object layer))
//inherits from JPARepo so findAll, findByID, deleteByID ,save are inherited by default 

public interface TripRepository extends JpaRepository<TripModel, Long> {
	
//	Default CRUD methods do not have to be explicitly declared here
	
/*also when you declare a custom function, Spring Data JPA generates
	the code automatically at runtime based on the method name (query method derivation)
	*/


    List<TripModel> findByDestination(String destination); //code will be generate automatically by spring data JPA
    
}
