package Vehicle.Factory;

import Vehicle.Domain.Car;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class CarFactoryTest {

    @Test
    public void getCar()
    {
        Car car1 = CarFactory.getCar(UUID.randomUUID().toString(), 97, "BMW", "M5");

        assertNotNull(car1);
        assertTrue(car1 instanceof Car);
        assertEquals(car1.getName().equals("BMW"), true);
        System.out.println(car1.toString());
    }
}