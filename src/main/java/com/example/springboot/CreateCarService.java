package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class CreateCarService {


    @Autowired
    CarsRepository repository;

    public Cars createNewCar(Cars car) {
        return repository.save(car);
    }
}

@Service
 class DeleteCarService {

    @Autowired
    CarsRepository repository;

    public void deleteCar(Long id) {
        repository.findById(id);
        repository.deleteById(id);
    }
}

@Service
 class DetailCarService {
    @Autowired
    CarsRepository repository;

    public Optional<Cars> listCars(Long id) {
        return repository.findById(id);
    }
}

@Service
    class ListCarService {
    @Autowired
    CarsRepository repository;

    public List<Cars> listAllCars() {
        return repository.findAll();
    }
}

@Service
 class UpdateCarService {
    @Autowired
    CarsRepository repository;

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