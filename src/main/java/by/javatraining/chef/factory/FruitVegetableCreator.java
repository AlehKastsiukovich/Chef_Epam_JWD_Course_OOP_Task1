package by.javatraining.chef.factory;

import by.javatraining.chef.entity.FruitVegetable;
import by.javatraining.chef.entity.Vegetable;

public class FruitVegetableCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new FruitVegetable();
    }
}
