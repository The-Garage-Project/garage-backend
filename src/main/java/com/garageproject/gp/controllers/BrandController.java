package com.garageproject.gp.controllers;

import com.garageproject.gp.entities.Brand;
import com.garageproject.gp.services.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
@Slf4j
public class BrandController {
    private final BrandService brandService;
    @GetMapping("/get-all")
    @CrossOrigin
    public Iterable<Brand> getAll() {
        return brandService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveBrand(@RequestBody Brand brand) {
        try {
            brandService.saveBrand(brand);
        } catch (Exception ex) {
            log.error("Failed to save new brand with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Optional<Brand>> getById(@PathVariable Long id) {
        Optional<Brand> brand = brandService.findById(id);
        if (brand.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(brand);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<HttpStatus> deleteBrand(@PathVariable Long id) {
        try {
            brandService.deleteBrand(id);
        } catch (Exception ex) {
            log.error("Failed to delete brand with id: " + id + " with exception: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Deleted brand with id: " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
