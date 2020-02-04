package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.fruitvegetable.Tomato;

public class TomatoCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Tomato();
    }
}
