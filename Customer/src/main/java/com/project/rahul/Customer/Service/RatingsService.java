package com.project.rahul.Customer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.rahul.Customer.model.Ratings;
import com.project.rahul.Customer.repository.RatingRepo;

@Service
public class RatingsService {
    @Autowired
    RatingRepo delrepo;

    //To get all the ratings
    public List<Ratings> getallRatings(){
        return delrepo.findAll();
    }
    //To add a rating
    public Ratings addRating(Ratings ratings){
        return delrepo.save(ratings);
    }
    //To get ratings of specific washer
    public List<Ratings> washerSpecific(String washerName){
        List<Ratings> washerSpecificRatings=delrepo.findAll().stream().filter(x -> x.getWasherName().contains(washerName)).collect(Collectors.toList());
        return washerSpecificRatings;
    }
    //To delete a rating
    public String deleteRating(String id){
    	delrepo.deleteById(id);
        return "Rating with ID -> "+id+" deleted successfully";
    }
    //There is no need for a method to update a rating at this stage of project
}
