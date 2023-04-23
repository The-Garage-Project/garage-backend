package com.garageproject.gp.services;

import com.garageproject.gp.entities.Car;

import java.util.Optional;

public interface CarService {
    Iterable<Car> findAll();

    Car saveCar(Car car);

    Optional<Car> findById(Long id);

    void updateCar(Car car, Long id);

    void deleteCar(Long id);
}
