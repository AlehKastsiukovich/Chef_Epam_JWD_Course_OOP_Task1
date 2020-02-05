package by.javatraining.chef.factory;

import by.javatraining.chef.entity.RootVegetable;
import by.javatraining.chef.entity.Vegetable;

public class RootVegetableCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new RootVegetable();
    }
}
