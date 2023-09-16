package com.garageproject.gp.controllers;

import com.garageproject.gp.entities.Car;
import com.garageproject.gp.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
@Slf4j
public class CarController {
    private final CarService carService;

    @GetMapping("/get-all")
    @CrossOrigin
    public @ResponseBody Iterable<Car> getAll() {
        return carService.findAll();
    }

    @PostMapping("/add")
    @CrossOrigin
    public ResponseEntity<HttpStatus> saveCar(@RequestBody Car carToAdd) {
        try {
            carService.saveCar(carToAdd);
        } catch (Exception ex) {
            log.error("Failed to save new car with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Car>> getById(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        if (car.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(car);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Long id) {
        try {
            carService.updateCar(car, id);
        } catch (Exception ex) {
            log.error("Failed to update car with id: " + id + "with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Updated car with id: " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCar(id);
        } catch (Exception ex) {
            log.error("Failed to delete car with id: " + id + " with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Deleted car with id: " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{searchKeyword}")
    @CrossOrigin
    public ResponseEntity<Iterable<Car>> search(@PathVariable String searchKeyword) {
        List<Car> results;
        try {
            results = carService.search(searchKeyword);
        } catch (Exception ex) {
            log.error("Failed to search for keyword: " + searchKeyword + " with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(results);
    }
}
