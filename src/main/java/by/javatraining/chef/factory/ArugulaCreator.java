package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.leafyvegetable.Arugula;

public class ArugulaCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Arugula();
    }
}
