package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.leafyvegetable.Arugula;

public class ArugulaCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Arugula();
    }
}
