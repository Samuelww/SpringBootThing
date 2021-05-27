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
    ListCarService listService;

    @GetMapping("/Cars")
    List<Cars> all() {
        return  listService.listAllCars();
    }

    @Autowired
    CreateCarService createService;

    @PostMapping("/Cars")
    Cars newCar(@RequestBody Cars newCar){
            newCar.setBrand(newCar.getBrand());
            newCar.setModel(newCar.getModel());


        return createService.createNewCar(newCar);

    }

    @Autowired
    UpdateCarService updateService;

    @RequestMapping(value = "/Cars/{id}", method = RequestMethod.PUT)
    Cars replaceCar(@RequestBody Cars newCar, @PathVariable Long id) throws Exception {

        return updateService.updateCar(id, newCar);
    }

    @Autowired
    DeleteCarService deleteService;

    @DeleteMapping("/Cars/{id}")
    void deleteCar(@PathVariable Long id) {
        deleteService.deleteCar(id);

    }
}