package Vehicle.Domain;

import Vehicle.Factory.CarFactory;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class CarTest {

    //create two different objects of car
    Car car1 = CarFactory.getCar(UUID.randomUUID().toString(), 97, "BMW", "M5");
    Car car2 = CarFactory.getCar(UUID.randomUUID().toString(), 98, "Mercedes", "C63 AMG");


    @Test
    public void getName()
    {
        assertNotNull(car1.getName());                              //Test that name not null
        assertTrue(car1.getName() instanceof String);               //Test that name is a String
        assertNotEquals(car1.getName(), car2.getName());            //Test that first car object name is not the same as second car object name
        assertEquals(car1.getName(), "BMW");                 //Test that name is actually name given
        System.out.println("The first car is a " +car1.getName());
    }

    @Test
    public void getType()
    {
        assertNotNull(car1.getType());
        assertTrue(car1.getType() instanceof String);
        assertNotEquals(car1.getType(), car1.getModel());
        assertEquals(car1.getType(), "M5");
        System.out.println("The first car is a " +car1.getType() +" type");
    }

    @Test
    public void getReg()
    {
        assertNotNull(car1.getReg());
        assertTrue(car1.getReg() instanceof String);
        assertNotEquals(car1.getReg(), car2.getReg());
        System.out.println("Car registration is: " +car1.getReg());
    }

    @Test
    public void getModel()
    {
        assertNotNull(car1.getModel());
        assertNotEquals(car1.getModel(), car2.getName());
        System.out.println("Car model is: " +car1.getModel());
    }

    @Test
    public void testToString() {
        assertNotNull(car1.toString());
        assertTrue(car1.toString() instanceof String);
        assertNotEquals(car1.toString(), car2.getName());
        System.out.println(car1.toString());
    }
}