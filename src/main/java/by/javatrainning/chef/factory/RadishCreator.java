package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.rootvegetable.Radish;

public class RadishCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Radish();
    }
}
