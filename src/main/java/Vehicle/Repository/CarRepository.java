package Vehicle.Repository;

import Vehicle.Domain.Car;
import Vehicle.Repository.Impl.CarRepositoryImpl;

import java.util.HashMap;

public class CarRepository implements CarRepositoryImpl{

    private HashMap<String, Car> carDB;
    private static CarRepository carRepository = null;

    private CarRepository()
    {
        this.carDB = new HashMap<>();
    }

    public static CarRepository getCarRepository()
    {
        if(carRepository == null)
        {
            carRepository = new CarRepository();
        }
        return carRepository;
    }

    @Override
    public void removeAll() {
        carDB.clear();
    }

    @Override
    public HashMap<String, Car> getAll() {
        return carDB;
    }

    @Override
    public Car create(Car car) {
        this.carDB.put(car.getName(), car);
        return car;
    }

    @Override
    public Car update(Car car) {
        Car carToBeDeleted = read(car.getName());
                if(carToBeDeleted != null)
                {
                    this.carDB.remove(carToBeDeleted.getName());
                }
                return create(car);
    }

    @Override
    public void delete(String s) {
        carDB.remove(s);
    }

    @Override
    public Car read(String s) {
        for(Car car : carDB.values())
        {
            if (car.getName().equals(s))
            {
                return car;
            }
        }
        return null;
    }
}
