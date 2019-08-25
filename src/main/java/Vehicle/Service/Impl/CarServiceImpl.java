package Vehicle.Service.Impl;

import Vehicle.Domain.Car;

import java.util.HashMap;

public interface CarServiceImpl extends IService<Car, String>{
    void removeAll();
    HashMap<String, Car> getAll();
}
