package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.fruitvegetable.Cucumber;

public class CucumberCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Cucumber();
    }
}
