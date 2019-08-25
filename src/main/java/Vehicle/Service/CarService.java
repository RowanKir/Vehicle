package Vehicle.Service;

import Vehicle.Domain.Car;
import Vehicle.Repository.CarRepository;
import Vehicle.Service.Impl.CarServiceImpl;

import java.util.HashMap;

public class CarService implements CarServiceImpl {

    private CarRepository carRepository;


    @Override
    public void removeAll() {

    }

    @Override
    public HashMap<String, Car> getAll() {
        return null;
    }

    @Override
    public Car create(Car car) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Car read(String s) {
        return null;
    }
}
