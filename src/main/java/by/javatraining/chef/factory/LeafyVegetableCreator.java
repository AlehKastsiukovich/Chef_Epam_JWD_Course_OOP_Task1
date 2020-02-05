package by.javatraining.chef.factory;

import by.javatraining.chef.entity.LeafyVegetable;
import by.javatraining.chef.entity.Vegetable;

public class LeafyVegetableCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new LeafyVegetable();
    }
}
