package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.rootvegetable.Carrot;

public class CarrotCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Carrot();
    }
}
