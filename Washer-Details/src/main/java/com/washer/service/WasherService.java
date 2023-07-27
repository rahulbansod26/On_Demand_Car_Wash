package com.washer.service;

import com.washer.model.Washer;

import java.util.List;

public interface WasherService {

    public Washer addWashers(Washer washer);

    public Washer findByName(String washerName);

    public List<Washer> getAllWashers();

    public Washer updateWasher(Washer washer);

}
