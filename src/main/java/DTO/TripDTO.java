package DTO;

import java.util.Date;

/*
*  DTOs are additional classes used to decouple your API payloads (what your controller sends/receives) from your entities. So the goal is:
✅ Keep your entity classes (User, Trip) for persistence (e.g. JPA/Hibernate).
✅ Create DTO classes (UserDTO, TripDTO) for request/response mapping.*/

public class TripDTO {
    private long ID;
    private String destination;
    private Date startDate;
    private Date endDate;
//fields+setters+getters

    public Long getID(){
        return  this.ID;
    }

    public void setID(Long ID){
        this.ID=ID;
    }

    public String getDestination(){
        return  this.destination;
    }

    public void setDestination(String destination){
        this.destination=destination;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public void setEndDate(Date endDate){
        this.endDate=endDate;
    }
}

