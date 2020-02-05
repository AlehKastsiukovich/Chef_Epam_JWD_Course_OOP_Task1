package by.javatraining.chef.entity;

import java.util.Set;
import java.util.TreeSet;

public class Salad {
    private String saladName;
    private Set<Vegetable> vegetableSet;

    public Salad() {
        vegetableSet = new TreeSet<>();
    }

    public Salad(Set<Vegetable> vegetableSet) {
        if (vegetableSet == null) {
            throw new NullPointerException();
        }

        this.vegetableSet = vegetableSet;
    }

    public Set<Vegetable> getListOfVegetables() {
        return vegetableSet;
    }

    public void setListOfVegetables(Set<Vegetable> vegetableSet) {
        if (vegetableSet == null) {
            throw new NullPointerException();
        }

        this.vegetableSet = vegetableSet;
    }

    public int hashCode() {
        int hash = 7;
        hash = hash * 31 + (saladName == null ? 0 : saladName.hashCode());
        for (Vegetable vegetable : vegetableSet) {
            hash = hash * 31 + vegetable.hashCode();
        }

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (this.getClass() != object.getClass())
            return false;
        Salad otherSalad = (Salad) object;
        if (!this.vegetableSet.equals(otherSalad.vegetableSet))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (Vegetable vegetable : vegetableSet) {
            stringBuilder.append(vegetable.toString());
            stringBuilder.append(", ");
        }
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }
}
