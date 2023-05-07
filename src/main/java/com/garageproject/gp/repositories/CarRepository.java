package com.garageproject.gp.repositories;

import com.garageproject.gp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE (c.brandName.name LIKE %?1%) OR (c.model LIKE %?1%)")
    List<Car> findByBrandNameContaining(String brandName);
}
