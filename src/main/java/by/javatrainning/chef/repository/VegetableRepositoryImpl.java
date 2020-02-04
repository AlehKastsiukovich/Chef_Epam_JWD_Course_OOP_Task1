package by.javatrainning.chef.repository;

import by.javatrainning.chef.entity.Vegetable;
import java.util.Set;

public class VegetableRepositoryImpl implements VegetableRepository{
    private Set<Vegetable> data;

    @Override
    public void addVegetable(Vegetable vegetable) {
        data.add(vegetable);
    }

    @Override
    public void removeVegetable(Vegetable vegetable) {
        data.remove(vegetable);
    }

    @Override
    public Set<Vegetable> getCollection() {
        return data;
    }

    public Set<Vegetable> getData() {
        return data;
    }

    public void setData(Set<Vegetable> data) {
        this.data = data;
    }
}
