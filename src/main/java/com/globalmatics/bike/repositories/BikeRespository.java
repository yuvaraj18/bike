package com.globalmatics.bike.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmatics.bike.model.Bike;

public interface BikeRespository extends JpaRepository<Bike, Long> {


}
