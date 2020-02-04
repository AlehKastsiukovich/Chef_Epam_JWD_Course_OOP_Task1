package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.leafyvegetable.Lettuce;

public class LettuceCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Lettuce();
    }
}
