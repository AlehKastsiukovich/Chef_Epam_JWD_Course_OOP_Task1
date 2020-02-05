package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.leafyvegetable.Spinach;

public class SpinachCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Spinach();
    }
}
