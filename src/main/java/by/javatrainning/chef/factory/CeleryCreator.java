package by.javatrainning.chef.factory;

import by.javatrainning.chef.entity.Vegetable;
import by.javatrainning.chef.entity.rootvegetable.Celery;

public class CeleryCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Celery();
    }
}
