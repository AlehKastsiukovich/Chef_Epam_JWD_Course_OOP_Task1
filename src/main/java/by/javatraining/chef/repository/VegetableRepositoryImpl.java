package by.javatraining.chef.repository;

import by.javatraining.chef.entity.Vegetable;
import java.util.Set;

public class VegetableRepositoryImpl implements VegetableRepository{
    private Set<Vegetable> data;

    public void addVegetable(Vegetable vegetable) {
        data.add(vegetable);
    }

    public void removeVegetable(Vegetable vegetable) {
        data.remove(vegetable);
    }

    public void updateVegetable(Vegetable vegetable) {

    }

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
