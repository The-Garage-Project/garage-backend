package com.garageproject.gp.services.impl;

import com.garageproject.gp.entities.Car;
import com.garageproject.gp.repositories.CarRepository;
import com.garageproject.gp.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        Iterable<Car> cars = findAll();
        for (Car car1 : cars) {
            if (Objects.equals(car1.getNumberPlate(), car.getNumberPlate())) {
                throw new DuplicateKeyException("Car with the same number plate already exists.");
            }
        }
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void updateCar(Car car, Long id) {
        Optional<Car> savedCar = carRepository.findById(id);
        if (savedCar.isEmpty()) {
            throw new NoSuchElementException("The car with id: " + id + " does not exist.");
        }
        savedCar.map(car1 -> {
            car1.setId(id);
            car1.setColor(car.getColor());
            car1.setCategory(car.getCategory());
            car1.setBrandName(car.getBrandName());
            car1.setModel(car.getModel());
            car1.setEngineSize(car.getEngineSize());
            car1.setFuelType(car.getFuelType());
            car1.setHorsePower(car.getHorsePower());
            car1.setNumberPlate(car.getNumberPlate());
            car1.setNumChairs(car.getNumChairs());
            car1.setNumDoors(car.getNumDoors());
            car1.setTransmission(car.getTransmission());
            car1.setYearOfMake(car.getYearOfMake());
            return carRepository.save(car1);
        });
    }

    @Override
    public void deleteCar(Long id) {
        if (carRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("The car with id: " + id + " does not exist.");
        }
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> search(String searchKeyword) {
        return carRepository.findByBrandNameContaining(searchKeyword);
    }
}
