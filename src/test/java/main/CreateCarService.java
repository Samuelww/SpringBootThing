package main;

import com.example.springboot.Cars;
import com.example.springboot.CarsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    public List<Cars> listAllUsers() {
        return repository.findAll();
    }
}

@Service
 class UpdateUserService {
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
    private CreateCarService carService;

    @Test
    public void whenSaveCar_shouldReturnCar() {
        Cars car = new Cars();
        car.setBrand("Test");
        when(carsRepository.save(ArgumentMatchers.any(Cars.class))).thenReturn(car);
        Cars created = carService.createNewCar(car);
        assertThat(created.getBrand()).isSameAs(car.getBrand());
        verify(carsRepository).save(car);
    }
    @Test
    public void whenDeleteCar_shouldReturnCar() {
        Cars car = new Cars();
        when(carsRepository.delete(ArgumentMatchers.any(Cars.class))).thenReturn(car);
        Cars deleted = carService(car);
        assertThat(deleted.getBrand()).isSameAs(car.getBrand());
        verify(carsRepository).delete(car);
    }

}
}