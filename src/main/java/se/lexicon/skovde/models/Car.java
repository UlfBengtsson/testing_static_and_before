package se.lexicon.skovde.models;

public class Car {
    private static int counterId = 0;

    private final int id;
    private String brand;
    private String modelName;

    public Car(String brand, String model)
    {
        id = ++counterId;
        this.brand = brand;
        modelName = model;
    }

    public String info()
    {
        return "Id: " + id
                + "\nBrand: " + brand
                + "\nModel: " + modelName;
    }

    public static int getCounterId() {
        return counterId;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public boolean setBrand(String brand) {
        brand = brand.trim();
        if(brand.isEmpty())
        {
            return false;
        }
        this.brand = brand;
        return true;
    }

    public String getModelName() {
        return modelName;
    }

    public boolean setModelName(String modelName) {
        modelName = modelName.trim();
        if (modelName.isEmpty())
        {
            return false;
        }
        this.modelName = modelName;
        return true;
    }
}
