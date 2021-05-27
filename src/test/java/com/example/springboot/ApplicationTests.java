package com.example.springboot;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	public void testAdd() {
		assertEquals(42, Integer.sum(19, 23));
	}

@RunWith(MockitoJUnitRunner.class)
public class CreateUserServiceTest {
    @Mock
    private CarsRepository carsRepository;
    @InjectMocks
    private CarService carService;

    @Test
    public void whenSaveCar_shouldReturnCar() {
        Cars car = new Cars();
        car.setBrand("Test");
        car.setModel("Test");
        Mockito.when(carsRepository.save(ArgumentMatchers.any(Cars.class))).thenReturn(car);
        Cars created = carService.createNewCar(car);
        AssertionsForClassTypes.assertThat(created.getBrand()).isSameAs(car.getBrand());
        Mockito.verify(carsRepository).save(car);
    }
//    @Test
//    public void whenDeleteCar_shouldReturnCar(@PathVariable Long id) {
//        Cars car = new Cars();
//        repository.deleteById(id);
//        Mockito.verify(carsRepository).delete(car);
//    }

}

}
