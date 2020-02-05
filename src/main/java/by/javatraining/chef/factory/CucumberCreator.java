package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.fruitvegetable.Cucumber;

public class CucumberCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Cucumber();
    }
}
