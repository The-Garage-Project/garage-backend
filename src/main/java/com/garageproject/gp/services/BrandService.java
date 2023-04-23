package com.garageproject.gp.services;

import com.garageproject.gp.entities.Brand;

import java.util.Optional;

public interface BrandService {
    Iterable<Brand> findAll();
    Optional<Brand> findById(Long id);
    Brand saveBrand(Brand brand);
    void deleteBrand(Long id);
}
