package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.rootvegetable.Carrot;

public class CarrotCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Carrot();
    }
}
