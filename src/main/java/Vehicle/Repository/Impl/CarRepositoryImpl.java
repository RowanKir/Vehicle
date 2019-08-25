package Vehicle.Repository.Impl;

import Vehicle.Domain.Car;

import java.util.HashMap;

//Class extends from IRepo
public interface CarRepositoryImpl extends IRespository<Car, String>
{
    void removeAll();
    HashMap<String, Car> getAll();
}
