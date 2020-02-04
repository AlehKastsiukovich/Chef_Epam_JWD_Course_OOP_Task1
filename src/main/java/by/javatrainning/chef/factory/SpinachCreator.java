package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.leafyvegetable.Spinach;

public class SpinachCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Spinach();
    }
}
