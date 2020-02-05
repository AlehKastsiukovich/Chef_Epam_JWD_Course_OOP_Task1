package by.javatraining.chef.entity.leafyvegetable;

import by.javatraining.chef.entity.Vegetable;
import by.javatraining.chef.entity.VegetableColor;
import by.javatraining.chef.entity.leafyvegetable.leafyenum.LeafyVegetableType;

public abstract class LeafyVegetable extends Vegetable {
    private LeafyVegetableType leafyVegetableType;

    public LeafyVegetable(double weight, double proteins, double carbohydrates,
                          double calories, VegetableColor color, LeafyVegetableType type) {
        super(weight, proteins, carbohydrates, calories, color);

        if (leafyVegetableType == null) {
            throw new NullPointerException();
        }

        leafyVegetableType = type;
    }

    public LeafyVegetableType getLeafyVegetableType() {
        return leafyVegetableType;
    }

    public void setLeafyVegetableType(LeafyVegetableType leafyVegetableType) {
        if (leafyVegetableType == null) {
            throw new NullPointerException();
        }

        this.leafyVegetableType = leafyVegetableType;
    }
}
