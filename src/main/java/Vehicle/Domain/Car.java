package Vehicle.Domain;

public class Car
{
    //Variables
    private String name, type, reg;
    private int model;

    //Default constructor
    public Car()
    {
    }

    //Builder constructor
    private Car(CarBuilder carBuilder)
    {
        this.name = carBuilder.name;
        this.type = carBuilder.type;
        this.reg = carBuilder.reg;
        this.model = carBuilder.model;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getReg() {
        return reg;
    }

    public int getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", reg=" + reg +
                ", model=" + model +
                '}';
    }

    public static class CarBuilder
    {
        private String name, type;
        private String reg;
        private int model;

        public CarBuilder name(String name)
        {
            this.name = name;
            return this;
        }

        public CarBuilder type(String type)
        {
            this.type = type;
            return this;
        }

        public CarBuilder reg(String reg)
        {
            this.reg = reg;
            return this;
        }

        public CarBuilder model(int model)
        {
            this.model = model;
            return this;
        }

        public Car.CarBuilder copy (Car car)
        {
            this.name = name;
            this.type = type;
            this.reg = reg;
            this.model = model;

            return this;
        }

        public Car build()
        {
            return new Car(this);
        }
    }
}
