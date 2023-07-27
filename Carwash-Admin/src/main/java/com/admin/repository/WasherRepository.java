package com.admin.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer,Integer> {

    public List<Washer> findAll();

    public Washer findByName(String name);

}