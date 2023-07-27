package com.washer.repository;

import com.washer.model.Washer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasherRepository extends MongoRepository<Washer,Integer> {

    public List<Washer> findAll();

    //public Washer findByName(String washerName);

}