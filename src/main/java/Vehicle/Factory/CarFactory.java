package Vehicle.Factory;

import Vehicle.Domain.Car;

public class CarFactory
{
    public static Car getCar(String reg, int model, String name, String type)
    {
        return new Car.CarBuilder()
                .name(name)
                .type(type)
                .reg(reg)
                .model(model)
                .build();
    }
}
