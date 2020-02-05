package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.leafyvegetable.Lettuce;

public class LettuceCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Lettuce();
    }
}
