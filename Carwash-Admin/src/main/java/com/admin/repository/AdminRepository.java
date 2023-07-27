package com.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.Washpacks;

@Repository
public interface AdminRepository extends MongoRepository<Washpacks , Integer> {

    public Washpacks findById(int id);

}