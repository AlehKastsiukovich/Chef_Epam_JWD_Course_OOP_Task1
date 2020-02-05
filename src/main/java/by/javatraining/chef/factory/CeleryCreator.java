package by.javatraining.chef.factory;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.rootvegetable.Celery;

public class CeleryCreator implements VegetableCreator {

    @Override
    public Vegetable createVegetable() {
        return new Celery();
    }
}
