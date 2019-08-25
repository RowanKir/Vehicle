package Vehicle.Repository;

import Vehicle.Domain.Car;
import Vehicle.Factory.CarFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.*;

public class CarRepositoryTest {

    private CarRepository carRepository;

    private Car car1 = CarFactory.getCar(UUID.randomUUID().toString(), 97, "BMW", "M5");
    private Car car2 = CarFactory.getCar(UUID.randomUUID().toString(), 98, "Mercedes", "C63 AMG");

    @Before
    public void setUp() throws Exception
    {
        this.carRepository = CarRepository.getCarRepository();
    }

    @Test
    public void removeAll()
    {
        this.carRepository.create(car1);
        this.carRepository.create(car2);
        HashMap<String, Car> temp = this.carRepository.getAll();
        System.out.println("Value before removeAll: \n" +temp.values());
        this.carRepository.removeAll();
        System.out.println("Value after removeAll: \n" +temp.values());
        assertEquals(0, temp.size());
    }

    @Test
    public void getAll()
    {
        this.carRepository.create(car1);
        this.carRepository.create(car2);
        HashMap<String, Car> temp = this.carRepository.getAll();
        assertNotNull(temp);
        System.out.println("All the values in the temporary getAll() method" +temp.values());
    }

    @Test
    public void create()
    {
        assertEquals(car1.getReg(), this.carRepository.create(car1).getReg());
        assertNotNull(this.carRepository.getAll());
        System.out.println("Created car: " +car1.toString() + "\n");
    }

    @Test
    public void update()
    {
        this.carRepository.create(car1);
        Car updatedCar = CarFactory.getCar(UUID.randomUUID().toString(), 2020, "BMW", "M5 Competition");
        System.out.println("Updated: " +this.carRepository.read(car1.getReg()).toString());
        this.carRepository.update(updatedCar);
        System.out.println("To: " + this.carRepository.read(updatedCar.getReg().toString()) +"\n");
        assertEquals(car1.getReg(), updatedCar.getReg());
        assertEquals("M5 Competition", this.carRepository.read(updatedCar.getReg()).getType());
    }

    @Test
    public void delete()
    {
        this.carRepository.create(car1);
        System.out.println("Created car: " +car1.toString());
        this.carRepository.create(car2);
        System.out.println("Created car: " +car2.toString());
        this.carRepository.delete(car2.getReg());
        System.out.println("Deleted car2. All cars currently in array: " +this.carRepository.getAll());
        assertEquals(null, this.carRepository.read(car2.getReg()));
    }

    @Test
    public void read()
    {
        this.carRepository.create(car1);
        this.carRepository.create(car2);
        assertTrue(this.carRepository.read(car1.getReg()) instanceof Car);
        assertEquals(car1.hashCode(), this.carRepository.read(car1.getReg()).hashCode());
        System.out.println("Read this car: \n" +this.carRepository.read(car1.getReg()).toString() + "\n");
    }

    @After
    public void tearDown() throws Exception
    {
        this.carRepository.removeAll();
    }
}