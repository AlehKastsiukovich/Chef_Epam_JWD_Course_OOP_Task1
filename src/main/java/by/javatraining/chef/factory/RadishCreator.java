package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.rootvegetable.Radish;

public class RadishCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Radish();
    }
}
