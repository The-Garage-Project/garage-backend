package com.garageproject.gp.services.impl;

import com.garageproject.gp.entities.Brand;
import com.garageproject.gp.repositories.BrandRepository;
import com.garageproject.gp.services.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    @Override
    public Iterable<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        if (brandRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("The brand with id: " + id + " does not exist.");
        }
        brandRepository.deleteById(id);
    }
}
