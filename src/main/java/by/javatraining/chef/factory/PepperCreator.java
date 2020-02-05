package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.fruitvegetable.Pepper;

public class PepperCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Pepper();
    }
}
