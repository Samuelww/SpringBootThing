package com.example.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class CarsController {

    private final CarsRepository repository;


    CarsController(CarsRepository repository) {
        this.repository = repository;
    }

    @Autowired
    CarService carService;

    @GetMapping("/Cars")
    List<Cars> all() {
        return  carService.listAllCars();
    }


    @PostMapping("/Cars")
    Cars newCar(@RequestBody Cars newCar){
            newCar.setBrand(newCar.getBrand());
            newCar.setModel(newCar.getModel());


        return carService.createNewCar(newCar);

    }


    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.PUT)
    Cars replaceCar(@RequestBody Cars newCar, @PathVariable Long id) throws Exception {

        return carService.updateCar(id, newCar);
    }


    @DeleteMapping("/Cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

    }
}