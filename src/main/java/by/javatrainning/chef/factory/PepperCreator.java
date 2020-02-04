package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.fruitvegetable.Pepper;

public class PepperCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Pepper();
    }
}
