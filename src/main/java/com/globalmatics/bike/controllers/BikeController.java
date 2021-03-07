package com.globalmatics.bike.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globalmatics.bike.model.Bike;
import com.globalmatics.bike.repositories.BikeRespository;

@RestController
@RequestMapping("api/v1/bikes")
public class BikeController {

    @Autowired
    private BikeRespository bikeRepsitory;

    @GetMapping
    public List<Bike> list(){
        List<Bike> bikes = new ArrayList<>();
        return bikeRepsitory.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createBike(@RequestBody Bike bike){
            bikeRepsitory.save(bike);
    }

    @GetMapping("{id}")
    public Optional<Bike> getBike(@PathVariable("id") long id){
        return bikeRepsitory.findById(id) ;
    }
}
