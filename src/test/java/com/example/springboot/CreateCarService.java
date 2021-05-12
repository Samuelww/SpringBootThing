package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@Service
public class CreateCarService {


    @Autowired
    CarsRepository repository;

    public Cars createNewUser(Cars car) {
        return repository.save(car);
    }
}

@Service
public class DeleteCarService {

    @Autowired
    CarsRepository repository;

    public void deleteCar(Long id) {
        repository.findById(id);
        repository.deleteById(id);
    }
}

@Service
public class DetailUserService {
    @Autowired
    CarsRepository repository;

    public Cars listCars(Long id) {
        return repository.findById(id);
    }
}

@Service
public class ListUserService {
    @Autowired
    CarsRepository repository;

    public List<Cars> listAllUsers() {
        return repository.findAll();
    }
}

@Service
public class UpdateUserService {
    @Autowired
    CarsRepository repository;

    public Cars updateUser(Long id, Cars car) {
        repository.findById(id);
        car.setId(id);
        return repository.save(car);
    }

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {
    @Mock
    private CarsRepository carsRepository;
    @InjectMocks
    private CreateCarService createUserService;

    @Test
    public void whenSaveUser_shouldReturnUser() {
        Cars car = new Cars();
        car.setBrand("Test");
        when(carsRepository.save(ArgumentMatchers.any(Cars.class))).thenReturn(car);
        Cars created = createUserService.createNewUser(car);
        assertThat(created.getBrand()).isSameAs(car.getBrand());
        verify(carsRepository).save(car);
    }
}