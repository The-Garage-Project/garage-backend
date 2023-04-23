package com.garageproject.gp.entities;

import com.garageproject.gp.enums.FuelTypeEnum;
import com.garageproject.gp.enums.TransmissionEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //brand name
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandName;
    //model
    private String model;
    //year of make
    private String yearOfMake;
    //cc
    private String engineSize;
    //hp
    private String horsePower;
    //transmission
    private TransmissionEnum transmission;
    //category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CarCategory category;
    //color
    private String color;
    //number plate
    private String numberPlate;
    //doors
    private Integer numDoors;
    //chairs
    private Integer numChairs;
    //fuel
    private FuelTypeEnum fuelType;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(String yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Integer getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(Integer numDoors) {
        this.numDoors = numDoors;
    }

    public Integer getNumChairs() {
        return numChairs;
    }

    public void setNumChairs(Integer numChairs) {
        this.numChairs = numChairs;
    }

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }
}
