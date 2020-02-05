package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.fruitvegetable.Tomato;

public class TomatoCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Tomato();
    }
}
