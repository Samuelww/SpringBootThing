package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {


    @Autowired
    CarsRepository repository;

    public Cars createNewCar(Cars car) {
        return repository.save(car);
    }



    public void deleteCar(Long id) {
        repository.findById(id);
        repository.deleteById(id);
    }



    public Optional<Cars> listCars(Long id) {
        return repository.findById(id);
    }


    public List<Cars> listAllCars() {
        return repository.findAll();
    }



    public Cars updateCar(Long id, Cars car) throws Exception {
        return repository.findById(id)
                .map(Car -> {
                    Car.setBrand(car.getBrand());
                    Car.setModel(car.getModel());
                    return repository.save(Car);
                })
                .orElseThrow(() -> new Exception("Not found"));
    }
}

